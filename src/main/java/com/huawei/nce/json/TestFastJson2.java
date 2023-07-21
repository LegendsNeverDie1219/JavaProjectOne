package com.huawei.nce.json;

import com.alibaba.fastjson.JSON;
import com.huawei.nce.pojo.THtAccMappingVO;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/12/27 18:26
 */
public class TestFastJson2 {
    @Test
    public void test1() {
        System.out.println("a44d44c983f0406b8bd8a5d50b41db18".length());

        String jsonStr = "[{\"compid\":\"9999\",\"currencyType\":\"10000000\",\"cusType\":2,\"isTemplate\":0," +
                "\"mapId\":\"96d0ce01c8664831af0f61162cdf989a\",\"mapState\":1,\"modelState\":1," +
                "\"recCreateTime\":\"\\\\/Date(1670230678000+0800)\\\\/\",\"recCreator\":0," +
                "\"recLastTime\":\"\\\\/Date(1670230678000+0800)\\\\/\",\"recModifier\":0,\"srcBillTypeId\":\"156\"," +
                "\"srcIsChild\":0,\"srcIsMain\":0,\"tarColCode\":\"OBJECT_ID\",\"tarColName\":\"对象编号\"," +
                "\"tarColType\":\"NUMBER\",\"tarIsChild\":0,\"tarIsMinus\":0,\"tarIsMustMap\":0," +
                "\"tarTableName\":\"T_HT_COLLECTION_SETTLEMENT\"},{\"compid\":\"9999\",\"currencyType\":\"10000000\"," +
                "\"cusType\":2,\"isTemplate\":0,\"mapId\":\"a6e4b88461cf4c44845f2c8c0cbc7274\",\"mapState\":1," +
                "\"modelState\":1,\"recCreateTime\":\"\\\\/Date(1670230678000+0800)\\\\/\",\"recCreator\":0," +
                "\"recLastTime\":\"\\\\/Date(1670230678000+0800)\\\\/\",\"recModifier\":0,\"srcBillTypeId\":\"156\"," +
                "\"srcIsChild\":0,\"srcIsMain\":0,\"tarColCode\":\"AFL_UNIT\",\"tarColName\":\"所属单位\"," +
                "\"tarColType\":\"VARCHAR2\",\"tarIsChild\":0,\"tarIsMinus\":0,\"tarIsMustMap\":0," +
                "\"tarTableName\":\"T_HT_COLLECTION_SETTLEMENT\"}]";


        List<THtAccMappingVO> tHtAccMappingVOS = JSON.parseArray(jsonStr, THtAccMappingVO.class);
        tHtAccMappingVOS.stream().forEach(System.out::println);

    }
}
