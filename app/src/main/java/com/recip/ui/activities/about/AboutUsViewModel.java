package com.recip.ui.activities.about;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.R;
import com.recip.models.About;

import java.util.ArrayList;

public class AboutUsViewModel extends ViewModel {
    private MutableLiveData<ArrayList<About>> listMutableLiveData;
    private ArrayList<About> aboutArrayList=new ArrayList<>();

    public AboutUsViewModel() {
        listMutableLiveData = new MutableLiveData<>();

        //call REST API in init method
        init();
    }

    MutableLiveData<ArrayList<About>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    private void init() {
        populateList();
        listMutableLiveData.setValue(aboutArrayList);

    }

    private void populateList() {
        About aboutApp = new About(R.drawable.ic_home_black_24dp, "Recip", "Recip App");
        About aboutVersion = new About(R.drawable.ic_info_outline_black_24dp, "Version", "1.0.0");
        About aboutCompany = new About(R.drawable.ic_group_work_black_24dp, "Company", "Discover Solutions");
        About aboutEmail = new About(R.drawable.ic_email_black_24dp, "Email", "recipweb@gmail.com");
        About aboutWebsite = new About(R.drawable.ic_web_black_24dp, "Website", "www.dummy.com");
        About contact = new About(R.drawable.ic_local_phone_black_24dp, "Contact", "+254 707 851 734");

        aboutArrayList.add(aboutApp);
        aboutArrayList.add(aboutVersion);
        aboutArrayList.add(aboutCompany);
        aboutArrayList.add(aboutEmail);
        aboutArrayList.add(aboutWebsite);
        aboutArrayList.add(contact);

    }
}
