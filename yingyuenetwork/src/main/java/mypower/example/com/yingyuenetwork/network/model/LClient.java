package mypower.example.com.yingyuenetwork.network.model;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Lerist on 2017/07/09 0009.
 */

public class LClient {

    public final Retrofit retrofit;

    //超时时间
    public long timeout = 15;

    public LClient(String baseUrl) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public long getTimeout() {
        return timeout;
    }

    /**
     * 设置超时时间
     *
     * @param timeoutseconds 单位: s
     */
    public void setTimeout(long timeoutseconds) {
        this.timeout = timeoutseconds;
    }

    public <T> T getService(Class<T> serviceClazz) {
        return retrofit.create(serviceClazz);
    }
}
