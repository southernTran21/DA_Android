package com.example.da_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_main extends AppCompatActivity {
    Button main_btn;
    EditText UserName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();
        UserName = findViewById(R.id.User);
        Password = findViewById(R.id.Pass);
        main_btn = (Button) findViewById(R.id.Login);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.PATH)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

                Call<List<Post>> call = jsonPlaceHolderApi.getPost();
                call.enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                        if (TextUtils.isEmpty(UserName.getText().toString()) || TextUtils.isEmpty(Password.getText().toString())) {
                            String message = "khong de trong";
                            Toast.makeText(Login_main.this, message, Toast.LENGTH_LONG).show();
                        } else {
                            List<Post> posts = response.body();

//                            System.out.println(posts.indexOf(UserName.getText().toString()));

                            for (Post post : posts) {
                                System.out.println("input" + UserName.getText().toString());
                                System.out.println("api" + post.getUsername());

                                if (UserName.getText().toString().equals(post.getUsername()) == true &&
                                        Password.getText().toString().equals(post.getPassword()) == true) {
                                    System.out.println("check username" + post.getUsername());
                                    String message = "Dang nhap thanh cong";
                                    Toast.makeText(Login_main.this, message, Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(getBaseContext(),Home_main.class);
                                    startActivity(intent);
                                    break;
                                } else if(UserName.getText().toString().equals(post.getUsername()) == true &&
                                        Password.getText().toString().equals(post.getPassword()) == false) {
                                    String message = "Mat Khau Sai";
                                    Toast.makeText(Login_main.this, message, Toast.LENGTH_LONG).show();
                                    break;
                                }
                                else{
                                    String message = "Mat Khau Hoac Ten Dang Nhap Khong Dung";
                                    Toast.makeText(Login_main.this, message, Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                    }
                });

            }
        });
    }
}
