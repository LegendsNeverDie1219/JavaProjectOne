package com.huawei.nce.javabase.day18.multithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:18
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> getList(int index, int num) {
        return regionMapper.selectRegions(index, num);
    }

    @Override
    public int getCount() {
        return regionMapper.count();
    }
}
