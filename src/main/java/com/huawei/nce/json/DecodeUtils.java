package com.huawei.nce.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/12/29 21:27
 */
public class DecodeUtils {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "%E5%AF%BC%E5%85%A5%E6%88%90%E5%8A%9F8%E6%9D%A1%EF%BC%8C%E5%A4%B1%E8%B4%A5%E6%9D%A10";
        String decode = URLDecoder.decode(str, "utf-8");
        System.out.println(decode);
    }
}
