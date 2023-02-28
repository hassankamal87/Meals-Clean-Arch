package com.example.mealzj;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.domain.entity.CategoryResponse;
import com.example.domain.useCase.GetMeals;



import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


@HiltViewModel
public class MealsViewModel extends ViewModel {

    MutableLiveData<CategoryResponse> categoryLiveData = new MutableLiveData<>();

    private final GetMeals getMeals;

    @Inject
    public MealsViewModel(GetMeals getMeals) {
        this.getMeals = getMeals;
    }

    public void getMeals(){
        getMeals.getMealsOnline()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CategoryResponse categoryResponse) {
                categoryLiveData.setValue(categoryResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("fun", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
