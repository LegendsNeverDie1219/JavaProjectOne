package com.huawei.nce.javabase.day18.multithread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:36
 */
@Slf4j
@Service
public class MultiThreadQueryServiceImpl implements MultiThreadQueryService {

    private int corePoolSize = 4;
    private int maximumPoolSize = 8;
    private long keepAliveTime = 30L;

    @Override
    public List<List> getResult(BaseThreadServiceTemplate baseThreadServiceTemplate) {

        // cpu密集型 参考自己cpu核心数定义
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        // 查询数据库总记录数
        int count = baseThreadServiceTemplate.getCount();
        log.info("count=" + count);

        Map<String, String> splitMap = SplitUtil.splitMap(count, corePoolSize);

        // 封装Callable产生的结果
        List<Callable<List>> tasks = new ArrayList<>();
        for (int i = 1; i <= corePoolSize; i++) {
            String[] split = splitMap.get(String.valueOf(i)).split(":");
            // 查询结果的索引值
            int index = Integer.parseInt(split[0]);
            // 查询的数量
            int num = Integer.parseInt(split[1]);
            // 获得结果
            Callable<List> res = new ThreadQuery<>(() -> baseThreadServiceTemplate.getList(index, num));
            tasks.add(res);
        }

        // 封装查询数据结果集
        List<List> result = new ArrayList<>();
        try {
            // Future获取结果
            List<Future<List>> futures = executorService.invokeAll(tasks);
            if (futures != null && futures.size() > 0) {
                // 迭代结果
                for (Future<List> future : futures) {
                    result.addAll(future.get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorService.shutdown();
            while (true){
                if (executorService.isTerminated()){
                    log.info("任务已完成");
                    break;
                }
            }
        }
        return result;
    }
}


