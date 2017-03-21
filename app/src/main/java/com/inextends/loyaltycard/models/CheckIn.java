package com.inextends.loyaltycard.models;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;


@Entity(nameInDb = "check_in")
public class CheckIn {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "loyal_user_id")
    private long loyalUserId;

    @ToOne(joinProperty = "loyalUserId")
    private LoyalUser loyalUser;

    @NotNull
    @Property(nameInDb = "checked_at")
    private Date checkedAt;

    @Property(nameInDb = "deleted")
    private boolean deleted;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 784696749)
    private transient CheckInDao myDao;


    @Generated(hash = 53621199)
    public CheckIn(Long id, long loyalUserId, @NotNull Date checkedAt,
                   boolean deleted) {
        this.id = id;
        this.loyalUserId = loyalUserId;
        this.checkedAt = checkedAt;
        this.deleted = deleted;
    }

    @Generated(hash = 1821846413)
    public CheckIn() {
    }

    @Generated(hash = 1247472245)
    private transient Long loyalUser__resolvedKey;


    public Long getId() {
        return id;
    }

    public Date getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Date checkedAt) {
        this.checkedAt = checkedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLoyalUserId() {
        return this.loyalUserId;
    }

    public void setLoyalUserId(long loyalUserId) {
        this.loyalUserId = loyalUserId;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1754797939)
    public LoyalUser getLoyalUser() {
        long __key = this.loyalUserId;
        if (loyalUser__resolvedKey == null
                || !loyalUser__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LoyalUserDao targetDao = daoSession.getLoyalUserDao();
            LoyalUser loyalUserNew = targetDao.load(__key);
            synchronized (this) {
                loyalUser = loyalUserNew;
                loyalUser__resolvedKey = __key;
            }
        }
        return loyalUser;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 870398031)
    public void setLoyalUser(@NotNull LoyalUser loyalUser) {
        if (loyalUser == null) {
            throw new DaoException(
                    "To-one property 'loyalUserId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.loyalUser = loyalUser;
            loyalUserId = loyalUser.getId();
            loyalUser__resolvedKey = loyalUserId;
        }
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
    @Generated(hash = 2102339891)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCheckInDao() : null;
    }
}
