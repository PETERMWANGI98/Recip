package com.recip.ui.activities.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class SignUpViewModel extends ViewModel {
    HashMap<String, String> userDataMap = new HashMap<>();
    private MutableLiveData<HashMap<String, String>> userMapMutableLiveData;

    public SignUpViewModel() {
        userMapMutableLiveData = new MutableLiveData<>();
    }

    public void addUserDate(HashMap<String, String> hashMap) {
        userDataMap = hashMap;
        userMapMutableLiveData.setValue(userDataMap);
    }


    public MutableLiveData<HashMap<String, String>> getUserMapMutableLiveData() {
        return userMapMutableLiveData;
    }
}
