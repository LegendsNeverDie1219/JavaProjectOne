package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 7:23
 */
public class GeometricObjectTest {
    public static void main(String[] args) {
        GeometricObject geometricObject1 = new Circle("white", 1.0, 2.0);
        GeometricObject geometricObject3 = new Rectangle("black", 2.0, 1.0, 3.0);
        System.out.println( geometricObject1.equalsArea(geometricObject3));
        System.out.println("======================================================================");
        GeometricObjectTest geometricObjectTest = new GeometricObjectTest();
        boolean b = geometricObjectTest.equalsArea(geometricObject1, geometricObject3);
        geometricObjectTest.displayGeometricObject(geometricObject1);
        geometricObjectTest.displayGeometricObject(geometricObject3);
        System.out.println("是否相等: " + b);
    }

    public void displayGeometricObject(GeometricObject geometricObject) {
        System.out.println(geometricObject.findArea());
    }

    public boolean equalsArea(GeometricObject obj1, GeometricObject obj2) {
        return obj1.findArea() == obj2.findArea();
    }
}
