package com.braunster.chatsdk.dao;

import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.dao.core.DaoCore;
import com.braunster.chatsdk.dao.entities.BMessageEntity;
import com.braunster.chatsdk.dao.entities.BMessageReceiptEntity;
import com.braunster.chatsdk.dao.entities.Entity;
import com.braunster.chatsdk.network.BFirebaseDefines;
import com.braunster.chatsdk.network.BNetworkManager;
import com.braunster.chatsdk.network.BPath;
import android.util.Log;

import java.util.Calendar;

import timber.log.Timber;

import static com.braunster.chatsdk.dao.entities.BMessageReceiptEntity.ReadStatus.none;
// KEEP INCLUDES END
/**
 * Entity mapped to table BMESSAGE.
 */
public class BMessage extends BMessageEntity  {

    private Long id;
    private String entityID;
    private java.util.Date date;
    private Boolean isRead;
    private String resources;
    private String resourcesPath;
    private String text;
    private String imageDimensions;
    private Integer type;
    private Integer status;
    private Integer delivered;
    private Long Sender;
    private Long messageReceiptsId;
    private Long BThreadDaoId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BMessageDao myDao;

    private BUser BUserSender;
    private Long BUserSender__resolvedKey;

    private BThread BThread;
    private Long BThread__resolvedKey;

    private List<BMessageReceipt> bMessageReceiptList;

    // KEEP FIELDS - put your custom fields here
    public static final String TAG = BMessage.class.getSimpleName();
    public String logMessage;
    public static final boolean DEBUG = Debug.BMessage;
    public String color = null;
    public String fontName = null;
    public String textColor = null;
    public int fontSize = -1;
    // KEEP FIELDS END

    public BMessage() {
    }

    public BMessage(Long id) {
        this.id = id;
    }

    public BMessage(Long id, String entityID, java.util.Date date, Boolean isRead, String resources, String resourcesPath, String text, String imageDimensions, Integer type, Integer status, Integer delivered, Long Sender, Long messageReceiptsId, Long BThreadDaoId) {
        this.id = id;
        this.entityID = entityID;
        this.date = date;
        this.isRead = isRead;
        this.resources = resources;
        this.resourcesPath = resourcesPath;
        this.text = text;
        this.imageDimensions = imageDimensions;
        this.type = type;
        this.status = status;
        this.delivered = delivered;
        this.Sender = Sender;
        this.messageReceiptsId = messageReceiptsId;
        this.BThreadDaoId = BThreadDaoId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBMessageDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageDimensions() {
        return imageDimensions;
    }

    public void setImageDimensions(String imageDimensions) {
        this.imageDimensions = imageDimensions;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Long getSender() {
        return Sender;
    }

    public void setSender(Long Sender) {
        this.Sender = Sender;
    }

    public Long getMessageReceiptsId() {
        return messageReceiptsId;
    }

    public void setMessageReceiptsId(Long messageReceiptsId) {
        this.messageReceiptsId = messageReceiptsId;
    }

    public Long getBThreadDaoId() {
        return BThreadDaoId;
    }

    public void setBThreadDaoId(Long BThreadDaoId) {
        this.BThreadDaoId = BThreadDaoId;
    }

    /** To-one relationship, resolved on first access. */
    public BUser getBUserSender() {
        Long __key = this.Sender;
        if (BUserSender__resolvedKey == null || !BUserSender__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser BUserSenderNew = targetDao.load(__key);
            synchronized (this) {
                BUserSender = BUserSenderNew;
            	BUserSender__resolvedKey = __key;
            }
        }
        return BUserSender;
    }

    public void setBUserSender(BUser BUserSender) {
        synchronized (this) {
            this.BUserSender = BUserSender;
            Sender = BUserSender == null ? null : BUserSender.getId();
            BUserSender__resolvedKey = Sender;
        }
    }

    /** To-one relationship, resolved on first access. */
    public BThread getBThread() {
        Long __key = this.BThreadDaoId;
        if (BThread__resolvedKey == null || !BThread__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BThreadDao targetDao = daoSession.getBThreadDao();
            BThread BThreadNew = targetDao.load(__key);
            synchronized (this) {
                BThread = BThreadNew;
            	BThread__resolvedKey = __key;
            }
        }
        return BThread;
    }

    public void setBThread(BThread BThread) {
        synchronized (this) {
            this.BThread = BThread;
            BThreadDaoId = BThread == null ? null : BThread.getId();
            BThread__resolvedKey = BThreadDaoId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BMessageReceipt> getBMessageReceiptList() {
        if (bMessageReceiptList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BMessageReceiptDao targetDao = daoSession.getBMessageReceiptDao();
            List<BMessageReceipt> bMessageReceiptListNew = targetDao._queryBMessage_BMessageReceiptList(id);
            synchronized (this) {
                if(bMessageReceiptList == null) {
                    bMessageReceiptList = bMessageReceiptListNew;
                }
            }
        }
        return bMessageReceiptList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBMessageReceiptList() {
        bMessageReceiptList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public BPath getBPath() {
        if (getBThread() == null)
        {
            if (DEBUG) Timber.e("Owner Thread is null");
            return null;
        }
        return getBThread().getBPath().addPathComponent(BFirebaseDefines.Path.BMessagesPath, entityID);
    }

    @Override
    public Entity.Type getEntityType() {
        return Entity.Type.bEntityTypeMessages;
    }

    public boolean isSameDayAsMessage(BMessage message){
        // Current time.
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(date);
        // Message time.
        Calendar messageCalendar = Calendar.getInstance();
        messageCalendar.setTime(message.getDate());
        // Compare
        return isSameDay(nowCalendar, messageCalendar);
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null)
            return false;

        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public boolean isMine(){
        return getBUserSender().equals(BNetworkManager.sharedManager().getNetworkAdapter().currentUserModel());
    }

    @Override
    public String color() {
        return getBUserSender().getMessageColor();
    }

    public Integer getStatusOrNull(){
        if (status == null)
            status = BMessageEntity.Status.NULL;

        return status;
    }
    
    public int wasDelivered(){
       return delivered == null ? BMessageReceiptEntity.ReadStatus.delivered : none;
        
    }

    /** Null safe version of getIsRead*/
    public boolean wasRead(){
        return isRead==null || isRead;
    }

    @Override
    public String toString() {
        return String.format("BMessage, id: %s, type: %s, Sender: %s", id, type, getBUserSender());
    }

    public List<BUser> getBThreadUsers(){
        Long __key = this.BThread__resolvedKey;
        List<BUser> users = null;
        BThreadDao targetDao;
        BThread bThread;

        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        targetDao = daoSession.getBThreadDao();
        bThread = targetDao.load(__key);
        users = bThread.getUsers();

        return users;
    }

    /***
     * used for initial creation of receipts
     * @param reader
     * @param messageReceiptStatus
     * @return returns true if the readReceipt needed to be updated
     */
    public Boolean setUserReadReceipt(BUser reader, int messageReceiptStatus){

        // Add the read receipt to the local dao database
        BMessageReceipt bMessageReceipt = new BMessageReceipt();
        List readReceipts = getBMessageReceiptList();

        // Check for existing read receipt, and return if it should not be changed
        BMessageReceipt oldBMessageReceipt = getUserReadReceipt(reader);
        // If user is not is null, and not being initialized, return
        if(oldBMessageReceipt.getReadStatus() == null && messageReceiptStatus != none) return false;
        // If user is is not null, make sure a higher status value is not overwritten.
        if(oldBMessageReceipt.getReadStatus() != null) {
            if (oldBMessageReceipt.getReadStatus() > messageReceiptStatus) return false;
            // Remove old user read receipt
            removeUserReadReceipt(reader);
        }
        // Update read receipt
        bMessageReceipt.setReader(reader);
        bMessageReceipt.setReaderId(reader.getId());
        bMessageReceipt.setBMessage(this);
        bMessageReceipt.setBMessageId(this.getId());
        bMessageReceipt.setReadStatus(messageReceiptStatus);
        daoSession.insert(bMessageReceipt);
        readReceipts.add(bMessageReceipt);
        DaoCore.updateEntity(this);
        return true;
    }

    public BMessageReceipt getUserReadReceipt(BUser reader){
        List<BMessageReceipt> readReceipts = getBMessageReceiptList();

        // Check for read receipt and remove it if it is lower, return if it should not be changed
        for( BMessageReceipt bMessageReceipt : readReceipts){
            if(bMessageReceipt.getReader().getEntityID().equals(reader.getEntityID())){
                return bMessageReceipt;
            }
        }

        return new BMessageReceipt();
    }

    public void removeUserReadReceipt(BUser reader){
        List readReceipts = getBMessageReceiptList();
        BMessageReceipt bMessageReceipt = getUserReadReceipt(reader);
        daoSession.delete(bMessageReceipt);
        readReceipts.remove(bMessageReceipt);
    }

    //Initialize all readers in the list of listeners in the thread to be included in reader list
    public void initBMessageReceipts(){
        List<BUser> readers;
        readers = getBThreadUsers();

        // Do not init for public threads.
        if(this.getBThread().getType() == com.braunster.chatsdk.dao.BThread.Type.Public) return;

        // If no readers, why should there be receipts?
        if (readers.isEmpty()){ return; }

        // add all users in the chat other than yourself
        for (BUser reader : readers) {
            if (getBUserSender().equals(reader)) continue;
            setUserReadReceipt(reader, none);
        }
    }

    //Returns the ReadStatus that is representative lowest common read Status of all users in Map
    public int getCommonReadStatus(){
        List<BMessageReceipt> readReceipts;
        readReceipts = getBMessageReceiptList();

        Boolean delivered = false;
        Boolean read = false;

        for ( BMessageReceipt readReceipt : readReceipts) {
            switch (readReceipt.getReadStatus()) {
                case none:
                    return none;
                case BMessageReceiptEntity.ReadStatus.delivered:
                    delivered = true;
                    break;
                case BMessageReceiptEntity.ReadStatus.read:
                    read = true;
                    break;
            }
        }
        if(delivered){
            return BMessageReceiptEntity.ReadStatus.delivered;
        } else if (read) {
            return BMessageReceiptEntity.ReadStatus.read;
        } else {
            logMessage = "Message has no readers";
            if(DEBUG) Log.d(TAG , logMessage);
            return none;
        }
    }
    // KEEP METHODS END

}
