package hibernate.mapping;
// Generated Aug 8, 2018 10:29:33 AM by Hibernate Tools 4.3.1



/**
 * Online generated by hbm2java
 */
public class Online  implements java.io.Serializable {


     private long userId;
     private long timestampVal;

    public Online() {
    }

    public Online(long userId, long timestampVal) {
       this.userId = userId;
       this.timestampVal = timestampVal;
    }
   
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getTimestampVal() {
        return this.timestampVal;
    }
    
    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }




}

