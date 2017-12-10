package com.project.dian.mytodolist.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.project.dian.mytodolist.R;
import com.project.dian.mytodolist.fragment.AddListFragment;
import com.project.dian.mytodolist.fragment.MyLIstFragment;
import com.project.dian.mytodolist.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    public static final int PAGE_LIST = 0;
    public static final int PAGE_ADD = 1;
    public static final int PAGE_SETTING = 2;

    private Fragment currentFragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_mylist:
                    changeFragment(PAGE_LIST);
                    return true;
                case R.id.nav_addlist:
                    changeFragment(PAGE_ADD);
                    return true;
                case R.id.nav_setting:
                    changeFragment(PAGE_SETTING);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        changeFragment(PAGE_LIST);
    }


    public void changeFragment(int page) {

        switch (page) {

            case PAGE_LIST:
                currentFragment = MyLIstFragment.newInstance();
                break;
            case PAGE_ADD:
                currentFragment = AddListFragment.newInstance();
                break;
            case PAGE_SETTING:
                currentFragment = SettingFragment.newInstance();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_list, currentFragment)
                .addToBackStack(null)
                .commit();
    }

}
