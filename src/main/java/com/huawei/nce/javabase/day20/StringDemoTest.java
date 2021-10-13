package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/10 11:42
 */
public class StringDemoTest {
    /**
     * 1.模拟一个trim方法，去除字符串两端的空格。
     */
    public String myTrim(String str) {
        // 记录从前往后 第一个不为空格字符的位置的索引
        int indexOfFirstNotEmptyPos = 0;
        if (str != null) {
            // 记录从后往前 第一个不为空格字符的位置的索引
            int indexOfLastNotEmptyPos = str.length() - 1;
            while (indexOfFirstNotEmptyPos < indexOfLastNotEmptyPos && str.charAt(indexOfFirstNotEmptyPos) == ' ') {
                indexOfFirstNotEmptyPos++;
            }
            while (indexOfFirstNotEmptyPos < indexOfLastNotEmptyPos && str.charAt(indexOfLastNotEmptyPos) == ' ') {
                indexOfLastNotEmptyPos--;
            }
            if (str.charAt(indexOfFirstNotEmptyPos) == ' ') {
                return "";
            }
            // xx x1   1x   x1x
            return str.substring(indexOfFirstNotEmptyPos, indexOfLastNotEmptyPos + 1);
        }
        return null;
    }

    /**
     * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     */
    public String reverseOne(String str, int start, int end) {
        if (!checkStrParamValid(str, start, end)) {
            return null;
        }
        char[] charArray = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        return new String(charArray);
    }

    public String reverseTwo(String str, int start, int end) {
        if (!checkStrParamValid(str, start, end)) {
            return null;
        }
        String newString = str.substring(0, start);
        for (int i = end; i >= start; i--) {
            newString += str.charAt(i);
        }
        newString += str.substring(end + 1);
        return newString;
    }

    public String reverseThree(String str, int start, int end) {
        if (!checkStrParamValid(str, start, end)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str, 0, start);
        for (int i = end; i >= start; i--) {
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append(str.substring(end + 1));
        return stringBuilder.toString();
    }

    private boolean checkStrParamValid(String str, int start, int end) {
        if (str == null) {
            return false;
        }
        if (start < 0 || end > str.length() - 1) {
            throw new IndexOutOfBoundsException("数组索引越界1219");
        }
        if (start > end) {
            throw new IndexOutOfBoundsException("起始位置的索引超过了终止位置的索引");
        }
        return true;
    }

    /**
     * 3.获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
     * 中出现的次数
     */
    public int getCount(String mainStr, String subStr) {
        if (mainStr == null || subStr == null || mainStr.length() < subStr.length()) {
            return 0;
        }
        int count = 0;
        int fromIndex = 0;
        // 从指定索引位置开始,返回此字符串mainStr中第一次出现子字符串subStr的索引. 如果没有返回 -1
        int targetIndex = mainStr.indexOf(subStr, fromIndex);
        while (targetIndex != -1) {
            count++;
            fromIndex = targetIndex + subStr.length();
            targetIndex = mainStr.indexOf(subStr, fromIndex);
        }
        return count;
    }

    @Test
    public void test() {
//        String s = this.myTrim(" 1 23 4 ");
//        System.out.println(s);

//        String str = "abcdefg";
//        System.out.println(reverseOne(str, 2, 5));
//        System.out.println(reverseTwo("", 0, 6));
//        System.out.println(reverseThree(str, 2, 5));

//        System.out.println(getCount("abcabcccab", "ab"));
        String str1 = "abcwerthellouiodeflobnm";
        String str2 = "cvhellobnm";

        System.out.println(getMaxSameSubstr(str1, str2));
        System.out.println(Arrays.toString(getMaxSameSubstrTwo(str1, str2)));
    }

    /**
     * 4.获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
     * 提示：将短的那个串进行长度依次递减的子串与  较长的串比较。
     */
    public String getMaxSameSubstr(String strOne, String strTwo) {
        // 校验非空以及非空串.
        if (strOne == null || strTwo == null) {
            return null;
        }
        if (strOne.length() == 0 || strTwo.length() == 0) {
            return "";
        }
        // 获取相对较短的字符串
        String shorterStr = strOne.length() < strTwo.length() ? strOne : strTwo;
        String longerStr = strOne.length() > strTwo.length() ? strOne : strTwo;
        // 较短的字符串依次递减  与长的字符串进行比较
        for (int i = 0; i < shorterStr.length(); i++) { //0 1 2 3 4 此层循环决定要去几个字符
            // 这一层循环决定截取字符串的起始位置,终止位置.
            for (int j = 0; j <= i; j++) {
                // 作差恒为: shorterStr.length()- i
                // [0, shorterStr.length()-i-0) [1, shorterStr.length()-i+1) [i,shorterStr.lenth()-i +i)
                String subShorterStr = shorterStr.substring(j, shorterStr.length() - i + j);
                if (longerStr.contains(subShorterStr)) {
                    return subShorterStr;
                }
            }
        }
        return "";
    }

    public  String[] getMaxSameSubstrTwo(String strOne, String strTwo) {
        // 校验非空以及非空串.
        if (strOne == null || strTwo == null) {
            return null;
        }
        if (strOne.length() == 0 || strTwo.length() == 0) {
            return  new String[0];
        }
        // 获取相对较短的字符串
        String shorterStr = strOne.length() < strTwo.length() ? strOne : strTwo;
        String longerStr = strOne.length() > strTwo.length() ? strOne : strTwo;
        StringBuilder stringBuilder = new StringBuilder();
        // 较短的字符串依次递减  与长的字符串进行比较
        for (int i = 0; i < shorterStr.length(); i++) { //0 1 2 3 4 此层循环决定要去几个字符
            for (int j = 0; j <= i; j++) {
                // 作差恒为: shorterStr.length()- i
                // [0, shorterStr.length()-i-0) [1, shorterStr.length()-i+1) [i,shorterStr.lenth()-i +i)
               String subShorterStr = shorterStr.substring(j, shorterStr.length() - i + j);
                if (longerStr.contains(subShorterStr)) {
                    stringBuilder.append(subShorterStr).append(',');
                }
            }
            if (stringBuilder.length() != 0) {
                System.out.println(stringBuilder);
                break;
            }
        }

        return stringBuilder.toString().replaceAll(",$", "").split(",");
    }
    /**
     * 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
     * 提示：
     * 1）字符串变成字符数组。
     * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
     * 3）将排序后的数组变成字符串。
     */
    @Test
    public void testSort() {
        String str = "abcwerthelloyuiodef";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String newStr = new String(charArray);
        System.out.println(newStr);
    }

}
