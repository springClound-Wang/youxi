package com.husheng.youxi.util.phone;
import java.util.HashMap;
import java.util.Map;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.husheng.youxi.util.JsonUtil;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
public class SendSmsUtil {
    public static void main(String[] args) {
    	Map<String, String> map = SendSmsUtil.sendMsg("15074816437","146677");
    	System.out.println(map);
    }
    
    
    /**
     * 短信发送
     * @param phone
     * @return
     */
    public static Map<String, String> sendMsg(String phone,String random){
    	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIdmSJshoHjl27", "Rtxydu9q2lGjMKGkIOpal0CeyTWvMW");
        IAcsClient client = new DefaultAcsClient(profile);
        Map<String, String> map = new HashMap<>();
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ITBooking");
        request.putQueryParameter("TemplateCode", "SMS_172355201");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+random+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            map = JsonUtil.string2Obj(response.getData(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("Message", "fail");
            map.put("Code", "fail");
        }
        return map;
    }
}