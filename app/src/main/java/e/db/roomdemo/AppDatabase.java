package e.db.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDuo userDuo();
}
