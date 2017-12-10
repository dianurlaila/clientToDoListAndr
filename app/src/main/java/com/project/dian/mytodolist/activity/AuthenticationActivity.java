package com.project.dian.mytodolist.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.dian.mytodolist.R;
import com.project.dian.mytodolist.fragment.AuthenticationFragment;
import com.project.dian.mytodolist.fragment.LoginFragment;
import com.project.dian.mytodolist.fragment.RegisterFragment;

public class AuthenticationActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    public static final int PAGE_AUTH = 0;
    public static final int PAGE_LOGIN = 1;
    public static final int PAGE_REGISTER = 2;


    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        changeFragment(PAGE_AUTH);
    }

    public void changeFragment(int page) {

        switch (page) {

            case PAGE_AUTH:
                currentFragment = AuthenticationFragment.newInstance();
                break;
            case PAGE_LOGIN:
                currentFragment = LoginFragment.newInstance();
                break;
            case PAGE_REGISTER:
                currentFragment = RegisterFragment.newInstance();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, currentFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();

    }
}
