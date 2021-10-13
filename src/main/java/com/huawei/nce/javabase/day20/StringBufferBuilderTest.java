package com.huawei.nce.javabase.day20;


import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/10 9:16
 */
public class StringBufferBuilderTest {
    /**
     * 一.数据结构
     * public final class StringBuffer extends AbstractStringBuilder implements java.io.Serializable, CharSequence
     * java.lang.StringBuffer 代表可变的字符序列,可以对字符进行增删,此时不会产生新的对象
     *  char[] value;  value 没有声明为final ,说明可以不断的扩容
     *  int count;    count记录有效字符的个数
     *  二.构造器
     *  StringBuffer 有四个构造器
     *  // 空参数构造器  初始化容量是16
     *   public StringBuffer() {}
     *   // 带参构造器1  指定容量 初始化容量 =指定容量
     *  public StringBuffer(int capacity) {}
     *  // 带参构造器2 指定Str  初始化容量 = 16+ str.length()
     *  public StringBuffer(String str) {}
     *  // 带参构造器3 指定字符序列
     *  public StringBuffer(CharSequence seq) {}
     *
     *  三.append() 扩容机制
     *   ensureCapacityInternal(count + len);
     *   str.getChars(0, len, value, count);
     *  1.首先检查字符数组当前容量
     *  2.如果已有的有效字符个数 + 待添加的字符串长度 >字符数组.length,   则需要扩容
     *   2.1确认新数组的容量
     *     默认扩容容量 = 原有容量* 2 + 2
     *     如果默认扩容容量 < 最小容量 则扩容容量更新为minCapacity
     *
     *     如果扩容容量 > Integer.MAX_VALUE 则会throw new OutOfMemoryError()
     *     如果 扩容容量 < 0, 则扩容容量更新为Integer.MAX_VALUE - 8
     *
     *   2.2进行数组的复制(public static char[] copyOf(char[] original, int newLength) 原始数组,要复制的副本长度.)
     *  3.扩容之后,将此字符串中的字符复制到扩容之后/没扩容的目标字符数组中
     *  4. 返回StringBuffer对象本身.
     */

    /**
     * String,StringBuffer,StringBuilder区别
     * String 不可变的字符序列
     * StringBuffer 可变的字符序列  几乎所有的公共方法都加synchronized关键字, 所以线程安全,但是效率低
     * StringBuild  可变的字符序列   线程不安全,效率高(jdK1.5新出)
     */
    /**
     * StringBuffer中常用的方法
     * 总结:
     * 增:  append(xxx) 用于字符序列的拼接
     * 删:delete(int start,int end ) 删除指定索引位置的字符序列
     * 改:
     * setCharAt(int n, char ch)
     * replace(int start,int end ,String str) 把[start,end)位置的字符串替换成str
     * 查:
     * charAt(int n)
     * indexOf(String str) 返回字符序列中子字符串str的下标
     * 插入:
     * insert(int offset,xxx) 在指定位置插入xxx
     * 长度:
     * int length()
     * 遍历:
     * for + charAt()  /toString()
     * 其他:
     * reverse() 把当前字符序列反转.
     * subString(int start,int end) 从当前字符序列中截取[start,end)的子字符串,并返回
     */
    @Test
    public void test1() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('2');
        s1.append("3");
        System.out.println(s1);

//        StringBuffer delete = s1.delete(2, 7);
//        // ab
//        System.out.println(delete);
//        // ab
//        System.out.println(s1);
//        s1.deleteCharAt(s1.length()-1);
//        System.out.println(s1);

//        s1.replace(2,4,"hello");
//        System.out.println(s1);
//        s1.setCharAt(s1.length()-1, 'N');
//        System.out.println(s1);

        System.out.println(s1.insert(2, "null"));
        System.out.println(s1.reverse());
    }

    @Test
    public void test2() {
        long startTime;
        long endTime;
        String str = "";
        // String
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            str += i;
        }
        endTime = System.currentTimeMillis();
        // 1277
        System.out.println("String: " + (endTime - startTime));
    }
    @Test
    public void test3() {
        long startTime;
        long endTime;
        StringBuffer stringBuffer = new StringBuffer();
        // StingBuffer
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            stringBuffer.append(i);
        }
        endTime = System.currentTimeMillis();
        // 90
        System.out.println("StringBuffer: " + (endTime - startTime));
    }

    @Test
    public void test4() {
        long startTime;
        long endTime;
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuilder.append(i);
        }
        endTime = System.currentTimeMillis();
        // 10
        System.out.println("StringBuilder: " + (endTime - startTime));
    }
}
