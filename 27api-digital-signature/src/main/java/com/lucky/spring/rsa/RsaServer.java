package com.lucky.spring.rsa;

import com.lucky.spring.util.RSA2Util;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by zhangdd on 2020/11/23
 */
@RestController
public class RsaServer {

    // 公钥
    private final static String PUBLIC_KEY = "";

    @PostMapping(value = "/api/demo")
    public String server(HttpServletRequest request, @RequestBody
            Map<String, String> param) throws UnsupportedEncodingException {
        // 校验请求是否过期
        String timestamp = request.getHeader("x-timestamp");
        if (timestamp.isEmpty()) {
            return "报文头 x-timestamp 不存在，非法请求";
        }
        // 从报文中取出签名字符串
        String sign = request.getHeader("x-sign");
        if (sign.isEmpty()) {
            return "报文头 x-sign 不存在，非法请求";
        }
        long oldtimestamp = Long.valueOf(timestamp);
        long curtimestamp = System.currentTimeMillis();
        long minute = (curtimestamp - oldtimestamp) / (1000 * 60);
        if (minute > 5) {
            return "请求过期";
        }
        // 对签名字符串进行 url 解码
        String decodeSign = URLDecoder.decode(sign, "UTF-8");
        // 将签名的参数内容按参数名的字典顺序进行排序，并拼接为字符串
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-timestamp", timestamp);
        headers.set("x-nonce", request.getHeader("x-nonce"));
        headers.set("x-code", request.getHeader("x-code"));
        String paramStr =
                RSA2Util.buildParamStr(headers, request.getMethod().toUpperCase(),
                        param);
        // 使用公钥进行验签
        boolean result =
                RSA2Util.buildRSAVerifyByPublicKey(paramStr, PUBLIC_KEY, decodeSign);
        if (result) {
            return "签名验证成功";
        }
        return "签名验证失败，非法请求";
    }
}

