package controller;

import pojo.Classroom;
import pojo.Grade;
import pojo.StuClassRelation;
import pojo.Student;

import java.util.*;

/** @pdOid 859b8549-e9c0-44fd-845e-fbd1d15efee5 */
public class GradeController {


    /** @pdOid dbbd0994-81a2-4467-a4ff-2d5217cfcec9 */
    public int calTotal(Grade grade) {
        // TODO: implement

        return 0;
    }

    /** @pdOid 25021d1c-a471-4b0d-8c4e-b8bff95b9515 */
    public ArrayList<Grade> generateGrade(ArrayList<Student>students, ArrayList<Classroom>classrooms,
                              ArrayList<StuClassRelation>stuClassRelations) {
        // TODO: implement
        ArrayList<Grade> grades = new ArrayList<>();
        Random random = new Random();
        String[] course = {"软件工程","计算机网络","操作系统"};
        for (Student student:students)
        {
            int sid = student.getSid();
            String sname = student.getSname();
            for (StuClassRelation stuClassRelation:stuClassRelations)
            {
                Grade grade = new Grade();
                if(stuClassRelation.getSid()==sid) //找到课程班
                {
                    int classid = stuClassRelation.getClassid();
                    String semester = null;
                    String cname = null;
                    int cid = 0;
                    for (Classroom classroom:classrooms)
                    {
                        if (classroom.getClassid()==classid) //记录课程班信息
                        {
                            semester = classroom.getSemester();
                            cid = classroom.getCid();
                            cname = course[cid-1];
                            break;
                        }
                    }
                    grade.setSid(sid);
                    grade.setCid(cid);
                    grade.setCname(cname);
                    grade.setSname(sname);
                    grade.setDate(semester);
                    grade.setRegular(random.nextInt(21)+80);//随机生成成绩
                    grade.setMidterm(random.nextInt(61)+40);
                    grade.setLab(random.nextInt(21)+80);
                    grade.setEnd(random.nextInt(61)+40);
                    double rawTotal = 0.1 * grade.getRegular() + 0.1 * grade.getLab() +
                            0.2 * grade.getMidterm() + 0.6 * grade.getEnd();//原始成绩
                    int roundedTotal = (int) Math.round(rawTotal);//四舍五入
                    grade.setTotal(roundedTotal);
                    grades.add(grade);
                }
            }
        }
//        for (Grade grade: grades)
//        {
//            System.out.println(grade.getSname()+" "+grade.getCname()+" 总分："+grade.getTotal()+" 时间："+grade.getDate());
//        }
        return grades;
    }


    public void gradeRange(int cid,ArrayList<Grade>grades)
    {
        int a=0,b=0,c=0,d=0,e=0;
        switch (cid)
        {
            case 1:
                a=0;//0-60
                b=0;//60-70
                c=0;//70-80
                d=0;//80-90
                e=0;//90+
                for (Grade grade:grades)
                {
                    if (grade.getCid()==1)
                    {
                        if (grade.getTotal()<60)
                            a++;
                        else if (grade.getTotal() < 70) {
                            b++;
                        } else if (grade.getTotal() < 80) {
                            c++;
                        } else if (grade.getTotal() < 90) {
                            d++;
                        }
                        else e++;
                    }
                }
                System.out.println("软件工程分数分布为："+"[0,60):"+a+"人 "+"[60,70):"+b+"人 "+
                        "[70,80):"+c+"人 "+"[80,90):"+d+"人 "+"[90,100]:"+e+"人");
                break;
            case 2:
                a=0;
                b=0;
                c=0;
                d=0;
                e=0;
                for (Grade grade:grades)
                {
                    if (grade.getCid()==2)
                    {
                        if (grade.getTotal()<60)
                            a++;
                        else if (grade.getTotal() < 70) {
                            b++;
                        } else if (grade.getTotal() < 80) {
                            c++;
                        } else if (grade.getTotal() < 90) {
                            d++;
                        }
                        else e++;
                    }
                }
                System.out.println("计算机网络分数分布为："+"[0,60):"+a+"人 "+"[60,70):"+b+"人 "+
                        "[70,80):"+c+"人 "+"[80,90):"+d+"人 "+"[90,100]:"+e+"人");
                break;
            case 3:
                a=0;
                b=0;
                c=0;
                d=0;
                e=0;
                for (Grade grade:grades)
                {
                    if (grade.getCid()==3)
                    {
                        if (grade.getTotal()<60)
                            a++;
                        else if (grade.getTotal() < 70) {
                            b++;
                        } else if (grade.getTotal() < 80) {
                            c++;
                        } else if (grade.getTotal() < 90) {
                            d++;
                        }
                        else e++;
                    }
                }
                System.out.println("操作系统分数分布为："+"[0,60):"+a+"人 "+"[60,70):"+b+"人 "+
                        "[70,80):"+c+"人 "+"[80,90):"+d+"人 "+"[90,100]:"+e+"人");
                break;
            case 4:
                a=0;
                b=0;
                c=0;
                d=0;
                e=0;
                Collections.sort(grades,(g1,g2)->g1.getSid()-g2.getSid());
                int times = 0;
                int sum = 0;
                for (Grade grade:grades)
                {
                    if (times==2)
                    {
                        times=0;
                        sum+=grade.getTotal();
                        sum/=3;
                        if (sum<60)
                            a++;
                        else if (sum < 70) {
                            b++;
                        } else if (sum < 80) {
                            c++;
                        } else if (sum < 90) {
                            d++;
                        }
                        else e++;
                        sum = 0;
                        continue;
                    }
                    sum+=grade.getTotal();
                    times++;
                }
                System.out.println("总分分数分布为："+"[0,60):"+a+"人 "+"[60,70):"+b+"人 "+
                        "[70,80):"+c+"人 "+"[80,90):"+d+"人 "+"[90,100]:"+e+"人");
                break;
        }
    }

    public void showRank(int cid, ArrayList<Grade>grades)
    {
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        switch (cid)
        {
            case 1:
                for (Grade grade:grades)
                {
                    if (grade.getCid()==1)//筛选课程分数
                        gradeArrayList.add(grade);
                }
                Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());//降序排名
                for (int i=1;i<=120;i++)
                {
                    System.out.println("第"+i+"名为："+gradeArrayList.get(i-1).getSid()+" "+gradeArrayList.get(i-1).getSname()
                    +" "+gradeArrayList.get(i-1).getTotal()+"分");
                }
                break;
            case 2:
                for (Grade grade:grades)
                {
                    if (grade.getCid()==2)
                        gradeArrayList.add(grade);
                }
                Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());
                for (int i=1;i<=120;i++)
                {
                    System.out.println("第"+i+"名为："+gradeArrayList.get(i-1).getSid()+" "+gradeArrayList.get(i-1).getSname()
                            +" "+gradeArrayList.get(i-1).getTotal()+"分");
                }
                break;
            case 3:
                for (Grade grade:grades)
                {
                    if (grade.getCid()==3)
                        gradeArrayList.add(grade);
                }
                Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());
                for (int i=1;i<=120;i++)
                {
                    System.out.println("第"+i+"名为："+gradeArrayList.get(i-1).getSid()+" "+gradeArrayList.get(i-1).getSname()
                            +" "+gradeArrayList.get(i-1).getTotal()+"分");
                }
                break;
            case 4:
                int times = 0;
                int sum = 0;
                for (Grade grade:grades)
                {
                    if (times==2)
                    {
                        times=0;
                        sum+=grade.getTotal();
                        sum/=3;
                        grade.setTotal(sum);
                        gradeArrayList.add(grade);
                        sum=0;
                        continue;
                    }
                    sum+=grade.getTotal();
                    times++;
                }
                Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());
                for (int i=1;i<=120;i++)
                {
                    System.out.println("第"+i+"名为："+gradeArrayList.get(i-1).getSid()+" "+gradeArrayList.get(i-1).getSname()
                            +" "+gradeArrayList.get(i-1).getTotal()+"分");
                }
                break;
        }
    }

}