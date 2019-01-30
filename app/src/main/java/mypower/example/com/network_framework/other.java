package mypower.example.com.network_framework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mypower.example.com.yingyuenetwork.network.Interface.ResponseCallback;
import mypower.example.com.yingyuenetwork.network.controller.Interaction;
import mypower.example.com.yingyuenetwork.network.model.YingyueCallback;
import mypower.example.com.yingyuenetwork.network.model.request_network;
import mypower.example.com.yingyuenetwork.network.testPackage.myObj;
import retrofit2.Call;
import retrofit2.Response;

public class other extends AppCompatActivity {
    private TextView tex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);


        tex = (TextView) findViewById(R.id.tex);

        Test();
    }

    Interaction ction;

    public void Test() {
        String urcsl = "http://192.168.0.116:8080/store/";
        String url_parameter_json = "teachcourse/queryCourses";
        myObj entiy = new myObj();
        entiy.setPageSize("1");
        entiy.setPageNumber("1");
        entiy.setCourseType("0770f61be7179c3b1f3c173ddb9fc695");
        ction = request_network.getInstance().create_network(urcsl, url_parameter_json);
        ction.setRuquest_way(Interaction.POST);
        ction.recently_mmHg_HHz(new YingyueCallback<Object>(new ResponseCallback() {
            @Override
            public void onResponse(Call call, Response response, String request_data) {
                tex.setText(request_data);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                tex.setText(t.getMessage() + "=====================");
            }
        }), entiy);
    }

}
