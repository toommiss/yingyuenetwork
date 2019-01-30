package mypower.example.com.network_framework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.IOException;

import mypower.example.com.dome.myObj;
import mypower.example.com.yingyuenetwork.network.Interface.ResponseCallback;
import mypower.example.com.yingyuenetwork.network.controller.Interaction;
import mypower.example.com.yingyuenetwork.network.model.YingyueCallback;
import mypower.example.com.yingyuenetwork.network.model.request_network;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inew = new Intent(MainActivity.this, other.class);
                startActivity(inew);
            }
        });

    }
}
