package e.db.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDuo {

    @Query("SELECT * FROM User")
    List<User> getAllUser();

    @Insert
    void insertAll(User... users);
}
