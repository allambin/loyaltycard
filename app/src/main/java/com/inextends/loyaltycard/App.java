package com.inextends.loyaltycard;

import android.app.Application;

import com.inextends.loyaltycard.models.DaoMaster;
import com.inextends.loyaltycard.models.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "loyalty_card");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}