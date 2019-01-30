package mypower.example.com.yingyuenetwork.network.Interface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public interface ResponseCallback {
    public void onResponse(Call call, Response response, String request_data);

    public void onFailure(Call call, Throwable t);
}
