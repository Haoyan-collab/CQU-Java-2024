package pojo;
import java.util.*;

/** @pdOid 9a255ec7-dd09-48a0-bfe8-24bba89d95d2 */
public class Course {
    /** @pdOid dd58f0dc-06dd-4cbe-a981-32dfe745d687 */
    private int cid;
    /** @pdOid f0f1542b-4881-4900-bf9f-2f65723adbb5 */
    private java.lang.String cname;


    /** @pdOid 94729a9e-ab09-4697-acd4-b0975eb594e1 */
    public int getCid() {
        return cid;
    }

    /** @param newCid
     * @pdOid 34aa58fb-15dd-45dd-9216-23f9b74a0abf */
    public void setCid(int newCid) {
        cid = newCid;
    }

    /** @pdOid 7405c538-2e33-4a7d-8300-87fa418c0173 */
    public java.lang.String getCname() {
        return cname;
    }

    /** @param newCname
     * @pdOid 5fe012f5-84c6-43b2-b75f-2e996e18d303 */
    public void setCname(java.lang.String newCname) {
        cname = newCname;
    }

    public Course(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

}