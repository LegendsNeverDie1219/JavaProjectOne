package com.huawei.nce.javabase.day06.array;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/12 16:43
 */
public class YangHuiTest {
    /**
     * 使用二维数组打印一个 10 行杨辉三角。
     * 【提示】
     * 1. 第一行有 1 个元素, 第 n 行有 n 个元素
     * 2. 每一行的第一个元素和最后一个元素都是 1
     * 3. 从第三行开始, 对于非第一个元素和最后一个元
     * 素的元素。即：
     * yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j]
     */
    public static void main(String[] args) {
        int[][]  yangHuiArray = new int[10][];
        for (int i = 0; i < yangHuiArray.length; i++) {
            yangHuiArray[i] = new int[i+1];
            for (int j = 0; j <=i; j++) {
                //给每一行的第一个元素,和最后一个元素赋值 1
                if (j == 0 || j == i) {
                    yangHuiArray[i][j] = 1;
                } else {
                    yangHuiArray[i][j] = yangHuiArray[i-1][j-1] + yangHuiArray[i-1][j];
                }
            }
        }

//        for (int i = 0; i < yangHuiArray.length; i++) {
//            yangHuiArray[i] = new int[i+1];
//            // 给每一行的第一个元素,和最后一个元素赋值 1
//            yangHuiArray[i][0] = yangHuiArray[i][i] = 1;
//            // 从第三行开始
//            if(i >= 2) {
//                // 从每一行的第二个元素开始到最后一个元素结束.
//                for (int j = 1; j <= i-1 ;j++) {
//                    yangHuiArray[i][j] = yangHuiArray[i-1][j-1] + yangHuiArray[i-1][j];
//                }
//            }
//        }
        for(int[] hangArray : yangHuiArray) {
            for (int element: hangArray) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
