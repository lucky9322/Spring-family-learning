package com.lucky.spring.util;

import com.alibaba.druid.filter.config.ConfigTools;

import static com.alibaba.druid.filter.config.ConfigTools.encrypt;
import static com.alibaba.druid.filter.config.ConfigTools.genKeyPair;

/**
 * Created by zhangdd on 2020/7/20
 */
public class DruidEncryptUtil {


    public static void encryptPsd(String password) throws Exception {
        String[] arr = genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + encrypt(arr[0], password));
    }

    public static void decrypt() throws Exception {
        String decrypt = ConfigTools.decrypt("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJepKTSC1MBUiJs11MoF950C2jnLXw2mo9uhPdvFwPrkJQZ158ZEefXPsEn8AzYNBgXQciKDQsNL68cPdkB6MGkCAwEAAQ==",
                "NVExP0vZbdP7+/K2ppa/oi+oIG/TZRemZjYXyiZQSQPhbQm9FTm8UcsJtcbxUE8QT09Zo9GHAmvKTa0+IEqbIA==");
        System.out.println(decrypt);
    }

    public static void main(String[] args) throws Exception {
        encryptPsd("12345678");
        decrypt();
    }
}
