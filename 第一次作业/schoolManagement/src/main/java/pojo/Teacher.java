package pojo;

import java.util.*;

/** @pdOid 6135bb24-a5cb-40e0-829b-69271c4baed5 */
public class Teacher {
    /** @pdOid 8e42e2f7-4dfe-4394-9a84-d31469c14c2a */
    private int tid;
    /** @pdOid 95539398-3b86-4bca-a267-1e21b183beaf */
    private java.lang.String tname;

    /** @pdRoleInfo migr=no name=Student assc=授课 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
    public java.util.Collection<Student> student;

    /** @pdOid 488a530d-4321-4d84-acfc-7d8fff09f9d6 */
    public int getTid() {
        return tid;
    }

    /** @param newTid
     * @pdOid 0f84baab-c107-4992-a0f4-e7681b70ef51 */
    public void setTid(int newTid) {
        tid = newTid;
    }

    /** @pdOid aed01472-d289-4bbd-9ac0-13e45ba3fda5 */
    public java.lang.String getTname() {
        return tname;
    }

    /** @param newTname
     * @pdOid 5cf58d70-f88a-493a-9955-05c10388f4cb */
    public void setTname(java.lang.String newTname) {
        tname = newTname;
    }


    /** @pdGenerated default getter */
    public java.util.Collection<Student> getStudent() {
        if (student == null)
            student = new java.util.HashSet<Student>();
        return student;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorStudent() {
        if (student == null)
            student = new java.util.HashSet<Student>();
        return student.iterator();
    }

    /** @pdGenerated default setter
     * @param newStudent */
    public void setStudent(java.util.Collection<Student> newStudent) {
        removeAllStudent();
        for (java.util.Iterator iter = newStudent.iterator(); iter.hasNext();)
            addStudent((Student)iter.next());
    }

    /** @pdGenerated default add
     * @param newStudent */
    public void addStudent(Student newStudent) {
        if (newStudent == null)
            return;
        if (this.student == null)
            this.student = new java.util.HashSet<Student>();
        if (!this.student.contains(newStudent))
            this.student.add(newStudent);
    }

    /** @pdGenerated default remove
     * @param oldStudent */
    public void removeStudent(Student oldStudent) {
        if (oldStudent == null)
            return;
        if (this.student != null)
            if (this.student.contains(oldStudent))
                this.student.remove(oldStudent);
    }

    /** @pdGenerated default removeAll */
    public void removeAllStudent() {
        if (student != null)
            student.clear();
    }

}