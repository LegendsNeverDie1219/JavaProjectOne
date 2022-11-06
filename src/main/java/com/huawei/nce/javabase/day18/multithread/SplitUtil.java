package com.huawei.nce.javabase.day18.multithread;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:36
 */
public class SplitUtil {

    // 根据查询记录数和线程数量分配每条线程查询记录数
    public static Map<String, String> splitMap(int count, int threadCoreNum) {
        Map<String, String> splitMap = new HashMap<>(threadCoreNum);

        // 每个线程分配的查询记录数 todo 100 4
        int offsetNum = count / threadCoreNum; // 25
        int residue = count % threadCoreNum; // 0

        for (int i = 1; i <= threadCoreNum; i++) {
            if (i == 1) {
                // 1 -> 0:25
                splitMap.put(String.valueOf(i), i - 1 + ":" + offsetNum);
            } else if(i < threadCoreNum) {
                // 2 -> 25:25
                // 3 -> 50:25
                splitMap.put(String.valueOf(i), (i - 1) * offsetNum + ":" + offsetNum);
            } else {
                // 4 -> 75:25
                splitMap.put(String.valueOf(i), (i - 1) * offsetNum + ":" + offsetNum + residue);
            }
        }
        return splitMap;
    }
}
