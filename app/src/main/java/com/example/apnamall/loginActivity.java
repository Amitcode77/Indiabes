package com.example.apnamall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnamall.Model.Users;
import com.example.apnamall.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

import static com.example.apnamall.R.id.invisible;
import static com.example.apnamall.R.id.rememberMechkb;
import static com.example.apnamall.R.id.rememberMechkb;

public class loginActivity<AdminLink> extends AppCompatActivity {

    private EditText InputPhoneNumber,InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink;
    private TextView NotAdminLink;
    private String parentDbName = "Users";
    private android.widget.CheckBox cheBoxRememberMe;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        InputPhoneNumber = (EditText) findViewById (R.id.login_phone_number);
        InputPassword = (EditText) findViewById (R.id.login_password);
        LoginButton = (Button) findViewById (R.id.login_btn);

        AdminLink = (TextView)findViewById (R.id.admin_panel_link);
        NotAdminLink = (TextView)findViewById (R.id.not_admin_panel_link);
        loadingBar = new ProgressDialog (this);

        cheBoxRememberMe = (CheckBox) findViewById (rememberMechkb);
        Paper.init (this);

        LoginButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });

        AdminLink.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoginButton.setText ("Login Admin");
                AdminLink.setVisibility (View.INVISIBLE);
                NotAdminLink.setVisibility (View.VISIBLE);
                parentDbName = "Admins";
                cheBoxRememberMe.setVisibility (View.INVISIBLE);
            }
        });

        NotAdminLink.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LoginButton.setText ("Login");
                AdminLink.setVisibility (View.VISIBLE);
                NotAdminLink.setVisibility (View.INVISIBLE);
                cheBoxRememberMe.setVisibility (View.VISIBLE);
                parentDbName = "Users";
            }
        });
    }

    private void LoginUser()
    {
        String phone = InputPhoneNumber.getText ().toString ();
        String password = InputPassword.getText ().toString ();
        if(TextUtils.isEmpty (phone))
        {
            Toast.makeText (this, "Please enter your phone number", Toast.LENGTH_SHORT).show ();
        }
        else if(TextUtils.isEmpty (password))
        {
            Toast.makeText (this, "Please enter your password", Toast.LENGTH_SHORT).show ();
        }
        else{
            loadingBar.setTitle ("Login Your Account");
            loadingBar.setMessage ("Please wait while we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside (false);
            loadingBar.show ();
           // Toast.makeText (this, "checking", Toast.LENGTH_SHORT).show ();

            AllowAccessToAccount(phone,password);
        }

    }

    private void AllowAccessToAccount(final String phone, final String password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance ().getReference ();



//        if(cheBoxRememberMe.isChecked ())
//        {
//            Paper.book ().write (Prevalent.UserPhoneKey,phone);
//            Paper.book ().write (Prevalent.UserPasswordKey,password);
//        }



        RootRef.addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child (parentDbName).child (phone).exists()){   //parentDbName = Users or Admins
                    Users userData = dataSnapshot.child (parentDbName).child (phone).getValue (Users.class);
                    // Toast.makeText (loginActivity.this, "Checked", Toast.LENGTH_SHORT).show ();


                    if(cheBoxRememberMe.isChecked ())
                    {
                        Paper.book ().write (Prevalent.UserPhoneKey,phone);
                        Paper.book ().write (Prevalent.UserPasswordKey,password);
                    }

                    if(userData.getPhone ().equals (phone))
                    {
                        if (userData.getPassword ().equals (password))
                        {
                            if(parentDbName.equals ("Admins"))
                            {
                                Toast.makeText (loginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show ();
                                loadingBar.dismiss ();
                                Intent intent = new Intent(loginActivity.this,AdminCategoryActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity (intent);
                                finish();
                            }
                            else if (parentDbName.equals ("Users"))
                            {
                                Toast.makeText (loginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show ();
                                loadingBar.dismiss ();
                                Intent intent = new Intent(loginActivity.this,HomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                Prevalent.currentOnlineUsers = userData;
                                startActivity (intent);
                                finish();
                            }
                        }
                        else
                        {
                            loadingBar.dismiss ();
                            Toast.makeText (loginActivity.this, "Password is incorrect!", Toast.LENGTH_SHORT).show ();
                        }
                    }
                }
                else {
                    //   Toast.makeText (loginActivity.this,"Account with "+phone+" doesn't exists",Toast.LENGTH_SHORT).show ();
                    Toast.makeText (loginActivity.this, "You need to create your account", Toast.LENGTH_SHORT).show ();
                    loadingBar.dismiss ();            }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
