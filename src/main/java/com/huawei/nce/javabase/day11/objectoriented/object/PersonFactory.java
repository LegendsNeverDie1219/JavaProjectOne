package com.huawei.nce.javabase.day11.objectoriented.object;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 22:25
 */
public class PersonFactory {
    private static Person person;

    private PersonFactory() {
    }

    public static Person newPrototypeInstance() {
        Address address = new Address();
        address.setType("Home");
        address.setValue("北京");
        person.setAddress(address);
        person.setAge(31);
        person.setName("Peter");
        return person;
    }
}
