package controller;
import pojo.*;

import java.util.*;

/** @pdOid 4ae32198-5039-4cfb-beb8-7bd6f947ad5f */
public class TeachController {


    /** @pdOid 06d3e7fa-4ec8-46bf-941a-b55c8d2a476e */
    private String[] surnames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Chen", "Liu", "Ross", "Rose", "Bing", "Chou",
            "Hu", "Ma"
    };

    // 名数组
    private String[] firstNames = {
            "Mr.", "Ms.", "Miss"
    };
    public ArrayList<Teacher> generateTeach() {
        // TODO: implement
        Random random = new Random();
        Set<String> uniqueNames = new HashSet<>();//检测重名
        ArrayList<Teacher> teachers = new ArrayList<>();
        System.out.println("Teachers List:");
        for (int i = 0; i < 9; i++) {
            Teacher teacher = new Teacher();
            String uniqueName = generateUniqueName(random, uniqueNames, surnames, firstNames);
            teacher.setTname(uniqueName);
            teacher.setTid(i+1);
            teachers.add(teacher);
            System.out.println(teacher.getTid()+" "+teacher.getTname());
        }
        return teachers;
    }

    private static String generateUniqueName(Random random, Set<String> uniqueNames, String[] surnames, String[] firstNames) {
        String uniqueName;
        do {
            String surname = surnames[random.nextInt(surnames.length)];
            String firstName = firstNames[random.nextInt(firstNames.length)];
            uniqueName = firstName + surname;
        } while (uniqueNames.contains(uniqueName)); //若已有改名字则继续生成新的，直至出现新名字
        uniqueNames.add(uniqueName);
        return uniqueName;
    }

    public void showClass(int tid, ArrayList<Classroom>classrooms, ArrayList<StuClassRelation>stuClassRelations,
                          ArrayList<Course>courses,ArrayList<Student>students)
    {
        System.out.println("您要教的课程班为：");
        for(Classroom classroom:classrooms)
        {
            if (classroom.getTid()==tid)
            {
                int classid = classroom.getClassid();
                int cid = classroom.getCid();
                for (Course course:courses)
                {
                    if (course.getCid()==cid)
                    {
                        System.out.println(classid+" "+course.getCname()+" 地址："+classroom.getAddress()+" 时间："+classroom.getSemester());
                    }
                }
                System.out.println("选择了该教学班的学生为：");
                for(StuClassRelation stuClassRelation:stuClassRelations)
                {
                    if (stuClassRelation.getClassid()==classid)
                    {
                        int sid = stuClassRelation.getSid();
                        for(Student student:students)
                        {
                            if (student.getSid()==sid)
                                System.out.print(sid+" "+student.getSname()+" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public ArrayList<Student> stuList(int tid,ArrayList<Classroom>classrooms,
                                      ArrayList<StuClassRelation>stuClassRelations,ArrayList<Student>students)
    {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for(Classroom classroom:classrooms)//寻找老师教的班
        {
            if (tid==classroom.getTid())
            {
                int classid = classroom.getClassid();
                for (StuClassRelation stuClassRelation:stuClassRelations)//记录下老师教的学生
                {
                    if (stuClassRelation.getClassid()==classid)
                    {
                        int sid = stuClassRelation.getSid();
                        for (Student student:students)
                        {
                            if (student.getSid()==sid)
                            {
                                studentArrayList.add(student);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return studentArrayList;
    }
    public ArrayList<Grade> showGrade(int tid,ArrayList<Grade>grades,ArrayList<Student>students,ArrayList<Classroom>classrooms)
    {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        strings.add("软件工程");
        strings.add("计算机网络");
        strings.add("操作系统");
        for (Classroom classroom:classrooms)
        {
            if (classroom.getTid()==tid&&!integers.contains(classroom.getCid()))
            {
                integers.add(classroom.getCid());
            }
        }
        for (Student student:students)//传入老师的stulist
        {
            int sid = student.getSid();
            for (Grade grade:grades)
            {
                if (grade.getSid()==sid&&integers.contains(grade.getCid()))//保证是老师的学生且课程是该老师所教
                {
                    System.out.println("您的学生"+student.getSid()+" "+student.getSname()+"在"+strings.get(grade.getCid()-1)+"中取得的成绩为：平时分："+grade.getRegular()+
                            "分 期中："+grade.getMidterm()+"分 实验："+grade.getLab()+"分 期末："+grade.getEnd()+"分 总分为："+
                            grade.getTotal()+"分");
                    gradeArrayList.add(grade);
                }
            }
        }
        return gradeArrayList;
    }
}
