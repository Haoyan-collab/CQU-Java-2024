package pojo;

/** @pdOid 507ef268-42ef-42f7-aca5-e4f4bc70b3e8 */
public class Classroom {
    /** @pdOid 172b9dd4-7bb7-4fe3-b671-a1a746945b7d */
    private int classid;
    /** @pdOid 596bb442-0d8d-4959-bddd-f4a503f20323 */
    private int cid;
    /** @pdOid 05111191-0ff5-4b71-86c6-f4a86bc30349 */
    private int tid;
    /** @pdOid c64c2004-06ff-4360-ae1d-ca99e6401632 */
    private java.lang.String semester;
    /** @pdOid 4fe686e6-edee-4ea3-9961-21f575a33aec */
    private int total;
    /** @pdOid 266f7dfb-38f5-42ed-b9ab-2da9c45e2680 */
    private java.lang.String address;

    /** @pdRoleInfo migr=no name=StuClassRelation assc=拥有 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
    public java.util.Collection<StuClassRelation> stuClassRelation;

    /** @pdOid 8e15cbec-cdf1-409c-a599-3d6aea048e8b */
    public int getClassid() {
        return classid;
    }

    /** @param newClassid
     * @pdOid 40b0d1f9-597e-47fb-ac55-0942c4e646be */
    public void setClassid(int newClassid) {
        classid = newClassid;
    }

    /** @pdOid 3bcf0a92-4aa1-462e-b439-2c333ba538e9 */
    public int getCid() {
        return cid;
    }

    /** @param newCid
     * @pdOid 2e614911-dcd7-4b81-9bc4-ab18d31a7440 */
    public void setCid(int newCid) {
        cid = newCid;
    }

    /** @pdOid 982239ea-a239-49e4-8dd4-fc51e2ce9162 */
    public int getTid() {
        return tid;
    }

    /** @param newTid
     * @pdOid adc8f8bd-ae95-47eb-b3c9-4f9025e17d3c */
    public void setTid(int newTid) {
        tid = newTid;
    }

    /** @pdOid db85ebae-e46a-48f3-bb63-1cb016294f0e */
    public java.lang.String getSemester() {
        return semester;
    }

    /** @param newSemester
     * @pdOid dd5fbd52-e598-4ee9-8732-b1e73cf1159e */
    public void setSemester(java.lang.String newSemester) {
        semester = newSemester;
    }

    /** @pdOid 1dfa216d-5bb4-4e67-af84-14ff3794ff22 */
    public int getTotal() {
        return total;
    }

    /** @param newTotal
     * @pdOid 8c5892a6-0322-4363-a095-b09e8145a91e */
    public void setTotal(int newTotal) {
        total = newTotal;
    }

    /** @pdOid 7af4b40c-bfaf-4bc8-82db-9237e53b7957 */
    public java.lang.String getAddress() {
        return address;
    }

    /** @param newAddress
     * @pdOid cb000677-2ef7-41ab-9793-f86abd85294c */
    public void setAddress(java.lang.String newAddress) {
        address = newAddress;
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

    public Classroom(int classid, int cid, int tid, String semester, int total, String address) {
        this.classid = classid;
        this.cid = cid;
        this.tid = tid;
        this.semester = semester;
        this.total = total;
        this.address = address;
    }

}