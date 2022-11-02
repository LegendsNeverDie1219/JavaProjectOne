package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/31 17:03
 */

public class OtherIOStreamTest {
    /**
     *  System.in和System.out分别代表了系统标准的输入和输出设备
     *  默认输入设备是：键盘，输出设备是：显示器
     *  System.in的类型是InputStream
     *  System.out的类型是PrintStream，其是OutputStream的子类
     * FilterOutputStream 的子类
     */
    /**
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
     * 进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     */
   // public static void main(String[] args) {
   //     System.out.println("请输入信息:(退出输入e或者exit)");
   //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
   //
   //     try {
   //         String oneRowData = bufferedReader.readLine();
   //         while (oneRowData != null) {
   //             if ("e".equalsIgnoreCase(oneRowData)) {
   //                 System.out.println("安全退出");
   //                 break;
   //             }
   //             // 将这个行数据转化为大写输出.
   //             System.out.println("-->" + oneRowData.toUpperCase(Locale.ENGLISH));
   //             System.out.println("继续输入信息");
   //             oneRowData = bufferedReader.readLine();
   //         }
   //     } catch (IOException e) {
   //         e.printStackTrace();
   //     } finally {
   //         try {
   //             bufferedReader.close();
   //         } catch (IOException e) {
   //             e.printStackTrace();
   //         }
   //     }
   // }

    /**
     *  重定向：通过System类的setIn，setOut方法对默认设备进行改变。
     *  public static void setIn(InputStream in)
     *  public static void setOut(PrintStream out)
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testSystemInOut() {
        String property = System.getProperty("user.dir");
        BufferedReader bufferedReader = null;
        try {
            System.out.println("System.setIn() 重定向输入流,默认输入设备是键盘");
            System.setIn(new FileInputStream("Redirect.txt"));
            System.out.println("System.setOut() 重定向输出流,默认输出设备是控制台.");
            System.setOut(new PrintStream("Redirect.log"));


            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            // String property = System.getProperty("user.dir");
            System.setIn(new FileInputStream("Redirect.txt"));
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSystemIn() {
        // FileInputStream fileInputStream = null;
        // File file;
        try (FileInputStream fileInputStream = new FileInputStream("Redirect.txt")) {
            // String property = System.getProperty("user.dir");
            // fileInputStream = new FileInputStream("Redirect.txt");
            System.setIn(fileInputStream);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Test
    public void testSystemOut2() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream("Print.log"), true)) {
            System.setOut(printStream);
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
     *  数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
     *  DataInputStream 和 DataOutputStream
     *  分别“套接”在 InputStream 和 OutputStream 子类的流上
     *  DataInputStream中的方法
     * boolean readBoolean() byte readByte()
     * char readChar() float readFloat()
     * double readDouble() short readShort()
     * long readLong() int readInt()
     * String readUTF() void readFully(byte[] b)
     *  DataOutputStream中的方法
     *  将上述的方法的read改为相应的write即可。
     */
    @Test
    public void testDataStream1() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("destData.dat"))) {
            dataOutputStream.writeUTF("我爱北京天安门广场1219");
            dataOutputStream.writeBoolean(false);
            //dataOutputStream.writeInt(7758258);
            dataOutputStream.writeLong(123456789L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDataStream2() {
        // 我爱北京天安门广场
        //33321464383930368
        //482253
        //true
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("destData.dat"))) {
            String s = dataInputStream.readUTF();
            System.out.println(s);

//            int i = dataInputStream.readInt();
//            System.out.println(i);
            boolean b = dataInputStream.readBoolean();
            System.out.println(b);

            long l = dataInputStream.readLong();
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
