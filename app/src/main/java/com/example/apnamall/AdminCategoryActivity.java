package com.example.apnamall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tShirts,sportsTShirts,femaleDresses,sweathers;
    private ImageView glasses,hats,purses,shoes;
    private ImageView headPhones,laptops,watches,mobiles;

    private Button LogoutBtn, CheckOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_category);
        tShirts = (ImageView) findViewById (R.id.t_shirts);
        sportsTShirts = (ImageView) findViewById (R.id.sports_t_shirts);
        femaleDresses = (ImageView) findViewById (R.id.female_dresses);
        sweathers = (ImageView) findViewById (R.id.sweathers);
        glasses = (ImageView) findViewById (R.id.glasses);
        hats = (ImageView) findViewById (R.id.hats);
        purses = (ImageView) findViewById (R.id.purses_bags_wallet);
        shoes = (ImageView) findViewById (R.id.shoes);
        headPhones = (ImageView) findViewById (R.id.headphoness);
        laptops = (ImageView) findViewById (R.id.laptops);
        watches = (ImageView) findViewById (R.id.watches);
        mobiles = (ImageView) findViewById (R.id.mobile);


        CheckOrderBtn = (Button) findViewById(R.id.check_orders_btn);
        LogoutBtn = (Button) findViewById(R.id.admin_logout_btn);

        tShirts.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","tShirts");
                startActivity (intent);
            }
       });

        sportsTShirts.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","sportsTShirts");
                startActivity (intent);
            }
         });

        femaleDresses.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","femaleDresses");
                startActivity (intent);
            }
        });

        sweathers.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","sweathers");
                startActivity (intent);
            }
        });

        glasses.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","glasses");
                startActivity (intent);
            }
        });

        hats.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","hats");
                startActivity (intent);
            }
        });

        purses.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","purses");
                startActivity (intent);
            }
        });

        shoes.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","shoes");
                startActivity (intent);
            }
        });

        headPhones.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","headPhones");
                startActivity (intent);
            }
        });

        laptops.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","laptops");
                startActivity (intent);
            }
        });

        watches.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","watches");
                startActivity (intent);
            }
        });

        mobiles.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AdminCategoryActivity.this,AdminAddProduct.class);
                intent.putExtra ("category","mobiles");
                startActivity (intent);
            }
        });


        CheckOrderBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminsNewOrdersActivity.class);
                startActivity(intent);



            }
        });


        LogoutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

}

}
