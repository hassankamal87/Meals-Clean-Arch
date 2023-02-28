package com.example.domain.useCase;


import com.example.domain.entity.CategoryResponse;
import com.example.domain.repo.MealsRepo;

import io.reactivex.Observable;

public class GetMeals {

    private MealsRepo repo;

    public GetMeals(MealsRepo repo) {
        this.repo = repo;
    }

    public Observable<CategoryResponse> getMealsOnline(){
        return repo.getMealsFromRemote();
    }

}
