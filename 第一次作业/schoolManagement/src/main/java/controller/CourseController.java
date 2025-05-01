package controller;
import pojo.Course;

import java.lang.reflect.Array;
import java.util.*;

/** @pdOid ea089099-90cb-4f39-bb84-71d28e94a293 */
public class CourseController {


    /** @pdOid 75288044-4842-4827-8eca-43280e8f1119 */
    public ArrayList<Course> generateCourse() {
        // TODO: implement
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "软件工程"));
        courses.add(new Course(2, "计算机网络"));
        courses.add(new Course(3, "操作系统"));
        System.out.println("Courses List:");
        for(Course course : courses)
        {
            System.out.println(course.getCid()+" "+course.getCname());
        }
        return courses;
    }

}