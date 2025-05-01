package pojo;
import java.util.*;

/** @pdOid e56d1fae-1b2c-4a06-8348-1bc4db428190 */
public class StuClassRelation {
    /** @pdOid 67c92fe4-85c7-4a1d-9e0a-3d4eeb1dfa4b */
    private int sid;
    /** @pdOid 0105ac64-65d6-442f-b093-5fed447cee1e */
    private int classid;

    /** @pdOid 475df46c-ef13-477e-8671-abd9cffe76fd */
    public int getSid() {
        return sid;
    }

    /** @param newSid
     * @pdOid 7d32f375-970a-44f7-ace1-a98eda296e2b */
    public void setSid(int newSid) {
        sid = newSid;
    }

    /** @pdOid cfbb8229-3757-4cab-b1e5-3850a1e7cb90 */
    public int getClassid() {
        return classid;
    }

    /** @param newClassid
     * @pdOid 5991be42-a0f6-4286-8988-6bd2e0df0883 */
    public void setClassid(int newClassid) {
        classid = newClassid;
    }

    public void StuClassRelation(int sid,int classid)
    {
        this.sid=sid;
        this.classid=classid;
    }
}