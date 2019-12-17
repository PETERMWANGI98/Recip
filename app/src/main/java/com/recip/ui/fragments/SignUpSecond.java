package com.recip.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.recip.R;
import com.recip.ui.activities.LoginActivity;
import com.recip.ui.activities.signup.SignUpViewModel;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sentry.Sentry;
import timber.log.Timber;


public class SignUpSecond extends Fragment implements View.OnClickListener {


    Unbinder unbinder;
    private HashMap<String, String> mUserMap;

    @BindView(R.id.signUpAddAvatar)
    ImageView signUpAddAvatar;

    @BindView(R.id.signUpUserAvatar)
    ImageView signUpUserAvatar;

    @BindView(R.id.etSignUpName)
    TextView etSignUpName;

    @BindView(R.id.btnFinishSignUp)
    MaterialButton btnFinishSignUp;

    @BindView(R.id.mSignUpProgress)
    ProgressBar mSignUpProgress;

    @BindView(R.id.constraintUser)
    ConstraintLayout constraintLayout;

    private FirebaseAuth mAuth;


    public SignUpSecond() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up_second, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        SignUpViewModel signUpViewModel = ViewModelProviders.of(getActivity()).get(SignUpViewModel.class);
        signUpViewModel.getUserMapMutableLiveData().observe(this, new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> hashMap) {
                Timber.i(hashMap.get("email"));
                mUserMap = new HashMap<>();
                mUserMap.putAll(hashMap);
            }
        });

        btnFinishSignUp.setOnClickListener(this);
        signUpAddAvatar.setOnClickListener(this);

        return rootView;
    }

    private void addUserExtras() {
        String userName = etSignUpName.getText().toString().trim();
        if (!TextUtils.isEmpty(userName) && userName.length() >= 5) {
            mUserMap.put("username", userName);
            signUpUser(mUserMap.get("email"), mUserMap.get("password"));


        } else {
            Toast.makeText(getActivity(), "Username must have 5 letters or more...", Toast.LENGTH_SHORT).show();
        }

    }


    private void signUpUser(String email, String password) {
        mSignUpProgress.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Timber.i("createUserWithEmail:success".concat(task.getResult().getUser().getUid()));
                            mSignUpProgress.setVisibility(View.GONE);

                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Timber.w("createUserWithEmail:failure %s", Objects.requireNonNull(task.getException()).getMessage());
                            Toast.makeText(getActivity(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        if (v == btnFinishSignUp) {
            addUserExtras();
        }
        if (v == signUpAddAvatar) {
            getUserImage();
        }

    }

    private void getUserImage() {
        Intent intent=new Intent();

    }
}
