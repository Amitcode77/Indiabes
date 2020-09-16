package com.example.apnamall.ViewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnamall.Interfaces.ItemClickListner;
import com.example.apnamall.R;

public class     ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public TextView txtProductName, txtProductDescription,txtProductPrice;
    public ImageView imageView;
    public ItemClickListner listner;

    public ProductViewHolder( View itemView) {
        super (itemView);
        
        imageView = (ImageView) itemView.findViewById (R.id.product_shown_image);
        txtProductName = (TextView) itemView.findViewById (R.id.product_shown_name);
        txtProductDescription = (TextView) itemView.findViewById (R.id.product_shown_description);
        txtProductPrice = (TextView) itemView.findViewById (R.id.product_shown_price);

    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }


    public void onClick(View view)
    {
        listner.onClick(view,getAdapterPosition (),false);
    }
}
