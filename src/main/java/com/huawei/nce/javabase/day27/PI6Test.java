package com.huawei.nce.javabase.day27;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/6 9:02
 */
public class PI6Test {
    public static void main(String[] args) {
        /**
         * create table service_interface_view_filter
         * (
         *     id            int auto_increment,
         *     regionId      int          null,
         *     regionName    varchar(256) null,
         *     subRegionName varchar(256) null,
         *     ringId        int          null,
         *     ringName      varchar(256) null,
         *     constraint service_interface_view_filter_id_uindex
         *         unique (id)
         * );
         */
        /**
         * 1.从region表中查询所有的记录
         * select id, regionName, subRegionName from region
         * 2.Ring和Region表关进行联查询,查询出所有的记录
         * select ring.id, ring.ringName, ring.regionId,region.regionName,region.subRegionName
         * from Ring ring left join Region region on ring.regionId = region.id
         * 3.将步骤2中记录和步骤1(缺失的设置为null)中记录合并起来,
         * 4.将1, null, null,null,null,null 也合并进去. 一起存入到service_interface_view_filter
         * 5.返回给前台 List<SelectedRegionVo> selectedRegionVos
         */


        List<Ring> rings = Lists.newArrayList(new Ring(1011L, "ringName1", 101L), new Ring());
        List<Ring> ring2s = Lists.newArrayList(new Ring(1021L, "ringName1", 102L), new Ring());

        SelectedSubRegionVo subRegionVo1 = new SelectedSubRegionVo(101L, "青山区", rings);
        SelectedSubRegionVo subRegionVo2 = new SelectedSubRegionVo(102L, "洪山区", ring2s);
        SelectedSubRegionVo subRegionVo3 = new SelectedSubRegionVo(103L, "黄鹤楼", null);
        List<SelectedSubRegionVo> selectedSubRegionVos = Lists.newArrayList(subRegionVo1, subRegionVo2, subRegionVo3);

        SelectedRegionVo selectedRegionVo = new SelectedRegionVo(10L, "武汉", selectedSubRegionVos);
        List<SelectedRegionVo> selectedRegionVos = Lists.newArrayList(selectedRegionVo);
        selectedRegionVos.forEach(regionVo -> {
            Long regionId = regionVo.getRegionId();
            String regionName = regionVo.getRegionName();
            List<SelectedSubRegionVo> subRegionVoList = regionVo.getSubRegionVoList();
            subRegionVoList.forEach(subRegionVo -> {
                Long subRegionId = subRegionVo.getRegionId();
                String subRegionName = subRegionVo.getSubRegionName();
                List<Ring> ringList = subRegionVo.getRing();
                if (ringList == null) {
                    System.out.println(subRegionName + ", " + subRegionId);
                }
                Optional.ofNullable(ringList).ifPresent(ringLists -> ringList.forEach(ring -> {
                    Long ringId = ring.getRingId();
                    String ringName = ring.getRingName();
                    Long regionOrSubRegionId = ring.getRegionId();
                    String ringSubRegionName = null;
                    if (regionOrSubRegionId != null) {
                        ringSubRegionName = regionOrSubRegionId.equals(subRegionId) ? subRegionName : null;
                    }
                    System.out.println("ring.toString(): " + regionName + ", " + ringSubRegionName + ", " + regionOrSubRegionId +
                            ", " + ringName + ", " + ringId);

                }));

            });
        });
        Map<String, Map<String, List<Ring>>> map = new HashMap<>();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class SelectedRegionVo {
    private Long regionId;
    private String regionName;
    private List<SelectedSubRegionVo> subRegionVoList;
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class SelectedSubRegionVo {
    private Long regionId;
    private String subRegionName;
    private List<Ring> ring;
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
class Ring {
    private Long ringId;
    private String ringName;
    private Long regionId;
}
