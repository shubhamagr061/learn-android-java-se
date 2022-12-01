package com.akshara.besoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

    private RecyclerView rvProduct;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rvProduct = findViewById(R.id.rvProduct);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<FoodResponse> call = apiInterface.getFood();
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
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

            }
        });

//        Product product = new Product();
//        product.setName("Dell Xps");
//        product.setPrice(2600.00);
//
//        Product product2 = new Product();
//        product2.setName("Lenovo");
//        product2.setPrice(2600.00);
//
//        Product product3 = new Product();
//        product3.setName("MSI");
//        product3.setPrice(2600.00);
//
//        Product product4 = new Product();
//        product4.setName("Razer Blade");
//        product4.setPrice(2600.00);
//
//        ArrayList<Product> productArrayList = new ArrayList<>();
//        productArrayList.add(product);
//        productArrayList.add(product2);
//        productArrayList.add(product3);
//        productArrayList.add(product4);

    }
}