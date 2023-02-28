package com.example.mealzj.di;

import com.example.data.remote.ApiService;
import com.example.data.repoImpl.MealsRepoImpl;
import com.example.domain.repo.MealsRepo;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepoModule {

    @Provides
    MealsRepo provideRepo(ApiService apiService){
        return new MealsRepoImpl(apiService);
    }
}
