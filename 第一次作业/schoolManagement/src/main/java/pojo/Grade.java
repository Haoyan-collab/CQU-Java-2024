package pojo;

import java.util.*;

/** @pdOid 70641538-c2b7-4941-9c8d-41b0aaa4d4a3 */
public class Grade {
    /**
     * @pdOid 8e2f6596-f26d-4af9-844f-2f128471921b
     */
    private int sid;
    /**
     * @pdOid d5892ecb-f738-4021-aae9-898c593d0646
     */
    private int cid;
    /**
     * @pdOid 430969ad-1c77-4111-b771-620c18be3b34
     */
    private int regular;
    /**
     * @pdOid 399e2377-85c0-462b-9140-0c30a30439c8
     */
    private int midterm;
    /**
     * @pdOid 1db2e0cd-b0a9-4982-bf26-f221efbf1f03
     */
    private int lab;
    /**
     * @pdOid 794a9450-6a44-410c-b8f6-ecea854a283e
     */
    private int end;
    /**
     * @pdOid 89468e4f-3bbb-4dda-8173-e7a91a82ff52
     */
    private int total = 0;
    /**
     * @pdOid cb118fae-0491-46c9-a73a-e040625edd71
     */

    private java.lang.String date;

    private java.lang.String sname;

    private java.lang.String cname;

    /**
     * @pdRoleInfo migr=no name=Course assc=属于 mult=1..1
     */
    public Course course;

    /**
     * @pdOid 5dc1b55b-e504-4947-b509-1ceaf3212514
     */
    public int getSid() {
        return sid;
    }

    /**
     * @param newSid
     * @pdOid 90841904-cb15-4c9e-82d6-9502224f5637
     */
    public void setSid(int newSid) {
        sid = newSid;
    }

    /**
     * @pdOid e196e0f6-bbbf-4061-9d80-f91fed445aca
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param newCid
     * @pdOid dacd72e3-2cc6-442c-9c03-29a289a3be8c
     */
    public void setCid(int newCid) {
        cid = newCid;
    }

    /**
     * @pdOid af423552-26eb-4266-a3c4-8d58de7e9e42
     */
    public int getRegular() {
        return regular;
    }

    /**
     * @param newRegular
     * @pdOid e5661ef0-24a4-4277-bdd7-e4dae91c1ad5
     */
    public void setRegular(int newRegular) {
        regular = newRegular;
    }

    /**
     * @pdOid 3a785bce-5d5c-41d6-b5dc-c1eeb1af1f7b
     */
    public int getMidterm() {
        return midterm;
    }

    /**
     * @param newMidterm
     * @pdOid ab275880-da95-4af6-a82d-d11135875db3
     */
    public void setMidterm(int newMidterm) {
        midterm = newMidterm;
    }

    /**
     * @pdOid 686e3ad6-26da-4d9d-b15e-8df0c59ac412
     */
    public int getLab() {
        return lab;
    }

    /**
     * @param newLab
     * @pdOid d23f37a1-00c7-426e-a455-1aeb815bc123
     */
    public void setLab(int newLab) {
        lab = newLab;
    }

    /**
     * @pdOid 79ca3c86-2cb4-45a4-b035-cce206866346
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param newEnd
     * @pdOid ee695934-b0a5-48ae-b53e-98e650a930ac
     */
    public void setEnd(int newEnd) {
        end = newEnd;
    }

    /**
     * @pdOid f646a197-87bb-470f-b27d-7f765b0ba19d
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param newTotal
     * @pdOid 8ef86dc2-90a6-446d-8234-d97c28164c7f
     */
    public void setTotal(int newTotal) {
        total = newTotal;
    }

    /**
     * @pdOid 75ca4909-1122-491c-ab76-f6e328097b7e
     */
    public java.lang.String getDate() {
        return date;
    }

    /**
     * @param newDate
     * @pdOid d7852ed7-9ad3-4b3c-8ade-e43b96a0ab11
     */
    public void setDate(java.lang.String newDate) {
        date = newDate;
    }

    public java.lang.String getSname() {
        return sname;
    }

    public java.lang.String getCname() {
        return cname;
    }

    public void setCname(String newCname) {
        cname = newCname;
    }

    public void setSname(String newSname)
    {
        sname = newSname;
    }

}