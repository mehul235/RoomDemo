package e.db.roomdemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.stetho.Stetho;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    @BindView(R.id.fb)
    FloatingActionButton fb;

    @OnClick(R.id.fb)
    void btnAdd() {
        startActivity(new Intent(MainActivity.this, CreateUser.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        ButterKnife.bind(this);
        /*for (int i = 0; i < 100; i++) {
            User user = new User("Mehul # " + i, "Parmar", "email");
            users.add(user);
        }*/

        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<User> users = appDatabase.userDuo().getAllUser();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
