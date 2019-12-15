package com.recip.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.recip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NameActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.byPassMaterialButton)
    MaterialButton byPassMaterialButton;
    @BindView(R.id.byPassEditText)
    EditText byPassEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        ButterKnife.bind(this);
    }

    public void onClick(View view) {
        if (view==byPassMaterialButton){
            String byPassName=byPassEditText.getText().toString();
            if (byPassName.length()<5){
                Toast.makeText(this, "Name too short...", Toast.LENGTH_SHORT).show();
            }
            else  if(TextUtils.isEmpty(byPassName)){
                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show();
            }
            else if(byPassName.length()>=5) {
                Intent byPassIntent = new Intent(NameActivity.this, MainActivity.class);
                byPassIntent.putExtra("name",byPassName);
                startActivity(byPassIntent);

            }
        }
    }
}
