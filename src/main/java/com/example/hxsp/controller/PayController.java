package com.example.hxsp.controller;

import com.example.hxsp.bean.OrderInfo;
import com.example.hxsp.config.WechatAccountConfig;
import com.example.hxsp.service.OrderInfoService;
import com.example.hxsp.utils.RequestHandler;
import com.example.hxsp.utils.XMLUtil;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.*;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 支付相关
 * @version 1.0 2017/3/2
 * @auther <a href="mailto:lly835@163.com">廖师兄</a>
 * @since 1.0
 */
@Controller
@Slf4j
@RequestMapping("hxsp/pay")
public class PayController {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 发起支付
     */
    @PostMapping(value = "/pay")
    @ResponseBody
    public PayResponse pay(@RequestParam(value = "openid", required = false) String openid,
                           @RequestParam BestPayTypeEnum payType,
                           @RequestParam String orderId,
                           @RequestParam Double amount,
                           @RequestParam(required = false) String buyerLogonId,
                           @RequestParam(required = false) String buyerId) {
        //支付请求参数
        PayRequest request = new PayRequest();
        request.setPayTypeEnum(payType);
        request.setOrderId(orderId);
        request.setOrderAmount(amount);
        request.setOrderName("最好的支付sdk");
        request.setOpenid(openid);
        request.setAttach("这里是附加的信息");

        if (payType == BestPayTypeEnum.ALIPAY_H5) {
            request.setBuyerLogonId(buyerLogonId);
            request.setBuyerId(buyerId);
        }

        log.info("【发起支付】request={}", JsonUtil.toJson(request));

        PayResponse payResponse = bestPayService.pay(request);
        log.info("【发起支付】response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 微信h5支付，要求referer是白名单的地址，这里做个重定向
     * @param prepayId
     * @param packAge
     * @return
     */
    @GetMapping("/wxpay_mweb_redirect")
    public ModelAndView wxpayMweb(@RequestParam("prepay_id") String prepayId,
                                  @RequestParam("package") String packAge,
                                  Map map) {
        String url = String.format("https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=%s&package=%s", prepayId, packAge);
        map.put("url", url);
        return new ModelAndView("pay/wxpayMwebRedirect");
    }

    @GetMapping("/query")
	@ResponseBody
	public OrderQueryResponse query(@RequestParam String orderId,
                                    @RequestParam("platform") BestPayPlatformEnum platformEnum) {
		OrderQueryRequest orderQueryRequest = new OrderQueryRequest();
		orderQueryRequest.setOrderId(orderId);
		orderQueryRequest.setPlatformEnum(platformEnum);
		OrderQueryResponse queryResponse = bestPayService.query(orderQueryRequest);
		return queryResponse;
	}

    /**
     * 微信退款
     * @param orderId
     * @return
     */
    @GetMapping("/refund")
    @ResponseBody
    public RefundResponse refund(@RequestParam String orderId,@RequestParam String refundReasonWapImg,
                                 @RequestParam String refundReasonWapExplain,@RequestParam String refundReasonWap) {
        RefundResponse response=new RefundResponse();
        //查询订单详情
        OrderInfo orderInfo=orderInfoService.orderInfos(orderId);
        //判断是否已发货并且未退款的订单进行后台审核
        if (orderInfo.getStatus()==1&&orderInfo.getRefundStatus()==0){
            //提交退款审核
            orderInfoService.refund(orderId,refundReasonWapImg,refundReasonWapExplain,refundReasonWap);
        }else {
            RefundRequest request = new RefundRequest();
            request.setOrderId(orderId);
            request.setPayPlatformEnum(BestPayPlatformEnum.WX);
            request.setOrderAmount(orderInfo.getPayPrice().doubleValue());
            response = bestPayService.refund(request);
        }

        return response;
    }

    /**
     * 小程序支付
     * @param openid
     * @return
     */
    @GetMapping(value = "/miniPay")
    @ResponseBody
    public PayResponse minipay(@RequestParam(value = "openid") String openid,@RequestParam(value = "orderId") String orderId){

//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wechatAccountConfig.getMiniAppId()+"&secret="+wechatAccountConfig.getMiniAppSecret()+"&js_code="+code+"&grant_type=authorization_code";
//        RestTemplate restTemplate = new RestTemplate();
//        String userInfo = restTemplate.getForObject(url, String.class);

        //根据订单编号查询订单数据
        OrderInfo orderInfo=orderInfoService.orderInfos(orderId);

        //支付

        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(openid);
        payRequest.setOrderAmount(orderInfo.getPayPrice().doubleValue());
        payRequest.setOrderId(orderId);
        payRequest.setOrderName("购买海产品");
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_MINI);
        log.info("【发起支付】request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【发起支付】response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 发起支付
     */
    @GetMapping(value = "/alipay/pay")
    public ModelAndView aliPay(Map<String, Object> map) {
        PayRequest request = new PayRequest();
        Random random = new Random();
        //支付请求参数
        request.setPayTypeEnum(BestPayTypeEnum.ALIPAY_PC);
        request.setOrderId(String.valueOf(random.nextInt(1000000000)));
        request.setOrderAmount(0.01);
        request.setOrderName("最好的支付sdk");
        log.info("【发起支付】request={}", JsonUtil.toJson(request));
        PayResponse payResponse = bestPayService.pay(request);
        log.info("【发起支付】response={}", JsonUtil.toJson(payResponse));
        map.put("payResponse", payResponse);

        return new ModelAndView("pay/alipayPc", map);
    }

    /**
     * 异步回调
     */
//    @PostMapping(value = "/notify")
//    public String notify(@RequestBody String notifyData) {
//        log.info("【异步通知】支付平台的数据request={}", notifyData);
//        PayResponse response = bestPayService.asyncNotify(notifyData);
//        log.info("【异步通知】处理后的数据data={}", JsonUtil.toJson(response));
//        //修改订单支付状态
//        orderInfoService.sucPaid(response.getOrderId());
//        //返回成功信息给支付平台，否则会不停的异步通知
//         return "<xml> <return_code><![CDATA[SUCCESS]]></return_code> <return_msg><![CDATA[OK]]></return_msg> </xml>";
//    }

    /**
     * 异步回调
     */
    @RequestMapping(value = "/notify")
    public void notify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        log.info("【异步通知】支付平台的数据request={}", response);
        Map<String, Object> data = new HashMap<String, Object>();
        try {

            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String resultStr = new String(outSteam.toByteArray(), "UTF-8");
            Map<String, String> resultMap = null;
            try {
                resultMap = XMLUtil.doXMLParse(resultStr);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            System.out.println("微信回调结果:" + resultMap.toString());
            log.info("/success result=" + resultMap.toString());

            String out_trade_no = resultMap.get("out_trade_no");//第三方支付编号
            String transaction_id = resultMap.get("transaction_id");//微信支付订单号
            String return_code = resultMap.get("return_code");

            log.info("/return_code=" + return_code);
            // 签名验证
            // GenericValue userLogin = delegator.findOne("UserLogin",
            // UtilMisc.toMap("userLoginId", "admin"), false);
            if (return_code.equals("SUCCESS")) {

                // 此处就是你的逻辑代码
                // 修改数据库支付状态

            orderInfoService.sucPaid(out_trade_no);
                }

            // request.setAttribute("out_trade_no", out_trade_no);
            data.put("out_trade_no", out_trade_no);
            // 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
            response.getWriter().write(RequestHandler.setXML("SUCCESS", "OK"));
//			response.getOutputStream().write(new String("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>").getBytes());
//			response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[]]></return_msg></xml>");
            log.info("**************************微信支付异步回调通知结束***********************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @GetMapping("/pay/close")
    @ResponseBody
    public CloseResponse close(@RequestParam String orderId) {
        CloseRequest request = new CloseRequest();
        request.setPayTypeEnum(BestPayTypeEnum.ALIPAY_PC);
        request.setOrderId(orderId);

        CloseResponse close = bestPayService.close(request);
        return close;
    }
}
