package ru.hackrussia.foodsharing1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView registerRef;
    private TextView recoveryRef;
    private Button loginButton;
    private EditText username;
    private EditText password;
    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerRef = (TextView) findViewById(R.id.ref_register);

        registerRef.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        recoveryRef = (TextView) findViewById(R.id.ref_recovery);

        recoveryRef.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        loginButton = (Button) findViewById(R.id.button_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        logo = (TextView) findViewById(R.id.logo);

        loginButton.setOnClickListener(v -> correctSignIn());

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/twiddlestix.ttf");
        logo.setTypeface(typeFace);

        logo.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CategoryListActivity.class);
            startActivity(intent);
        });
    }

    private void correctSignIn() {
        if (username.length() > 0) {
            if (password.length() > 0) {
                Toast.makeText(this, "Успех!", Toast.LENGTH_SHORT).show();
               // doSignUp();
            } else {
                Toast.makeText(this, "Пустой пароль!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Пустое имя пользователя!", Toast.LENGTH_SHORT).show();
        }
    }

    private void doSignUp() {
        //AuthPayload payload = new AuthPayload(username.getText().toString(), HashUtil.hash(password.getText().toString()));
        //final RequestContainer<AuthPayload> requestContainer = new RequestContainer<>(payload);
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
//                //RequestBody body = RequestBody
//                  //      .create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(requestContainer));
////                Request request = new Request.Builder()
////                        .url("http://91.122.56.48:8084/levelupchat/auth")
////                        .post(body)
////                        .build();
//                try {
////                    Response response = client.newCall(request).execute();
//                    //Gson gson = new Gson();
//                    //ResponseContainer rc = gson.fromJson(response.body().string(), ResponseContainer.class);
//                    //AuthResponse ar = gson.fromJson(rc.getPayload().toString(), AuthResponse.class);
//                    //Log.d(LoginActivity.class.getSimpleName(), ar.getUser().getName());
////                    Log.d(LoginActivity.class.getSimpleName(), response.body().string());
//
//                } catch (IOException e) {
//                    Log.e(LoginActivity.class.getSimpleName(), Log.getStackTraceString(e));
//                }
            }
        }).start();
    }
}
