package com.akshara.besoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.akshara.besoftware.adapter.ProductAdapter;
import com.akshara.besoftware.model.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView rvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rvProduct = findViewById(R.id.rvProduct);

        Product product = new Product();
        product.setName("Dell Xps");
        product.setPrice(2600.00);

        Product product2 = new Product();
        product2.setName("Lenovo");
        product2.setPrice(2600.00);

        Product product3 = new Product();
        product3.setName("MSI");
        product3.setPrice(2600.00);

        Product product4 = new Product();
        product4.setName("Razer Blade");
        product4.setPrice(2600.00);

        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(product);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);

        ProductAdapter adapter = new ProductAdapter(ProductActivity.this,
                productArrayList);

        rvProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvProduct.setAdapter(adapter);





    }
}