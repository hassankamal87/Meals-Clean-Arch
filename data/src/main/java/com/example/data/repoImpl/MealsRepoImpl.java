package com.example.data.repoImpl;

import com.example.data.remote.ApiService;
import com.example.domain.entity.CategoryResponse;
import com.example.domain.repo.MealsRepo;

import io.reactivex.Observable;

public class MealsRepoImpl implements MealsRepo {

    private final ApiService apiService;

    public MealsRepoImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<CategoryResponse> getMealsFromRemote() {
        return apiService.getCategoryResponse();
    }
}
