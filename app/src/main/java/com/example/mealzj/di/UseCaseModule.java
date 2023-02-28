package com.example.mealzj.di;

import com.example.domain.repo.MealsRepo;
import com.example.domain.useCase.GetMeals;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {

    @Provides
    GetMeals provideUseCaseGetMeals(MealsRepo repo){
        return new GetMeals(repo);
    }
}
