package pojo;

import java.util.*;

/** @pdOid ee046ceb-f222-4158-bbbf-745523849809 */
public class Student {
    /** @pdOid 4f37b8b7-13c2-4aa7-a170-ebb1f2463b92 */
    private int sid;
    /** @pdOid 10bcb0ba-5109-4b3e-9ea9-c1cf6c2e03a8 */
    private java.lang.String sname;
    /** @pdOid 82c2cf5f-941b-482f-9100-1ca6665e9115 */
    private java.lang.String sgender;

    /** @pdRoleInfo migr=no name=StuClassRelation assc=拥有 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
    public java.util.Collection<StuClassRelation> stuClassRelation;
    /** @pdRoleInfo migr=no name=Grade assc=拥有 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
    public java.util.Collection<Grade> grade;

    /** @pdOid 2d13cc69-30af-4eca-b513-ecc2ee10033b */
    public int getSid() {
        return sid;
    }

    /** @param newSid
     * @pdOid c7e40e24-af71-4d2a-9a85-70cc3c137c9f */
    public void setSid(int newSid) {
        sid = newSid;
    }

    /** @pdOid e3b703de-1ef0-4bae-9ea9-d0d2c4bc8fd5 */
    public java.lang.String getSname() {
        return sname;
    }

    /** @param newSname
     * @pdOid a3e96638-82f6-49cb-8096-7dab0c83cd81 */
    public void setSname(java.lang.String newSname) {
        sname = newSname;
    }

    /** @pdOid 80e28854-834e-40bb-a5ab-22382ac06b0e */
    public java.lang.String getSgender() {
        return sgender;
    }

    /** @param newSgender
     * @pdOid 613171df-cc2a-4f87-a6f7-17403cd98bd5 */
    public void setSgender(java.lang.String newSgender) {
        sgender = newSgender;
    }


    /** @pdGenerated default getter */
    public java.util.Collection<StuClassRelation> getStuClassRelation() {
        if (stuClassRelation == null)
            stuClassRelation = new java.util.HashSet<StuClassRelation>();
        return stuClassRelation;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorStuClassRelation() {
        if (stuClassRelation == null)
            stuClassRelation = new java.util.HashSet<StuClassRelation>();
        return stuClassRelation.iterator();
    }

    /** @pdGenerated default setter
     * @param newStuClassRelation */
    public void setStuClassRelation(java.util.Collection<StuClassRelation> newStuClassRelation) {
        removeAllStuClassRelation();
        for (java.util.Iterator iter = newStuClassRelation.iterator(); iter.hasNext();)
            addStuClassRelation((StuClassRelation)iter.next());
    }

    /** @pdGenerated default add
     * @param newStuClassRelation */
    public void addStuClassRelation(StuClassRelation newStuClassRelation) {
        if (newStuClassRelation == null)
            return;
        if (this.stuClassRelation == null)
            this.stuClassRelation = new java.util.HashSet<StuClassRelation>();
        if (!this.stuClassRelation.contains(newStuClassRelation))
            this.stuClassRelation.add(newStuClassRelation);
    }

    /** @pdGenerated default remove
     * @param oldStuClassRelation */
    public void removeStuClassRelation(StuClassRelation oldStuClassRelation) {
        if (oldStuClassRelation == null)
            return;
        if (this.stuClassRelation != null)
            if (this.stuClassRelation.contains(oldStuClassRelation))
                this.stuClassRelation.remove(oldStuClassRelation);
    }

    /** @pdGenerated default removeAll */
    public void removeAllStuClassRelation() {
        if (stuClassRelation != null)
            stuClassRelation.clear();
    }
    /** @pdGenerated default getter */
    public java.util.Collection<Grade> getGrade() {
        if (grade == null)
            grade = new java.util.HashSet<Grade>();
        return grade;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorGrade() {
        if (grade == null)
            grade = new java.util.HashSet<Grade>();
        return grade.iterator();
    }

    /** @pdGenerated default setter
     * @param newGrade */
    public void setGrade(java.util.Collection<Grade> newGrade) {
        removeAllGrade();
        for (java.util.Iterator iter = newGrade.iterator(); iter.hasNext();)
            addGrade((Grade)iter.next());
    }

    /** @pdGenerated default add
     * @param newGrade */
    public void addGrade(Grade newGrade) {
        if (newGrade == null)
            return;
        if (this.grade == null)
            this.grade = new java.util.HashSet<Grade>();
        if (!this.grade.contains(newGrade))
            this.grade.add(newGrade);
    }

    /** @pdGenerated default remove
     * @param oldGrade */
    public void removeGrade(Grade oldGrade) {
        if (oldGrade == null)
            return;
        if (this.grade != null)
            if (this.grade.contains(oldGrade))
                this.grade.remove(oldGrade);
    }

    /** @pdGenerated default removeAll */
    public void removeAllGrade() {
        if (grade != null)
            grade.clear();
    }

}