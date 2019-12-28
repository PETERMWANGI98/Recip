package com.recip.ui.fragments.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.recip.models.Summary;
import com.recip.network.RecipClient;
import com.recip.network.RecipeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class DetailsViewModel extends ViewModel {
    MutableLiveData<Summary> mSummaryMutableLiveData;
    Summary mSummary;

    public DetailsViewModel() {
        mSummaryMutableLiveData = new MutableLiveData<>();
        mSummary = new Summary();
        getSummary();
    }

    private void getSummary() {
        pullRecipeSummary();
    }

    private void pullRecipeSummary() {
        RecipeApi mRecipeApi = RecipClient.getClient();
        Call<Summary> summaryCall = mRecipeApi.getRecipeSummary(4632);
        summaryCall.enqueue(new Callback<Summary>() {
            @Override
            public void onResponse(Call<Summary> call, Response<Summary> response) {
                if (response.isSuccessful()) {
                    mSummary = response.body();
                    mSummaryMutableLiveData.setValue(mSummary);

                }
            }

            @Override
            public void onFailure(Call<Summary> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public MutableLiveData<Summary> getmSummaryMutableLiveData() {
        return mSummaryMutableLiveData;
    }
}
