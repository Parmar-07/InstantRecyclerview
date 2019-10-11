package instant.recyclerview.demo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import instant.recyclerview.demo.custom.CustomRecyclerView;
import instant.recyclerview.demo.simple.SimpleRecyclerView;

public class MainActivity extends AppCompatActivity {

    private Fragment recylcerViewFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylcerViewFragment = SimpleRecyclerView.createRecyclerView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.simple:
                                recylcerViewFragment = SimpleRecyclerView.createRecyclerView();
                                break;
                            case R.id.custom:
                                recylcerViewFragment = CustomRecyclerView.createRecyclerView();
                                break;
                        }
                        loadView(recylcerViewFragment);
                        return true;
                    }
                });

        loadView(recylcerViewFragment);

    }


    private void loadView(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}
