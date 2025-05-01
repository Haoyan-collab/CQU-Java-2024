package controller;

import pojo.Classroom;
import pojo.Course;
import pojo.Grade;
import pojo.StuClassRelation;

import java.util.*;

/** @pdOid 5f0213f8-28dd-4b65-bdfc-8f24a4c39c40 */
public class ClassController {


    /** @pdOid 146f5e19-86f8-4854-9e41-7dfcb06d1850 */
    public void showGradeInId(int classid,ArrayList<Grade>grades, ArrayList<StuClassRelation>stuClassRelations,
                              ArrayList<Classroom>classrooms) {
        // TODO: implement
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        Classroom classroom = null;
        for (Classroom c :classrooms)
        {
            if (c.getClassid()==classid)
            {
                classroom=c;
                break;
            }
        }//锁定教室
        for (StuClassRelation stuClassRelation:stuClassRelations)
        {
            if (stuClassRelation.getClassid()==classid)
            {
                int sid = stuClassRelation.getSid();//寻找该教学班内的每一个学生
                for (Grade grade:grades)
                {
                    if (grade.getSid()==sid&&grade.getCid()==classroom.getCid())//在grade表里查找该学生在该教学班所教课程获得的成绩
                    {
                        gradeArrayList.add(grade);
                        break;
                    }
                }
            }
        }
        Collections.sort(gradeArrayList,(g1,g2)->g1.getSid()-g2.getSid());
        for (Grade grade:gradeArrayList)
        {
            System.out.println(grade.getSid()+" "+grade.getSname()+"在课程"+grade.getCname()+"的成绩为："+grade.getTotal());
        }
    }

    /** @pdOid ede64166-ba54-4202-8933-ce11c0f8c252 */
    public void showGradeInScore(int classid,ArrayList<Grade>grades, ArrayList<StuClassRelation>stuClassRelations,
                              ArrayList<Classroom>classrooms) {
        // TODO: implement
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        Classroom classroom = null;
        for (Classroom c :classrooms)
        {
            if (c.getClassid()==classid)
            {
                classroom=c;
                break;
            }
        }//锁定教室
        for (StuClassRelation stuClassRelation:stuClassRelations)
        {
            if (stuClassRelation.getClassid()==classid)
            {
                int sid = stuClassRelation.getSid();//寻找该教学班内的每一个学生
                for (Grade grade:grades)
                {
                    if (grade.getSid()==sid&&grade.getCid()==classroom.getCid())//在grade表里查找该学生在该教学班所教课程获得的成绩
                    {
                        gradeArrayList.add(grade);
                        break;
                    }
                }
            }
        }
        Collections.sort(gradeArrayList,(g1,g2)->g2.getTotal()-g1.getTotal());//成绩降序排列
        for (Grade grade:gradeArrayList)
        {
            System.out.println(grade.getSid()+" "+grade.getSname()+"在课程"+grade.getCname()+"的成绩为："+grade.getTotal());
        }
    }

    public static ArrayList<Classroom> generateClass() {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        Random random = new Random();
        String[] semesters = {"2024秋季", "2025春季"};
        List<Integer> tids = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            tids.add(i);
            tids.add(i); // 确保每个tid都出现两次
        }
        Collections.shuffle(tids); // 打乱tid列表顺序
        for (int i = 1; i <= 18; i++) {
            int currentCid = (i - 1) % 3 + 1; // Cycle through 1, 2, 3
            int currentTid = tids.remove(tids.size() - 1); // 从tid列表中随机取出一个tid（并移除）
            // Randomize the semester
            String semester = semesters[random.nextInt(semesters.length)];

            // Randomize the address
            int randomNumber = random.nextInt(200);
            String address = "D" + randomNumber;

            // Set a total (for this example, we'll just use a constant, but you can change it)
            int total = 0; // Example value

            // Create a new Classroom object and add it to the list
            Classroom classroom = new Classroom(i, currentCid, currentTid, semester, total, address);
            classrooms.add(classroom);
        }
        System.out.println("Classrooms List:");
        for(Classroom classroom : classrooms)
        {
            System.out.println(classroom.getClassid()+" cid:"+classroom.getCid()+" tid:"+classroom.getTid()+" "+
                    classroom.getSemester()+" total:"+classroom.getTotal()+" address:"+classroom.getAddress());
        }
        return classrooms;
    }
}