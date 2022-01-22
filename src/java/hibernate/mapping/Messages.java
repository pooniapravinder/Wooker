package hibernate.mapping;
// Generated Aug 9, 2018 6:16:59 PM by Hibernate Tools 4.3.1



/**
 * Messages generated by hbm2java
 */
public class Messages  implements java.io.Serializable {


     private long msgId;
     private Usermessages usermessages;
     private String userMessage;
     private String mediaId;
     private String origName;
     private String mediaType;
     private Long mediaSize;

    public Messages() {
    }

	
    public Messages(Usermessages usermessages) {
        this.usermessages = usermessages;
    }
    public Messages(Usermessages usermessages, String userMessage, String mediaId, String origName, String mediaType, Long mediaSize) {
       this.usermessages = usermessages;
       this.userMessage = userMessage;
       this.mediaId = mediaId;
       this.origName = origName;
       this.mediaType = mediaType;
       this.mediaSize = mediaSize;
    }
   
    public long getMsgId() {
        return this.msgId;
    }
    
    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
    public Usermessages getUsermessages() {
        return this.usermessages;
    }
    
    public void setUsermessages(Usermessages usermessages) {
        this.usermessages = usermessages;
    }
    public String getUserMessage() {
        return this.userMessage;
    }
    
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public String getMediaId() {
        return this.mediaId;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    public String getOrigName() {
        return this.origName;
    }
    
    public void setOrigName(String origName) {
        this.origName = origName;
    }
    public String getMediaType() {
        return this.mediaType;
    }
    
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public Long getMediaSize() {
        return this.mediaSize;
    }
    
    public void setMediaSize(Long mediaSize) {
        this.mediaSize = mediaSize;
    }




}

