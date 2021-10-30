package com.huawei.nce.javabase.day25_26.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/30 20:11
 */
public class FileTest2 {
    /**
     * 1. 利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File baseDir = new File("E:\\IOTest2\\");
        File dir1 = new File(baseDir, "TestDir1");
        File dir2 = new File(baseDir, "TestDir2");
        if (!dir1.exists()) {
            dir1.mkdirs();
        }
        if (!dir2.exists()) {
            dir2.mkdirs();
        }
        File fileOne = new File(dir1, "fileOne.txt");
        File fileTwo = new File(dir1, "filTwo.txt");
        if (!fileOne.exists()) {
            fileOne.createNewFile();
        } else {
            boolean delete = fileOne.delete();
        }

        if (!fileTwo.exists()) {
            fileTwo.createNewFile();
        } else {
            fileTwo.delete();
        }
    }

    /**
     * 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     */
    @Test
    public void test2_1() {
        File directory = new File("E:\\IOTest3");
        String[] list = directory.list();
        for (String fileName : list) {
            if (fileName.endsWith(".jpg")) {
                System.out.println(fileName);
            }
        }
    }

    @Test
    public void test2_2() {
        File directory = new File("E:\\IOTest3");
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".jpg")) {
                System.out.println(file.getName());
            }
        }
    }

    @Test
    public void test2_3() {
        File directory = new File("E:\\IOTest3");
//        File[] filterFiles = directory.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                return file.getName().endsWith(".jpg");
//            }
//        });
        File[] filterFiles = directory.listFiles(file -> file.getName().endsWith(".jpg"));

        for (File filterFile : filterFiles) {
            System.out.println(filterFile.getName());
        }
    }

    @Test
    public void test2_4() {
        File directory = new File("E:\\IOTest3");
        List<File> fileList = new ArrayList<>();
        findFileInDirectory(directory, fileList);
        List<File> filterFileList =
                fileList.stream().filter(file -> file.getName().endsWith(".jpg")).collect(Collectors.toList());
        filterFileList.forEach(System.out::println);
        Long size =
                filterFileList.stream().map(file -> file.length()).collect(Collectors.reducing(Long::sum)).get();
        System.out.println(size);

    }

    private void findFileInDirectory(File directory, List<File> fileList) {
        File[] fileArray = directory.listFiles();
        for (File fileOrDirectory : fileArray) {
            // 是目录就递归调用
            if (fileOrDirectory.isDirectory()) {
                findFileInDirectory(fileOrDirectory, fileList);
            } else {
                // 是文件就添加到集合中.
                fileList.add(fileOrDirectory);
            }
        }
    }

    /**
     * 遍历指定目录所有文件名称，包括子文件目录中的文件。 OK
     * 拓展1：并计算指定目录占用空间的大小 OK
     * 拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test3() {
        File directory = new File("E:\\IOTest3 - 副本");
        deleteFileInDirectory(directory);
    }

    private void deleteFileInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File fileOrDirectory : files) {
                if (fileOrDirectory.isDirectory()) {
                    deleteFileInDirectory(fileOrDirectory);
                } else {
                    fileOrDirectory.delete();
                }
            }
        }
        directory.delete();
    }
}
