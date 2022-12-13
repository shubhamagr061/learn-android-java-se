package com.akshara.besoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akshara.besoftware.adapter.ProductAdapter;
import com.akshara.besoftware.api.ApiClient;
import com.akshara.besoftware.api.ApiInterface;
import com.akshara.besoftware.model.Product;
import com.akshara.besoftware.response.FoodResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private String TAG;
    private RecyclerView rvProduct;
    private ProgressBar progressBar;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        setToolbar();
        iniVars();
        getDataFromApi();
    }

    private void iniVars() {
        rvProduct = findViewById(R.id.rvProduct);
        progressBar = findViewById(R.id.progressBar);
    }

    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<FoodResponse> call = apiInterface.getFood();
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                FoodResponse rs = response.body();
                if(rs.isSuccess()){
                    Toast.makeText(ProductActivity.this, rs.getMessage(),Toast.LENGTH_LONG).show();
                    ProductAdapter adapter = new ProductAdapter(ProductActivity.this,
                            rs.getData());
                    rvProduct.setLayoutManager(new LinearLayoutManager(ProductActivity.this,
                            LinearLayoutManager.VERTICAL,false));

                    rvProduct.setAdapter(adapter);
                }else{
                    Toast.makeText(ProductActivity.this, rs.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e("RetrofitApi",t.getMessage());
            }
        });

    }

    private void setToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.txtProductList);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}