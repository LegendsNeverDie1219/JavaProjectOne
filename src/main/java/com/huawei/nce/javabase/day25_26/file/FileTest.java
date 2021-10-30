package com.huawei.nce.javabase.day25_26.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/30 16:02
 */
public class FileTest {
    /**
     * 1.java.io.File 文件和文件目录的抽象表示形式  与平台/操作系统无关.
     * 2.File 可以新建/删除/重命名  文件/文件目录. 但是不可以操作文件中的具体内容.
     *   如果要操作 ,则需要new输入输出流.
     *  3. 如果想表示磁盘中的某一个文件/文件目录. 则必须要new 一个File对象
     *     反之,如果new了一个File对象.则并不一定这个文件/文件目录真实存在.
     *          文件/文件路径 真实存在, 则 File 对象的属性有值.
     *          文件/文件路径 不存在.  则File 对象中的属性为null;
     * 4.File对象可以作为入参 传递给流的构造器.
     */

    /**
     * 1.File常用的三种构造器:
     * public File(String pathName)
     * public File(String parentPathName, String childPathName)
     * public File(File ParentFile, String childPathName)
     *
     * 2.其中pathName
     * 可以为绝对路径,即 D:\\aaa.txt. 带上了盘符.
     * 可以为相对路径.(System.getProperties("user.dir")表示的路径 (默认不写)+ 文件名)
     *
     * 3.路径分隔符:
     * windows: \\
     * linux: /
     * 统一形式: File.separator
     */
    @Test
    public void test1() {
        String str = File.separator;
        // File.separator: \
        System.out.println("File.separator: " + str);
        String prefix = System.getProperty("user.dir");
        // System.getProperty("user.dir"): E:\IdeaProjects\javaproject\JavaModuleOne
        System.out.println("System.getProperty(\"user.dir\"): " + prefix);

        // 构造器1:
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\IdeaProjects\\javaproject\\JavaModuleOne\\src\\main\\java\\com\\huawei\\nce" +
                "\\javabase\\day25_26\\file\\hello.txt");
        // hello.txt
        System.out.println(file1);
        // E:\IdeaProjects\javaproject\JavaModuleOne\src\main\java\com\huawei\nce\javabase\day25_26\file\hello.txt
        System.out.println(file2);

        // 构造器2:
        // E:\IdeaProjects\javaproject\JavaModuleOne\src\main\java\com\huawei\nce\javabase\day25_26\file
        File fileDirectory = new File("E:\\IdeaProjects\\javaproject\\JavaModuleOne\\src\\main\\java\\com\\huawei" +
                "\\nce" +
                "\\javabase\\day25_26", "file");
        // 构造器3:
        File file3 = new File(fileDirectory, "hello2.txt");
        // fileDirectory: E:\IdeaProjects\javaproject\JavaModuleOne\src\main\java\com\huawei\nce\javabase\day25_26\file
        System.out.println("fileDirectory: " + fileDirectory);
        // file3: E:\IdeaProjects\javaproject\JavaModuleOne\src\main\java\com\huawei\nce\javabase\day25_26\file\hello2.txt
        System.out.println("file3: " + file3);
    }

    /**
     * public String getAbsolutePath(): 获取绝对路径
     * public String getPath() 获取路径
     * public String gerName() 获取名称
     * public String getParent() :获取上层文件路径,如果没有,则为null
     * public long length() 获取文件长度(文件所占字节大小) 不能获取文件目录的长度.
     * public long lastModified() 获取最后一次修改的时间. 毫秒值.
     *
     *
     * public String[] list() 获取该文件目录下包含的所有子文件目录, 文件的名称数组
     * public File[] listFiles() 获取该文件目录下包含的所有子文件目录, 文件的File数组
     *
     *
     */
    @Test
    public void test2() {
        File file1 = new File("hello1.txt");
        //E:\IdeaProjects\javaproject\JavaModuleOne\hello.txt
        // E:\IdeaProjects\javaproject\JavaModuleOne\hello1.txt
        System.out.println(file1.getAbsoluteFile());
        //hello.txt
        // hello1.txt
        System.out.println(file1.getPath());
        //hello.txt
        // hello1.txt
        System.out.println(file1.getName());
        //null
        // null
        System.out.println(file1.getParent());
        //7
        // 0
        System.out.println(file1.length());
        //1633166311097
        // 0
        System.out.println(file1.lastModified());

        System.out.println("========================================================================");
        File file2 = new File("E:\\io\\hi.txt");
        // E:\io\hi.txt
        //E:\io\hi1.txt
        System.out.println(file2.getAbsoluteFile());
        //E:\io\hi.txt
        //E:\io\hi1.txt
        System.out.println(file2.getPath());
        //hi.txt
        // hi1.txt
        System.out.println(file2.getName());
        //E:\io
        // E:\io
        System.out.println(file2.getParent());
        //6
        // 0
        System.out.println(file2.length());
        //1635584075081
        // 0
        System.out.println(file2.lastModified());
        System.out.println("========================================================================");
    }

    @Test
    public void test3() {
        File fileDirectory = new File("E:\\io1\\");
        //  如果文件不存在的话.会返回一个null.
        String[] list = fileDirectory.list();
        StringBuilder stringBuilder = new StringBuilder();
        // java.lang.NullPointerException
        for (String s : list) {
            stringBuilder.append(s).append(",");
        }
        // hi.txt,hi_2.txt,input,output
        System.out.println(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
        System.out.println("========================================================================");
        stringBuilder.delete(0,stringBuilder.length());
        File[] fileList = fileDirectory.listFiles();

        for (File file : fileList) {
            stringBuilder.append(file).append(",");
        }
        // E:\io\hi.txt,E:\io\hi_2.txt,E:\io\input,E:\io\output
        System.out.println(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
    }

    /**
     *  File类的重命名功能
     *  public boolean renameTo(File dest):把文件重命名为指定的文件路径
     *  file1.rename(File file2)要想返回的结果为true. 要保证file1在磁盘中存在,并且file2在磁盘中不存在
     *  重命名: 在一个目录是重命名,不在一个目录下就是移动磁盘中文件
     */
    @Test
    public void test4() {
        File file1 = new File("E:\\io\\hello.txt");
        File file2 = new File("hello.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    /**
     *  public boolean isDirectory()：判断是否是文件目录
     *  public boolean isFile() ：判断是否是文件
     *  public boolean exists() ：判断是否存在
     *  public boolean canRead() ：判断是否可读
     *  public boolean canWrite() ：判断是否可写
     *  public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test5() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\io");
        System.out.println("file ===================================================");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println("Directory ================================================");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /**
     *  File类的创建功能
     *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     */
    /**
     * File类的删除功能
     *  public boolean delete()：删除文件或者文件夹
     * 删除注意事项：
     * Java中的删除不走回收站。
     * 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println("file.createNewFile() : " + newFile);
        } else {
            boolean delete = file.delete();
            System.out.println("file.delete(): " + delete);
        }
    }

    /**
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *   public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
     *  注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
     *   路径下。
     */
    @Test
    public void test7() {
        File file = new File("E:\\io\\io1");
        boolean mkdir = file.mkdir();
        System.out.println("file.mkdir(): "+ mkdir);

        File file2 = new File("E:\\io\\io2\\io22");
        boolean mkdir2 = file.mkdir();
        System.out.println("file.mkdir(): "+ mkdir2);

        File file3 = new File("E:\\io\\io2\\io22");
        boolean mkdir3 = file3.mkdirs();
        System.out.println("file.mkdir(): "+ mkdir3);
    }
    
    @Test
    public void test8() throws IOException {
        File dir1 = new File("E:\\IOTest\\dir1");
        File dir2 = new File(dir1, "dir2");
        if (!dir2.exists()) {
            boolean mkdirs = dir2.mkdirs();
            System.out.println("dir.mkidirs(): " + mkdirs);
        } else {
            File file = new File(dir2, "test.txt");
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("file.createNewFile() :" + newFile);
            }
        }
    }
}
