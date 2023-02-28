package com.example.domain.repo;

import com.example.domain.entity.CategoryResponse;

import io.reactivex.Observable;

public interface MealsRepo {
    Observable<CategoryResponse> getMealsFromRemote();
}
