package com.huawei.nce.javabase.day17.team.view;


import com.huawei.nce.javabase.day17.team.domain.Employee;
import com.huawei.nce.javabase.day17.team.domain.Programmer;
import com.huawei.nce.javabase.day17.team.service.NameListService;
import com.huawei.nce.javabase.day17.team.service.TeamException;
import com.huawei.nce.javabase.day17.team.service.TeamService;


/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/4 15:49
 */
public class TeamView {
    private static NameListService nameListService = new NameListService();
    private static TeamService teamService = new TeamService();

    public static void main(String[] args) {
        enterMainMenu();
    }

    private static void enterMainMenu() {
        boolean loopCondition = true;
        char menuSelection = '0';
        do {
            // 1.展示所有员工信息
            if (menuSelection != '1') {
                showAllEmployInfo();
            }

            //2.展示菜单选项
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： ");
            menuSelection = TSUtility.readMenuSelection();
            switch (menuSelection) {
                case '1': {
                    showTeamList();
                    break;
                }
                case '2': {
                    addTeamMember();
                    break;
                }
                case '3': {
                    removeTeamMember();
                    break;
                }
                case '4': {
                    System.out.println("确认是否退出(Y/N)：");
                    char c = TSUtility.readConfirmSelection();
                    if (c == 'Y') {
                        loopCondition = false;
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (loopCondition);
    }

    private static void removeTeamMember() {
        System.out.print("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();

        System.out.print("确认是否删除(Y/N)：");
        char c = TSUtility.readConfirmSelection();
        if (c == 'N') {
            return;
        }

        try {
            teamService.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }

    private static void addTeamMember() {
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = nameListService.getEmployeeById(id);
            teamService.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }

    private static void showTeamList() {
        System.out.println("--------------------团队成员列表---------------------");
        Programmer[] team = teamService.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员！");
            return;
        }
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        for (Programmer programmer : team) {
            System.out.println(programmer.toStringTeamInfo());
        }
        System.out.println("-----------------------------------------------------");

    }

    private static void showAllEmployInfo() {
        System.out.println("-------------------------------开发团队调度软件--------------------------------");
        Employee[] allEmployees = nameListService.getAllEmployees();
        if (allEmployees != null && allEmployees.length > 0) {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (Employee allEmployee : allEmployees) {
                System.out.println(allEmployee);
            }
        } else {
            System.out.println("没有员工信息");
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
}
