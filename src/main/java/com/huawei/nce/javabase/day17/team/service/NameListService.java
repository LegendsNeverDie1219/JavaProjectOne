package com.huawei.nce.javabase.day17.team.service;


import com.huawei.nce.javabase.day17.team.domain.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/4 0:07
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
    }

    public static void main(String[] args) {
        NameListService nameListService = new NameListService();
        Employee[] allEmployees = nameListService.getAllEmployees();
        for (Employee allEmployee : allEmployees) {
            System.out.println(allEmployee);
        }
        System.out.println("=====================================");
        try {
            Employee employee = nameListService.getEmployeeById(20);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee[] getAllEmployees() {
        // 将二维数组中的数据取出. 构建Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
        // 然后赋值给数组中的每一个元素,生成一个Employee[]数组..
        String[][] employees = Data.EMPLOYEES;
        Employee[] employeeArray = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            String[] employArrObj = employees[i];
            employeeArray[i] = getEmployeeFromArray(i, employArrObj);
        }

        return employeeArray;
    }

    public Employee getEmployeeById(int id) throws TeamException {
        String[][] employees = Data.EMPLOYEES;
        for (int i = 0; i < employees.length; i++) {
            String[] employArrObj = employees[i];
            int employeeId = Integer.parseInt(employArrObj[1]);
            if (employeeId == id) {
                return getEmployeeFromArray(i, employArrObj);
            }
        }
       throw new TeamException("你指定id对应的员工不存在");
    }

    /**
     * 根据下标和员工一维数组,生成员工对象.
     *
     * @param i i
     * @param employArrObj employArrObj
     * @return Employee
     */
    private Employee getEmployeeFromArray(int i, String[] employArrObj) {
        Employee employee = null;
        int type = Integer.parseInt(employArrObj[0]);
        int id = getIntTypeElement(employArrObj[1]);
        int age = getIntTypeElement(employArrObj[3]);
        double salary = getDoubleTypeElement(employArrObj[4]);
        switch (type) {
            case Data.EMPLOYEE: {
                employee = new Employee(id, employArrObj[2], age, salary);
                break;
            }
            case Data.PROGRAMMER: {
                employee = new Programmer(id, employArrObj[2], age, salary, createEquipment(Data.EQUIPMENTS[i]));
                break;
            }
            case Data.DESIGNER: {
                employee = new Designer(id, employArrObj[2], age, salary, createEquipment(Data.EQUIPMENTS[i]),
                        Double.parseDouble(employArrObj[5]));
                break;
            }
            case Data.ARCHITECT: {
                employee = new Architect(id, employArrObj[2], age, salary, createEquipment(Data.EQUIPMENTS[i]),
                        Double.parseDouble(employArrObj[5]), Integer.parseInt(employArrObj[6]));
                break;
            }
            default: {
                break;
            }
        }
        return employee;
    }

    private Equipment createEquipment(String[] equipment) {
        int type = Integer.parseInt(equipment[0]);
        Equipment equipmentObj = null;
        switch(type) {
            case Data.PC: {
                equipmentObj = new PC(equipment[1], equipment[2]);
                break;
            }
            case Data.NOTEBOOK: {
                equipmentObj = new NoteBook(equipment[1], getDoubleTypeElement(equipment[2]));
                break;
            }
            case Data.PRINTER: {
                equipmentObj = new Printer(equipment[1], equipment[2]);
                break;
            }
            default: {
                break;
            }
        }
        return equipmentObj;
    }

    private double getDoubleTypeElement(String s) {
        return Double.parseDouble(s);
    }

    private int getIntTypeElement(String s) {
        return Integer.parseInt(s);
    }
}
