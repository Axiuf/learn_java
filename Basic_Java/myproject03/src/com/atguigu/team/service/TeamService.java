package com.atguigu.team.service;

import com.atguigu.team.domain.*;

import java.time.Period;

public class TeamService
{
    private int counter = 1; // 给memberId赋值
    private int MAX_MEMBER = 5; // 限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存开发团队的成员
    private int total = 0; // 记录开发团队中实际的人数

    public TeamService()
    {
        super();
    }

    /**
     * @Description 获取开发团队中的所有成员
     * @return 返回在开发团队中的所有人
     */

    public Programmer[] getTeam()
    {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++)
        {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定的员工添加到团队当中
     * @param e 添加的成员
     */
    public void addMember(Employee e) throws TeamException
    {
        if (total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加");
        if (!(e instanceof Programmer))
            throw new TeamException("该员工不是开发人员，无法添加");
        if (isExist(e))
            throw new TeamException("该员工已在本开发团队中");
        Programmer p = (Programmer) e;
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME()))
            throw new TeamException("该员工已经是某团的成员");
        else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME()))
            throw new TeamException("该员工正在休假，无法添加");

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++)
        {
            if (team[i] instanceof Architect)
                numOfArch++;
            else if (team[i] instanceof Designer)
                numOfDes++;
            else if (team[i] instanceof Programmer)
                numOfPro++;
        }

        if (p instanceof Architect)
        {
            if (numOfArch >= 1)
                throw new TeamException("团队中最多只能有一名架构师");
        }
        else if (p instanceof Designer)
        {
            if (numOfDes >= 2)
                throw new TeamException("团队中最多只能有两名设计师");
        }
        else if (p instanceof Programmer)
        {
            if (numOfPro >= 3)
                throw new TeamException("团队中最多只能有三名程序员");
        }

        team[total] = p;
        total++;

        p.setStatus(Status.BUSY);
        p.setMemberId(counter);
        counter++;
    }

    public void removeMember(int memberId) throws TeamException
    {
        for (int i = 0; i < total; i++)
        {
            if (team[i].getMemberId() == memberId)
            {
                team[i].setStatus(Status.FREE);
                for (int j = i + 1; j < total; i++)
                {
                    team[j - 1] = team[j];
                }
                team[total - 1] = null;
                total--;
                break;
            }

            if (i == total - 1)
                throw new TeamException("找不到指定memberId的员工，删除失败");
        }



    }

    private boolean isExist(Employee e)
    {
        for (int i = 0; i < total; i++)
        {
            if (team[i].getId() == e.getId())
            {
                return true;
            }
        }

        return false;
    }
}