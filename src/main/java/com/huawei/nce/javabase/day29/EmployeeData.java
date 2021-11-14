package com.huawei.nce.javabase.day29;

import java.util.ArrayList;
import java.util.List;
/**
 * 提供用于测试的数据
 * 
 * @author shkstart 邮箱：shkstart@126.com
 *
 */
public class EmployeeData {
	
	public static List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<>();
//		list.add(new Employee(1006L, "比尔盖茨", 42, 9500.43));
//		list.add(new Employee(1007L, "任正非", 26, 4333.32));
//		list.add(new Employee(1003L, "刘强东", 33, 3000.82));
//		list.add(new Employee(1004L, "雷军", 26, 7657.37));
//		list.add(new Employee(1005L, "李彦宏", 65, 5555.32));
//		list.add(new Employee(1001L, "马化腾", 34, 6000.38));
//		list.add(new Employee(1002L, "马云", 12, 9876.12));
//		list.add(new Employee(1008L, "扎克伯格", 35, 2500.32));



		list.add(new Employee(1006L, "BiErGaici", 42, 9500.43));
		list.add(new Employee(1007L, "RenZhengFei", 26, 4333.32));
		list.add(new Employee(1003L, "LiuQiangDong", 33, 3000.82));
		list.add(new Employee(1003L, "LeiJun", 26, 7657.37));
		list.add(new Employee(1004L, "LeiJun", 26, 7657.37));
		list.add(new Employee(1005L, "LiYanHong", 65, 5555.32));
		list.add(new Employee(1002L, "MaHuaTeng", 34, 6000.38));
		list.add(new Employee(1002L, "MaYun", 12, 9876.12));
		list.add(new Employee(1001L, "MaYun", 12, 9876.12));
		list.add(new Employee(1008L, "ZhaKeBoGe", 35, 2500.32));
		return list;
	}
	
}
