package mypower.example.com.yingyuenetwork.network.model;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import mypower.example.com.yingyuenetwork.network.Interface.ResponseCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YingyueCallback<T> implements Callback {

    ResponseCallback callback;


    public YingyueCallback(ResponseCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(Call call, Response response) {
        String responses = "";
        try {
            responses = JSON.toJSONString(response.body());
        } catch (Exception e) {
            responses = "";
        }
        callback.onResponse(call, response, responses);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        callback.onFailure(call, t);
    }
}
