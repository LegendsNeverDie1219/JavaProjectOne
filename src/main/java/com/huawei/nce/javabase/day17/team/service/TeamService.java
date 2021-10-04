package com.huawei.nce.javabase.day17.team.service;



import com.huawei.nce.javabase.day17.team.domain.*;

/**
 * 关于开发团队成员的管理：添加、删除
 *
 * @author Administrator
 * @date 2021/10/4 10:58
 */
public class TeamService {
    /**
     * 用来给开发人员的memberId赋值(自增长)
     */
    private static int counter;
    /**
     * 表示开发团队最大成员数
     */
    public static final int MAX_MEMBER_NUM = 5;
    /**
     * 开发团队成员的实际人数
     */
    private int totalMemberNum;
    /**
     * 开发团队各成员对象
     */
    private Programmer[] team = new Programmer[MAX_MEMBER_NUM];

    private static int architectNum;

    private static int designerNum;

    private static int programmerNum;

    /**
     * 返回当前团队的所有对象, 数组大小与成员人数一致
     *
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] actualTeam = new Programmer[totalMemberNum];
        for (int i = 0; i < actualTeam.length; i++) {
            actualTeam[i] = team[i];
        }
        return actualTeam;
    }

    /**
     * 向团队中添加成员
     * =======================
     * 失败信息包含以下几种：
     * 成员已满，无法添加
     * 该成员不是开发人员，无法添加
     * 该员工已在本开发团队中
     * 该员工已是某团队成员
     * 该员正在休假，无法添加
     * 团队中至多只能有一名架构师
     * 团队中至多只能有两名设计师
     * 团队中至多只能有三名程序员
     *
     * @param employee 待添加成员的对象
     *                 异常：添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee employee) throws TeamException {
        if (totalMemberNum >= MAX_MEMBER_NUM) {
            throw new TeamException("成员已满,无法添加");
        } else if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发成员,无法添加");
        }
        // 该员工已在本开发团队中
        Programmer programmer = (Programmer) employee;
        if (isExistInThisTeam(programmer)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        // 该员工已是某团队成员
        if (Status.BUSY.getNAME().equals(programmer.getStatus().getNAME())) {
            throw new TeamException("该员工已逝某团队的成员");
        }
        // 该员正在休假，无法添加
        if (Status.VOCATION.getNAME().equals(programmer.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假,无法添加");
        }

        //团队中至多只能有一名架构师
        if (programmer instanceof Architect) {
            if (architectNum < 1) {
                architectNum++;
            } else {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (designerNum < 2) {
                designerNum++;
            } else {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else {
            if (programmerNum < 3) {
                programmerNum++;
            } else {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        // 设置开发人员的团队id,设置状态,存入数组下标元素为null的位置.
        programmer.setMemberId(++counter);
        programmer.setStatus(Status.BUSY);
        team[totalMemberNum++] = programmer;
    }

    /**
     * 从团队中删除成员
     *
     * @param memberId 待删除成员的memberId
     * 异常：找不到指定memberId的员工，删除失败
     */
    public void removeMember(int memberId) throws TeamException {
        //找到指定memberId的员工, 设置状态为free
        int n = 0;
        for (; n < totalMemberNum; n++) {
            if (team[n].getMemberId() == memberId) {
                team[n].setStatus(Status.FREE);
                // 删除之后,原来团队的对应的个数也减一
                if (team[n] instanceof Architect) {
                    architectNum--;
                } else if (team[n] instanceof Designer){
                    designerNum--;
                } else {
                    programmerNum--;
                }
                break;
            }
        }
        // 如果遍历一遍，都找不到，则报异常
        if (n== totalMemberNum) {
            throw new TeamException("找不到指定成员id的员工,从该团队中删除员工失败");
        }
        //后面的元素覆盖前面的元素,
        for (int i = n+1; i < totalMemberNum; i++) {
            team[i-1] = team[i];
        }
        // 最后一个元素置为null,total减一
        team[totalMemberNum--] = null;
    }

    private boolean isExistInThisTeam(Programmer programmer) {
        int id = programmer.getId();
        for (int i = 0; i < totalMemberNum; i++) {
            if (team[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}
