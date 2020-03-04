package com.hdsx.webservice.common.util;

/**
 * @author wurenwu
 * @date 2019/9/9 - 15:21
 */

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jsms.api.SendSMSResult;
import cn.jsms.api.ValidSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;

public class JsmsUtil {
    protected static final Logger log = LoggerFactory.getLogger(JsmsUtil.class);
    //这两个码要先去极光短信注册申请和充值后才会生效
    private static final String appkey = "694e8e879c7347efa1fc40d8";
    private static final String masterSecret = "d441794e87a3e3d2eb6c38dc";

    public static void main(String[] args) {
        // 这里要填入你测试用的手机号和验证码
        sendTemplateSMS("手机号","验证码");
    }
    //这段是按照模板发送短信的代码。模板类似验证码模板，code替换验证码位置
    public static String sendTemplateSMS(String mobile,String code) {
        SMSClient client = new SMSClient(masterSecret, appkey);
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(mobile)
                .setTempId(1)
                .addTempPara("code", code)
                .build();
        try {
            SendSMSResult res = client.sendSMSCode(payload);
            log.info(res.toString());
            return res.getMessageId();
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        }
        return "50105";
    }

    public static String getMessage(int code) {
        if (code == 50000) {
            return "请求成功";
        } else {
            return "获取验证码失败，请稍后再试";
        }
    }

    private static final Random RANDOM = new SecureRandom();


    /**
     * 获取长度为 6 的随机数字
     * 随机数字
     * 修改日志：由 space 创建于 2018-8-2 下午2:43:51
     */
    public static String getNonce_str() {
//        return StringUtils.leftPad(new Random().nextInt(10000) + "", 4, "0");
        StringBuilder stringBuilder = new StringBuilder();
        String str = "0123456789";
        for (int i = 0; i < 6; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }


    /**
     * 校验短信验证码
     * @param code
     * @param msgId
     * @return
     */
    public static Boolean checkSms(String msgId,String code) {
        SMSClient client = new SMSClient(masterSecret, appkey);
        try {
            ValidSMSResult res = client.sendValidSMSCode(msgId, code);
            return res.getIsValid();
        } catch (APIConnectionException e) {
            log.error("校验短信验证码出现异常：", e);
            return Boolean.FALSE;
        } catch (APIRequestException e) {
            log.error("校验短信验证码出现异常：HTTP Status: ", e.getStatus() + "Error Message: " + e.getMessage());
            return Boolean.FALSE;
        }
    }

    //根据极光短信模板ID，发送对应的审核信息通知
    public static String sendTemplateMSG(String mobile, int templateId, String wscode, String wsname) {
        SMSClient client = new SMSClient(masterSecret, appkey);
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(mobile)
                .setTempId(templateId)
                .addTempPara("wscode",wscode)
                .addTempPara("wsname",wsname)
                .build();
        try {
            SendSMSResult res = client.sendTemplateSMS(payload);
            log.info(res.toString());
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        }
        return "50105";
    }

}
