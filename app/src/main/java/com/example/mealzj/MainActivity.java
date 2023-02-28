package com.example.mealzj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.domain.entity.Category;
import com.example.domain.entity.CategoryResponse;
import com.example.domain.useCase.GetMeals;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MealsViewModel mealsViewModel;
    @Inject
    GetMeals getMeals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.category_rv);
        MealsAdapter adapter = new MealsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mealsViewModel = new MealsViewModel(getMeals);
        mealsViewModel.getMeals();

        mealsViewModel.categoryLiveData.observe(this, new Observer<CategoryResponse>() {
            @Override
            public void onChanged(CategoryResponse categoryResponse) {
                adapter.setList((ArrayList<Category>) categoryResponse.categories);
            }
        });


    }
}