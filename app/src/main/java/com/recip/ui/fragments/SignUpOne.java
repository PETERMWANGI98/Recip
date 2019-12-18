package com.recip.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.recip.BuildConfig;
import com.recip.R;
import com.recip.ui.activities.LauncherActivity;
import com.recip.ui.activities.LoginActivity;
import com.recip.ui.activities.signup.SignUpViewModel;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class SignUpOne extends Fragment implements View.OnClickListener {

    private Unbinder unbinder;

    @BindView(R.id.etSignUpEmail)
    TextView etSignUpEmail;

    @BindView(R.id.etSignUpPassword)
    TextView etSignUpPassword;

    @BindView(R.id.btnNextSignUp)
    MaterialButton btnNextSignUp;

    private SignUpViewModel signUpViewModel;

    public SignUpOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up_one, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        signUpViewModel = ViewModelProviders.of(getActivity()).get(SignUpViewModel.class);
        btnNextSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });
        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        startActivity(new Intent(getActivity(), LauncherActivity.class));

    }

    private void fetchData() {
        String signUpEmail = etSignUpEmail.getText().toString().trim();
        String signUpPassword = etSignUpPassword.getText().toString().trim();
        if (validateInputs(signUpEmail, signUpPassword)) {
            Timber.i(signUpEmail);
            HashMap<String, String> userMap = new HashMap<>();
            userMap.put("email", signUpEmail);
            userMap.put("password", signUpPassword);
            signUpViewModel.addUserDate(userMap);
            loadSignUpOneFragment();
        }
    }

    private boolean validateInputs(String signUpEmail, String signUpPassword) {
        if (TextUtils.isEmpty(signUpEmail) || TextUtils.isEmpty(signUpPassword)) {
            Toast.makeText(getActivity(), "Inputs cannot be empty ...", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(signUpEmail).matches()) {
            etSignUpEmail.setError("Invalid Email ...");
            return false;
        } else if (signUpPassword.length() < 6) {
            etSignUpPassword.setError("Password too short...");
            return false;
        } else {
            return true;
        }
    }

    private void loadSignUpOneFragment() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutSignUp, new SignUpSecond());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {


    }


}
