package view;

import controller.*;
import pojo.*;

import java.util.*;

/** @pdOid 71e6af80-62a4-4cec-8501-0eecd2eb08e1 */
public class Menu {

    /** @pdOid 66fae5f4-eeae-4177-874f-fc3f08738a4d */
    public void showMenu() {
        // TODO: implement
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Classroom> classrooms = new ArrayList<>();
        ArrayList<StuClassRelation> stuClassRelations = new ArrayList<>();
        ArrayList<Grade> grades = new ArrayList<>();
        StuController stuController = new StuController();
        TeachController teachController = new TeachController();
        CourseController courseController = new CourseController();
        ClassController classController = new ClassController();
        GradeController gradeController = new GradeController();
        boolean hasGenerated = false;
        while (true) {
            System.out.println("_________________________________");
            System.out.println("        欢迎使用学生管理系统!         ");
            System.out.println("          1、初始化数据（课程与成绩将随之生成）            ");
            System.out.println("          2、退出            ");
            System.out.println("请输入您的选择：");
            int select = scanner.nextInt();
            if (select == 2)
                break;
            else if (select != 1)
            {
                System.out.println("请输入有效数字！");
            }
            else if (select == 1)
            {
                if (hasGenerated) //提示已经初始化过，不再进行初始化
                {
                    System.out.println("您已初始化过数据！数据如下：");
                    System.out.println("Students list:");
                    for (Student student : students) {
                        System.out.println(student.getSid() + " " + student.getSname() + " " + student.getSgender());
                    }
                    System.out.println();
                    System.out.println("Teachers list:");
                    for (Teacher teacher : teachers) {
                        System.out.println(teacher.getTid() + " " + teacher.getTname());
                    }
                    System.out.println();
                    System.out.println("Courses list:");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(courses.get(i).getCid() + " " + courses.get(i).getCname());
                    }
                    System.out.println();
                    System.out.println("Classrooms list:");
                    for (Classroom classroom : classrooms) {
                        System.out.println(classroom.getClassid() + " cid:" + classroom.getCid() + " tid:" + classroom.getTid() + " " +
                                classroom.getSemester() + " total:" + classroom.getTotal() + " address:" + classroom.getAddress());
                    }
                    System.out.println("按任意键返回菜单");
                    scanner.nextLine();  // 消耗掉之前的换行符
                    scanner.nextLine();  // 等待用户的任意输入
                }
                if (!hasGenerated) {
                    students = stuController.generateStu();
                    teachers = teachController.generateTeach();
                    courses = courseController.generateCourse();
                    classrooms = classController.generateClass();
                    hasGenerated = true;
                    System.out.println("初始化数据完成！");
                    stuClassRelations = stuController.selectCourse(students,classrooms);
                    grades = gradeController.generateGrade(students,classrooms,stuClassRelations);
                    System.out.println("课程与成绩已分配完毕！");
                    System.out.println("按任意键继续");
                    scanner.nextLine();  // 消耗掉之前的换行符
                    scanner.nextLine();  // 等待用户的任意输入
                }
            }
                while (true) {
                    System.out.println("----------请选择通过学生端或教师端进入系统----------");
                    System.out.println("1.学生端");
                    System.out.println("2.教师端");
                    System.out.println("******按0退出******");
                    int c = scanner.nextInt();
                    if (c == 0)
                        break;
                    else if (c == 1) {
                        while (true) {
                            System.out.println("欢迎进入学生端！请输入您的学生ID：");
                            System.out.println("******退出请按0！");
                            int sid = scanner.nextInt();
                            if (sid == 0)
                                break;
                            else if (sid > 2024120 || sid < 2024001) {
                                System.out.println("请输入有效ID号！");
                                sid = scanner.nextInt();
                            }
                            Student s = null;
                            for (Student student : students) {
                                if (student.getSid() == sid) {
                                    s = student;
                                    break;
                                }
                            }
                            boolean stuflag = false;
                            while (true) {
                                if(stuflag)
                                    break;
                                System.out.println("欢迎你！" + sid + " " + s.getSname() + "同学！");
                                System.out.println("请选择您要进行的操作");
                                System.out.println("1.查询课程");
                                System.out.println("2.查询分数");
                                System.out.println("3.查询排名");
                                System.out.println("4.退出");
                                System.out.println("请输入您的选择：");
                                int input = scanner.nextInt();
                                switch (input) {
                                    case 1:
                                        stuController.showClassById(sid,stuClassRelations,classrooms,teachers,students);
                                        System.out.println("按任意键返回菜单");
                                        scanner.nextLine();  // 消耗掉之前的换行符
                                        scanner.nextLine();  // 等待用户的任意输入
                                        break;
                                    case 2:
                                        stuController.findGradeById(sid, students, grades);
                                        System.out.println("按任意键返回菜单");
                                        scanner.nextLine();  // 消耗掉之前的换行符
                                        scanner.nextLine();  // 等待用户的任意输入
                                        break;
                                    case 3:
                                        while (true)
                                        {
                                            System.out.println("          1、展示软件工程分数排名            ");
                                            System.out.println("          2、展示计算机网络分数排名            ");
                                            System.out.println("          3、展示操作系统分数排名            ");
                                            System.out.println("          4、展示总分分数排名            ");
                                            System.out.println("          5、退出            ");
                                            int nextInt = scanner.nextInt();
                                            if (nextInt==5)
                                                break;
                                            else if (nextInt==1||nextInt==2||nextInt==3||nextInt==4)
                                            {
                                                stuController.showStuRank(nextInt,grades,sid);
                                                System.out.println("按任意键继续");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            }
                                            else
                                                System.out.println("请输入有效数字！");
                                        }
                                        break;
                                    case 4:
                                        stuflag = true;
                                        break;
                                    default:
                                        System.out.println("请输入有效数字！");
                                        break;
                                }
                            }
                        }
                    }
                    else if (c == 2)
                    {
                        while (true)
                        {
                            ArrayList<Student>stuList = new ArrayList<>();
                            System.out.println("欢迎进入教师端！请输入您的教师ID号：");
                            System.out.println("******退出请按0");
                            int tid = scanner.nextInt();
                            if (tid == 0)
                                break;
                            else if (tid < 1 || tid > 9) {
                                System.out.println("请输入有效ID号！");
                                tid = scanner.nextInt();
                            }
                            Teacher t = null;
                            for (Teacher teacher : teachers) {
                                if (teacher.getTid() == tid) {
                                    t = teacher;
                                    break;
                                }
                            }
                            stuList = teachController.stuList(tid,classrooms,stuClassRelations,students);
                            ArrayList<Grade> gradeList = new ArrayList<>();
                            boolean teachflag = false;
                            while (true)
                            {
                                if (teachflag)
                                    break;
                                System.out.println("欢迎您！" + t.getTname());
                                System.out.println("请选择您要进行的操作");
                                System.out.println("1.成绩调整");
                                System.out.println("2.查询教学班学生成绩");
                                System.out.println("3.查询某学生成绩");
                                System.out.println("4.统计学生成绩分数段分布");
                                System.out.println("5.查询学生课程班");
                                System.out.println("6.统计排名");
                                System.out.println("7.查询自己教学班信息");
                                System.out.println("8.退出");
                                System.out.println("请输入您的选择：");
                                int choose = scanner.nextInt();
                                switch (choose) {
                                    case 1:
                                        ArrayList<String> strings = new ArrayList<>();
                                        strings.add("软件工程");
                                        strings.add("计算机网络");
                                        strings.add("操作系统");
                                        ArrayList<Integer> cids = new ArrayList<>();
                                        System.out.println("以下是您的教学班的学生成绩：");
                                        gradeList = teachController.showGrade(tid,grades,stuList,classrooms);
                                        System.out.println("请输入您要修改的学生的ID号：");
                                        int sid = scanner.nextInt();
                                        Student s = new Student();
                                        boolean flag = true;
                                        while (flag)
                                        {
                                            for (Student student:stuList)
                                            {
                                                if (sid==student.getSid())
                                                {
                                                    s=student;
                                                    flag=false;
                                                }
                                            }
                                            if (flag)
                                            {
                                                System.out.println("该生不是您的学生！您无权修改他的成绩，请重新输入：");
                                                sid = scanner.nextInt();
                                            }
                                        }
                                        boolean f = false;
                                        while (true)
                                        {
                                            if (f)
                                                break;
                                            for (Grade grade:gradeList)
                                            {
                                                if (grade.getSid()==sid)
                                                {
                                                    System.out.println("学生"+s.getSname()+"在"+strings.get(grade.getCid()-1)+"中取得的成绩为：平时分："+grade.getRegular()+
                                                            "分 期中："+grade.getMidterm()+"分 实验："+grade.getLab()+"分 期末："+grade.getEnd()+"分 总分为："+
                                                            grade.getTotal()+"分");
                                                    if (!cids.contains(grade.getCid()))
                                                    {
                                                        cids.add(grade.getCid());
                                                    }
                                                }
                                            }
                                            System.out.println("请选择您想修改的课程");
                                            System.out.println("1.软件工程");
                                            System.out.println("2.计算机网络");
                                            System.out.println("3.操作系统");
                                            System.out.println("4.退出");
                                            System.out.println("请输入您的选择：");
                                            int se = scanner.nextInt();
                                            if (se==4)
                                                break;
                                            while (!cids.contains(se))
                                            {
                                                System.out.println("请选择您可修改的课程！：");
                                                se = scanner.nextInt();
                                            }
                                            for (int i=0;i<grades.size();i++)
                                            {
                                                if (grades.get(i).getSid()==sid&&gradeList.contains(grades.get(i))&&grades.get(i).getCid()==se)
                                                {
                                                    System.out.println("请选择您想修改的成绩");
                                                    System.out.println("1.平时分");
                                                    System.out.println("2.期中成绩");
                                                    System.out.println("3.实验成绩");
                                                    System.out.println("4.期末成绩");
                                                    System.out.println("5.退出");
                                                    System.out.println("请输入您的选择：");
                                                    int input = scanner.nextInt();
                                                    double rawTotal = 0;
                                                    int roundedTotal = 0;
                                                    switch (input)
                                                    {
                                                        case 1:
                                                            System.out.println("请输入修改后的平时分：");
                                                            int regular = scanner.nextInt();
                                                            grades.get(i).setRegular(regular);
                                                            rawTotal = 0.1 * grades.get(i).getRegular() + 0.1 * grades.get(i).getLab() +
                                                                    0.2 * grades.get(i).getMidterm() + 0.6 * grades.get(i).getEnd();//原始成绩
                                                            roundedTotal = (int) Math.round(rawTotal);//四舍五入
                                                            grades.get(i).setTotal(roundedTotal);
                                                            System.out.println("平时分已修改为："+regular+"分");
                                                            break;
                                                        case 2:
                                                            System.out.println("请输入修改后的期中成绩：");
                                                            int midterm = scanner.nextInt();
                                                            grades.get(i).setMidterm(midterm);
                                                            rawTotal = 0.1 * grades.get(i).getRegular() + 0.1 * grades.get(i).getLab() +
                                                                    0.2 * grades.get(i).getMidterm() + 0.6 * grades.get(i).getEnd();//原始成绩
                                                            roundedTotal = (int) Math.round(rawTotal);//四舍五入
                                                            grades.get(i).setTotal(roundedTotal);
                                                            System.out.println("期中成绩已修改为："+midterm+"分");
                                                            break;
                                                        case 3:
                                                            System.out.println("请输入修改后的实验成绩：");
                                                            int lab = scanner.nextInt();
                                                            grades.get(i).setLab(lab);
                                                            rawTotal = 0.1 * grades.get(i).getRegular() + 0.1 * grades.get(i).getLab() +
                                                                    0.2 * grades.get(i).getMidterm() + 0.6 * grades.get(i).getEnd();//原始成绩
                                                            roundedTotal = (int) Math.round(rawTotal);//四舍五入
                                                            grades.get(i).setTotal(roundedTotal);
                                                            System.out.println("实验成绩已修改为："+lab+"分");
                                                            break;
                                                        case 4:
                                                            System.out.println("请输入修改后的期末成绩：");
                                                            int end = scanner.nextInt();
                                                            grades.get(i).setEnd(end);
                                                            rawTotal = 0.1 * grades.get(i).getRegular() + 0.1 * grades.get(i).getLab() +
                                                                    0.2 * grades.get(i).getMidterm() + 0.6 * grades.get(i).getEnd();//原始成绩
                                                            roundedTotal = (int) Math.round(rawTotal);//四舍五入
                                                            grades.get(i).setTotal(roundedTotal);
                                                            System.out.println("期末成绩已修改为："+end+"分");
                                                            break;
                                                        case 5:
                                                            f=true;
                                                            break;
                                                        default:
                                                            System.out.println("请输入有效数字！");
                                                            break;
                                                    }
                                                    break;
                                                }
                                            }
                                           
                                        }
                                        break;
                                    case 2:
                                        while (true) {
                                            System.out.println("*******退出请按0*******");
                                            System.out.println("请输入教学班ID号（1~18）：");
                                            int classid = scanner.nextInt();
                                            if (classid == 0)
                                                break;
                                            while ((classid < 1 || classid > 18) && classid != 0) {
                                                System.out.println("请输入有效教学班ID号！(1~18):");
                                                classid = scanner.nextInt();
                                            }
                                            System.out.println("          1、按照学生ID排序            ");
                                            System.out.println("          2、按照学生成绩排序            ");
                                            System.out.print("请输入您的选择：");
                                            int nextInt = scanner.nextInt();
                                            while(nextInt!=1&&nextInt!=2)
                                            {
                                                System.out.println("请输入有效数字！");
                                                nextInt = scanner.nextInt();
                                            }
                                            if (nextInt == 1) {
                                                classController.showGradeInId(classid, grades, stuClassRelations, classrooms);
                                                System.out.println("按任意键继续");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            } else if (nextInt == 2) {
                                                classController.showGradeInScore(classid, grades, stuClassRelations, classrooms);
                                                System.out.println("按任意键继续");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.println("          1、输入学生ID查找            ");
                                            System.out.println("          2、输入学生姓名查找            ");
                                            System.out.println("          3、退出            ");
                                            System.out.print("请输入您的选择：");
                                            int nextInt = scanner.nextInt();
                                            if (nextInt == 3)
                                                break;
                                            else {
                                                switch (nextInt) {
                                                    case 1:
                                                        System.out.println("请输入学生ID：");
                                                        int stuid = scanner.nextInt();
                                                        while (stuid > 2024120 || stuid < 2024001) {
                                                            System.out.println("请输入有效学生ID！（2024001~2024120）：");
                                                            stuid = scanner.nextInt();
                                                        }
                                                        stuController.findGradeById(stuid, students, grades);
                                                        System.out.println("按任意键继续");
                                                        scanner.nextLine();
                                                        scanner.nextLine();
                                                        break;
                                                    case 2:
                                                        System.out.println("请输入学生姓名：");
                                                        scanner.nextLine();
                                                        String sname = scanner.nextLine();
                                                        stuController.findGradeByName(sname, students, grades);
                                                        System.out.println("按任意键继续");
                                                        scanner.nextLine();
                                                        break;
                                                    default:
                                                        System.out.println("请输入有效数字！");
                                                        break;
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {
                                            System.out.println("          1、统计软件工程分数段分布            ");
                                            System.out.println("          2、统计计算机网络分数段分布            ");
                                            System.out.println("          3、统计操作系统分数段分布            ");
                                            System.out.println("          4、统计总分分数段分布            ");
                                            System.out.println("          5、退出            ");
                                            int nextInt = scanner.nextInt();
                                            if (nextInt == 5)
                                                break;
                                            else if (nextInt==1||nextInt==2||nextInt==3||nextInt==4)
                                            {
                                                gradeController.gradeRange(nextInt, grades);
                                                System.out.println("按任意键继续");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            }
                                            else
                                                System.out.println("请输入有效数字！");
                                        }
                                        break;
                                    case 5:
                                        while (true)
                                        {
                                            System.out.println("          1、输入学生ID号查询            ");
                                            System.out.println("          2、输入学生姓名查询            ");
                                            System.out.println("          3、退出            ");
                                            System.out.println("请输入您的选择：");
                                            int nextInt =scanner.nextInt();
                                            if (nextInt==3)
                                                break;
                                            switch (nextInt)
                                            {
                                                case 1:
                                                    System.out.println("请输入学生ID：");
                                                    int anInt = scanner.nextInt();
                                                    while (anInt > 2024120 || anInt < 2024001) {
                                                        System.out.println("请输入有效学生ID！（2024001~2024120）：");
                                                        anInt = scanner.nextInt();
                                                    }
                                                    stuController.showClassById(anInt,stuClassRelations,classrooms,teachers,students);
                                                    System.out.println("按任意键返回菜单");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    break;
                                                case 2:
                                                    System.out.println("请输入学生姓名：");
                                                    scanner.nextLine();
                                                    String sname = scanner.nextLine();
                                                    stuController.showClassByName(sname,stuClassRelations,classrooms,teachers,students);
                                                    System.out.println("按任意键返回菜单");
                                                    scanner.nextLine();
                                                    break;
                                                default:
                                                    System.out.println("请输入有效数字！");
                                                    break;
                                            }
                                        }
                                        break;
                                    case 6:
                                        while (true)
                                        {
                                            System.out.println("          1、展示软件工程分数排名            ");
                                            System.out.println("          2、展示计算机网络分数排名            ");
                                            System.out.println("          3、展示操作系统分数排名            ");
                                            System.out.println("          4、展示总分分数排名            ");
                                            System.out.println("          5、退出            ");
                                            int nextInt = scanner.nextInt();
                                            if (nextInt==5)
                                                break;
                                            else if (nextInt==1||nextInt==2||nextInt==3||nextInt==4)
                                            {
                                                gradeController.showRank(nextInt,grades);
                                                System.out.println("按任意键继续");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            }
                                            else
                                                System.out.println("请输入有效数字！");
                                        }
                                        break;
                                    case 7:
                                        teachController.showClass(tid,classrooms,stuClassRelations,courses,students);
                                        System.out.println("按任意键继续");
                                        scanner.nextLine();
                                        scanner.nextLine();
                                        break;
                                    case 8:
                                        teachflag = true;
                                        break;
                                    default:
                                        System.out.println("请输入有效数字！");
                                }
                            }
                        }
                    }
                }
        }
//            System.out.println("          2、学生选课            ");
//            System.out.println("          3、获取成绩   ");
//            System.out.println("          4、查询教学班学生成绩 ");
//            System.out.println("          5、统计学生成绩分数段分布 ");
//            System.out.println("          6、查询某学生成绩           ");
//            System.out.println("          7、展示排名             ");
//            System.out.println("          8、查询学生课程班             ");
//            System.out.println("          9、退出            ");
//            System.out.println("_________________________________");
//            System.out.print("请输入您的选择：");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    students = stuController.generateStu();
//                    teachers = teachController.generateTeach();
//                    courses = courseController.generateCourse();
//                    classrooms = classController.generateClass();
//                    System.out.println("按任意键返回菜单");
//                    scanner.nextLine();  // 消耗掉之前的换行符
//                    scanner.nextLine();  // 等待用户的任意输入
//                    break;
//                case 2:
//                    stuClassRelations = stuController.selectCourse(students, classrooms);
//                    System.out.println("按任意键返回菜单");
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    break;
//                case 3:
//                    grades = gradeController.generateGrade(students, classrooms, stuClassRelations);
//                    System.out.println("按任意键返回菜单");
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    break;
//                case 4:
//                    while (true) {
//                        System.out.println("*******退出请按0*******");
//                        System.out.println("请输入教学部ID号（1~18）：");
//                        int classid = scanner.nextInt();
//                        if (classid == 0)
//                            break;
//                        while ((classid < 1 || classid > 18) && classid != 0) {
//                            System.out.println("请输入有效教学班ID号！(1~18):");
//                            classid = scanner.nextInt();
//                        }
//                        System.out.println("          1、按照学生ID排序            ");
//                        System.out.println("          2、按照学生成绩排序            ");
//                        System.out.print("请输入您的选择：");
//                        int c = scanner.nextInt();
//                        if (c == 1) {
//                            classController.showGradeInId(classid, grades, stuClassRelations, classrooms);
//                            System.out.println("按任意键继续");
//                            scanner.nextLine();
//                            scanner.nextLine();
//                        } else if (c == 2) {
//                            classController.showGradeInScore(classid, grades, stuClassRelations, classrooms);
//                            System.out.println("按任意键继续");
//                            scanner.nextLine();
//                            scanner.nextLine();
//                        }
//                    }
//                    break;
//                case 5:
//                    while (true) {
//                        System.out.println("          1、统计软件工程分数段分布            ");
//                        System.out.println("          2、统计计算机网络分数段分布            ");
//                        System.out.println("          3、统计操作系统分数段分布            ");
//                        System.out.println("          4、统计总分分数段分布            ");
//                        System.out.println("          5、退出            ");
//                        int c = scanner.nextInt();
//                        if (c == 5)
//                            break;
//                        else if (c==1||c==2||c==3||c==4)
//                        {
//                            gradeController.gradeRange(c, grades);
//                            System.out.println("按任意键继续");
//                            scanner.nextLine();
//                            scanner.nextLine();
//                        }
//                        else
//                            System.out.println("请输入有效数字！");
//                        }
//                    break;
//                case 6:
//                    while (true) {
//                        System.out.println("          1、输入学生ID查找            ");
//                        System.out.println("          2、输入学生姓名查找            ");
//                        System.out.println("          3、退出            ");
//                        System.out.print("请输入您的选择：");
//                        int c = scanner.nextInt();
//                        if (c == 3)
//                            break;
//                        else {
//                            switch (c) {
//                                case 1:
//                                    System.out.println("请输入学生ID：");
//                                    int sid = scanner.nextInt();
//                                    while (sid > 2024120 || sid < 2024001) {
//                                        System.out.println("请输入有效学生ID！（2024001~2024120）：");
//                                        sid = scanner.nextInt();
//                                    }
//                                    stuController.findGradeById(sid, students, grades);
//                                    System.out.println("按任意键继续");
//                                    scanner.nextLine();
//                                    scanner.nextLine();
//                                    break;
//                                case 2:
//                                    System.out.println("请输入学生姓名：");
//                                    scanner.nextLine();
//                                    String sname = scanner.nextLine();
//                                    stuController.findGradeByName(sname, students, grades);
//                                    System.out.println("按任意键继续");
//                                    scanner.nextLine();
//                                    break;
//                                default:
//                                    System.out.println("请输入有效数字！");
//                                    return;
//                            }
//                        }
//                    }
//                    break;
//                case 7:
//                    while (true)
//                    {
//                        System.out.println("          1、展示软件工程分数排名            ");
//                        System.out.println("          2、展示计算机网络分数排名            ");
//                        System.out.println("          3、展示操作系统分数排名            ");
//                        System.out.println("          4、展示总分分数排名            ");
//                        System.out.println("          5、退出            ");
//                        int c = scanner.nextInt();
//                        if (c==5)
//                            break;
//                        else if (c==1||c==2||c==3||c==4)
//                        {
//                            gradeController.showRank(c,grades);
//                            System.out.println("按任意键继续");
//                            scanner.nextLine();
//                            scanner.nextLine();
//                        }
//                        else
//                            System.out.println("请输入有效数字！");
//                    }
//                    break;
//                case 8:
//                    while (true)
//                    {
//                        System.out.println("          1、输入学生ID号查询            ");
//                        System.out.println("          2、输入学生姓名查询            ");
//                        System.out.println("          3、退出            ");
//                        System.out.println("请输入您的选择：");
//                        int c =scanner.nextInt();
//                        if (c==3)
//                            break;
//                        switch (c)
//                        {
//                            case 1:
//                                System.out.println("请输入学生ID：");
//                                int sid = scanner.nextInt();
//                                while (sid > 2024120 || sid < 2024001) {
//                                    System.out.println("请输入有效学生ID！（2024001~2024120）：");
//                                    sid = scanner.nextInt();
//                                }
//                                stuController.showClassById(sid,stuClassRelations,classrooms,teachers,students);
//                                System.out.println("按任意键返回菜单");
//                                scanner.nextLine();
//                                scanner.nextLine();
//                                break;
//                            case 2:
//                                System.out.println("请输入学生姓名：");
//                                scanner.nextLine();
//                                String sname = scanner.nextLine();
//                                stuController.showClassByName(sname,stuClassRelations,classrooms,teachers,students);
//                                System.out.println("按任意键返回菜单");
//                                scanner.nextLine();
//                                break;
//                            default:
//                                System.out.println("请输入有效数字！");
//                                return;
//                        }
//                    }
//                    break;
//                case 9:
//                    System.out.println("煞笔东西，赶紧滚吧");
//                    scanner.close();
//                    return;
//
//                default:
//                    System.out.println("请输入有效数字！");
//            }
//        }
//        return;
//    }
    }
}