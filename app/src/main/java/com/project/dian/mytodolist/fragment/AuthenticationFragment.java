package com.project.dian.mytodolist.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.dian.mytodolist.R;
import com.project.dian.mytodolist.activity.AuthenticationActivity;


public class AuthenticationFragment extends Fragment implements View.OnClickListener {
    private Button login_btn;
    private Button reg_btn;

    public AuthenticationFragment() {
        // Required empty public constructor
    }


    public static AuthenticationFragment newInstance() {
        AuthenticationFragment fragment = new AuthenticationFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authentication, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        login_btn = view.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
        reg_btn = view.findViewById(R.id.register_btn);
        reg_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                ((AuthenticationActivity)getActivity()).changeFragment(AuthenticationActivity.PAGE_LOGIN);
                break;

            case R.id.register_btn:
                ((AuthenticationActivity)getActivity()).changeFragment(AuthenticationActivity.PAGE_REGISTER);
                break;
        }
    }
}
