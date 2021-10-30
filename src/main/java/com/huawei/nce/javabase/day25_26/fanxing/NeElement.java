package com.huawei.nce.javabase.day25_26.fanxing;

import lombok.*;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/27 22:52
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NeElement implements Comparable<NeElement>{
    private Long neId;
    private String neName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NeElement neElement = (NeElement) o;
        return Objects.equals(neId, neElement.neId) && Objects.equals(neName, neElement.neName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neId, neName);
    }


    @Override
    public int compareTo(NeElement obj) {
        int result = neId.compareTo(obj.getNeId());
        if  (result == 0) {
            return neName.compareTo(obj.getNeName());
        }
        return result;
    }
}
