package com.recip.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.provider.MediaStore;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.recip.R;
import com.recip.models.FirebaseUser;
import com.recip.ui.activities.LoginActivity;
import com.recip.ui.activities.signup.SignUpViewModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import io.sentry.Sentry;
import timber.log.Timber;

import static android.app.Activity.RESULT_OK;


public class SignUpSecond extends Fragment implements View.OnClickListener {


    Unbinder unbinder;

    View rootView;
    private HashMap<String, String> mUserMap;

    @BindView(R.id.signUpAddAvatar)
    ImageView signUpAddAvatar;

    @BindView(R.id.signUpUserAvatar)
    CircleImageView signUpUserAvatar;

    @BindView(R.id.etSignUpName)
    TextView etSignUpName;

    @BindView(R.id.btnFinishSignUp)
    MaterialButton btnFinishSignUp;

    @BindView(R.id.mSignUpProgress)
    ProgressBar mSignUpProgress;

    @BindView(R.id.constraintUser)
    ConstraintLayout constraintLayout;

    private FirebaseAuth mAuth;

    private static final int GALLERY_REQUEST_CODE = 100;

    private DatabaseReference usersDatabaseRef;

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
        rootView = inflater.inflate(R.layout.fragment_sign_up_second, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        usersDatabaseRef = FirebaseDatabase.getInstance().getReference();


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
            Snackbar.make(rootView, "Continue with no picture ?", Snackbar.LENGTH_SHORT)
                    .show();

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
                            String userId = task.getResult().getUser().getUid();
                            Timber.i("createUserWithEmail:success".concat(userId));
                            mUserMap.put("user_id", userId);
                            mUserMap.put("avatar_url", "https://pixinvent.com/materialize-material-design-admin-template/app-assets/images/user/12.jpg");
                            Timber.i("createUserWithEmail:success".concat(task.getResult().getUser().getUid()));

                            //save user here
                            saveNewUser(mUserMap);

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

    private void saveNewUser(HashMap<String, String> mUserMap) {

        FirebaseUser firebaseUser = new FirebaseUser(
                mUserMap.get("user_id"),
                mUserMap.get("username"),
                mUserMap.get("email"),
                mUserMap.get("avatar_url"));
        usersDatabaseRef.child("users").child(mUserMap.get("user_id")).setValue(firebaseUser)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Suucessful", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG)
                        .show();
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
            chooseImage();
        }

    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                signUpUserAvatar.setImageBitmap(bitmap);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
