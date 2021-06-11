package com.huawei.nce.javabase;


import org.springframework.util.StringUtils;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/6/6 17:57
 */
public class TestMatch {
    public static void main(String[] args) {
        String testString = "国w人";
        testString = "好好学学吧好好学习天天向上碎碎念亲亲我亲亲我";
        testString = "abc$de";
        testString = "aaa100";
       // testMatchAab(testString);
        String testString2 = "好好学学吧,好好学习,天天向上,碎碎念,亲亲我,亲亲我";
        testMatchAabByJava(testString2);
    }

    private static void testMatchAabByJava(String testString) {
        if (StringUtils.isEmpty(testString) && testString.length() < 3) {
            return;
        }
        HashSet set = new HashSet();
        int jumpIndex = -1;
        char[] chars = testString.toCharArray();
        // chars.for  chars.fori
        for (int i = 0; i < chars.length-2; i++) {
            char a = chars[i];
            char b = chars[i + 1];
            char c = chars[i + 2];
            if (a == '\u0000' || b == '\u0000' || c == '\u0000' || i == jumpIndex) {
                continue;
            }
            if (a == b && b != c) {
                String aab = a + Character.toString(b) + c;
                set.add(aab);
                jumpIndex = i+2;
            }
        }
      set.stream().forEach(System.out::println);
    }

    private static void testMatchAab(String testString) {
        // 匹配字符串中出现的第一个中文字符
        String regexExpression = "[\u4e00-\u9fa5]";
        // 匹配一个中文字符串(所有字符都必须是中文字符)
        regexExpression = "^[\u4e00-\u9fa5]*$";
        // 匹配 $d( \$是一个正则表达式, 由于\在java中是一个特殊字符,所以需要进行转移.)
        regexExpression = "\\$d";
        regexExpression = "a.\\d";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(testString);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
