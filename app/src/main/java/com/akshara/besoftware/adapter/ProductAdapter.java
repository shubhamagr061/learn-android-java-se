package com.akshara.besoftware.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshara.besoftware.R;
import com.akshara.besoftware.api.Api;
import com.akshara.besoftware.model.Food;
import com.akshara.besoftware.model.Product;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private ArrayList<Food> productArrayList;

    public ProductAdapter(Context context, ArrayList<Food> productArrayList){
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Food item  = productArrayList.get(position);
        holder.tvTitle.setText(item.getName());
        holder.tvPrice.setText(String.format("NRs. %s",item.getPrice()));
//        https://oishirestaurant.akshara.com.np/storage/69/user.png
        Glide.with(context)
                .load(Api.BASE_URL+item.getUrl())
                .placeholder(R.drawable.dish)
                .into(holder.ivProduct);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProduct;
        private TextView tvTitle, tvPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
