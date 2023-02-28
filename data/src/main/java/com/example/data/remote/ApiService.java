package com.example.data.remote;

import com.example.domain.entity.CategoryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("categories.php")
    Observable<CategoryResponse> getCategoryResponse();
}
