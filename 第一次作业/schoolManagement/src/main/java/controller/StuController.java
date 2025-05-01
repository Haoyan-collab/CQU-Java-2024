package controller;
import pojo.*;

import java.util.*;
import java.util.Random;

/** @pdOid cf36684a-d338-4b1e-83c1-b134a5ca18eb */
public class StuController {


    /**
     * @pdOid f74287ed-c421-40c3-823a-04d78ff4bdce
     */
    public ArrayList<StuClassRelation> selectCourse(ArrayList<Student>students, ArrayList<Classroom>classrooms) {
        // TODO: implement

        ArrayList<StuClassRelation> stuClassRelations = new ArrayList<>();
        for (Student student : students) {
            Set<Integer> assignedCids = new HashSet<>(); // 存储已分配给学生的cid
            List<Classroom> assignedClassrooms = new ArrayList<>(); // 存储已分配给学生的教室对象

            // 为学生分配三个cid不同的教室
            while (assignedClassrooms.size() < 3) {
                Classroom classroom = null;
                boolean found = false;

                // 遍历所有教室，找到一个cid未被分配且满足条件的教室
                for (Classroom c : classrooms) {
                    if (!assignedCids.contains(c.getCid())&&c.getTotal()<20) {
                        classroom = c;
                        found = true;
                        c.setTotal(c.getTotal()+1);
                        break;
                    }
                }

                // 如果没有找到合适的教室（理论上不应该发生，因为我们假设有足够的教室来满足需求）
                // 可以选择抛出异常或重新洗牌教室列表（但在这里我们假设总会找到一个合适的教室）
                if (!found) {
                    throw new IllegalStateException("Unable to assign three different cids to student " + student.getSname());
                }

                // 将教室添加到已分配列表中，并更新已分配的cid集合，将关系记录到StuClassRelation类
                StuClassRelation stuClassRelation = new StuClassRelation();
                assignedClassrooms.add(classroom);
                assignedCids.add(classroom.getCid());
               stuClassRelation.StuClassRelation(student.getSid(),classroom.getClassid());
                stuClassRelations.add(stuClassRelation);
            }
        }
//        for(StuClassRelation s:stuClassRelations)
//        {
//            System.out.println(s.getSid()+" "+s.getClassid());
//        }
        return stuClassRelations;
    }

    /**
     * @pdOid dd5e01e5-1594-4424-b258-9b8b5620e215
     */
    public void findGradeById(int sid,ArrayList<Student>students,ArrayList<Grade>grades) {
        // TODO: implement
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        Student s = null;
        for (Student student: students)
        {
            if (student.getSid()==sid)
            {
                s = student;
                break;
            }
        }
        int sum = 0;
        for (Grade grade : grades)
        {
            if (grade.getSid()==sid)
            {
                gradeArrayList.add(grade);
                sum+=grade.getTotal();
            }
        }
        System.out.println(sid+" "+s.getSname()+"成绩为：");
        for (Grade grade :gradeArrayList)
        {
            System.out.println(grade.getCname()+":"+grade.getTotal()+"分");
        }
        System.out.println("总成绩为："+sum/3);
    }


    public void findGradeByName(String sname,ArrayList<Student>students,ArrayList<Grade>grades) {
        // TODO: implement
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        Student s = null;
        for (Student student: students)
        {
            if (student.getSname().equals(sname))
            {
                s = student;
                break;
            }
        }
        if (s==null)
        {
            System.out.println("未找到该学生！");
            return;
        }
        int sum = 0;
        int sid = s.getSid();
        for (Grade grade : grades)
        {
            if (grade.getSid()==sid)
            {
                gradeArrayList.add(grade);
                sum+=grade.getTotal();
            }
        }
        System.out.println(sid+" "+s.getSname()+"成绩为：");
        for (Grade grade :gradeArrayList)
        {
            System.out.println(grade.getCname()+":"+grade.getTotal()+"分");
        }
        System.out.println("总成绩为："+sum/3);
    }
    /**
     * @pdOid 7bb65736-6a60-40a3-ad69-b4959b4a8f43
     */
    public void showClassById(int sid, ArrayList<StuClassRelation>stuClassRelations,
                          ArrayList<Classroom>classrooms, ArrayList<Teacher>teachers,ArrayList<Student>students) {
        // TODO: implement
        Student s = null;
        for (Student student:students)
        {
            if (student.getSid()==sid)
            {
                s = student;
                break;
            }
        }
        if (s==null)
        {
            System.out.println("未找到该学生！");
            return;
        }
        System.out.println("学生"+sid+" "+s.getSname()+"课程表为：");
        for(StuClassRelation stuClassRelation:stuClassRelations)//遍历该学生的课程班
        {
            if(stuClassRelation.getSid()==sid)
            {
                int classid=stuClassRelation.getClassid();
                for(Classroom classroom:classrooms)//遍历输出
                {
                    if(classroom.getClassid()==classid)
                    {
                        int tid = classroom.getTid();
                        String tname = null;
                        for (Teacher teacher:teachers)
                        {
                            if(teacher.getTid()==tid)
                            {
                                tname=teacher.getTname();
                                break;
                            }
                        }
                        System.out.println(classid+" "+"地址："+classroom.getAddress()+" 时间："+classroom.getSemester()
                                +" 教师："+tname);
                        break;
                    }
                }
            }
        }
    }


    public void showClassByName(String sname, ArrayList<StuClassRelation>stuClassRelations,
                              ArrayList<Classroom>classrooms, ArrayList<Teacher>teachers,ArrayList<Student>students) {
        // TODO: implement
        Student s = null;
        for (Student student:students)
        {
            if (student.getSname().equals(sname))
            {
                s=student;
                break;
            }
        }
        if (s==null)
        {
            System.out.println("未找到该学生！");
            return;
        }
        int sid = s.getSid();
        System.out.println("学生"+sid+" "+sname+"课程表为：");
        for(StuClassRelation stuClassRelation:stuClassRelations)
        {
            if(stuClassRelation.getSid()==sid)
            {
                int classid=stuClassRelation.getClassid();
                for(Classroom classroom:classrooms)
                {
                    if(classroom.getClassid()==classid)
                    {
                        int tid = classroom.getTid();
                        String tname = null;
                        for (Teacher teacher:teachers)
                        {
                            if(teacher.getTid()==tid)
                            {
                                tname=teacher.getTname();
                                break;
                            }
                        }
                        System.out.println(classid+" "+"地址："+classroom.getAddress()+" 时间："+classroom.getSemester()
                                +" 教师："+tname);
                        break;
                    }
                }
            }
        }
    }

    public void showStuRank(int cid, ArrayList<Grade>grades,int sid)
    {
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        int rank = 0;//用于记录该学生的排名
        switch (cid)
        {
            case 1:
                for (Grade grade:grades)
                {
                    if (grade.getCid()==1)
                        gradeArrayList.add(grade);
                }
                Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());
                for (int i=1;i<=120;i++) {
                    System.out.println("第" + i + "名为：" + gradeArrayList.get(i - 1).getSid() + " " + gradeArrayList.get(i - 1).getSname()
                            + " " + gradeArrayList.get(i - 1).getTotal() + "分");
                    if (gradeArrayList.get(i - 1).getSid() == sid)
                    {
                        rank = i;
                    }
                }
                System.out.println("您为第"+rank+"名！");
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
                    if (gradeArrayList.get(i - 1).getSid() == sid)
                    {
                        rank = i;
                    }
                }
                System.out.println("您为第"+rank+"名！");
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
                    if (gradeArrayList.get(i - 1).getSid() == sid)
                    {
                        rank = i;
                    }
                }
                System.out.println("您为第"+rank+"名！");
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
                    if (gradeArrayList.get(i - 1).getSid() == sid)
                    {
                        rank = i;
                    }
                }
                System.out.println("您为第"+rank+"名！");
                break;
        }
    }

    private String[] surnames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Chen", "Liu", "Ross", "Rose", "Bing", "Chou",
            "Hu", "Ma"
    };

    // 名数组
    private String[] firstNames = {
            "James", "Mary", "John", "Patricia", "Robert",
            "Jennifer", "Michael", "Linda", "William", "Elizabeth",
            "David", "Barbara", "Richard", "Susan", "Joseph",
            "Jessica", "Charles", "Sarah", "Thomas", "Karen"
    };


    /**
     * @pdOid e851ac75-e3b0-4016-ae39-32378b573310
     */
    public ArrayList<Student> generateStu() {
        // TODO: implement
        Random random = new Random();
        Set<String> uniqueNames = new HashSet<>();//检测重名
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Students List:");
        for (int i = 0; i < 120; i++) {
            Student student = new Student();
            // 随机选择一个姓和一个名
            String uniqueName = generateUniqueName(random, uniqueNames, surnames, firstNames);
            student.setSname(uniqueName);
            student.setSid(2024001+i);
            student.setSgender(random.nextBoolean() ? "Male" : "Female");
            students.add(student);
            System.out.println(student.getSid()+" "+student.getSname()+" "+student.getSgender());

        }
        return students;
    }

    private static String generateUniqueName(Random random, Set<String> uniqueNames, String[] surnames, String[] firstNames) {
        String uniqueName;
        do {
            String surname = surnames[random.nextInt(surnames.length)];
            String firstName = firstNames[random.nextInt(firstNames.length)];
            uniqueName = firstName + " " + surname;
        } while (uniqueNames.contains(uniqueName)); //若已有改名字则继续生成新的，直至出现新名字
        uniqueNames.add(uniqueName);
        return uniqueName;
    }
}