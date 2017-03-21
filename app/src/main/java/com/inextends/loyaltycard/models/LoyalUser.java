package com.inextends.loyaltycard.models;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

@Entity(indexes = {@Index(value = "phoneNumber DESC", unique = true)}, nameInDb = "loyal_user")
public class LoyalUser {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    @Property(nameInDb = "phone_number")
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    @ToMany(referencedJoinProperty = "loyalUserId")
    @OrderBy("checkedAt ASC")
    private List<CheckIn> checkIns;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 8054010)
    private transient LoyalUserDao myDao;

    @Generated(hash = 1085733375)
    public LoyalUser(Long id, @NotNull String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    @Generated(hash = 2073440191)
    public LoyalUser() {
    }

    @NotNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1130380989)
    public List<CheckIn> getCheckIns() {
        if (checkIns == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CheckInDao targetDao = daoSession.getCheckInDao();
            List<CheckIn> checkInsNew = targetDao._queryLoyalUser_CheckIns(id);
            synchronized (this) {
                if (checkIns == null) {
                    checkIns = checkInsNew;
                }
            }
        }
        return checkIns;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1377898073)
    public synchronized void resetCheckIns() {
        checkIns = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 276229526)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLoyalUserDao() : null;
    }
}
