package mypower.example.com.yingyuenetwork.network.controller;

import com.alibaba.fastjson.JSON;

import mypower.example.com.yingyuenetwork.network.model.LClient;
import mypower.example.com.yingyuenetwork.network.model.MerchantService;
import mypower.example.com.yingyuenetwork.network.model.YingyueCallback;
import mypower.example.com.yingyuenetwork.network.model.YingyueException;
import mypower.example.com.yingyuenetwork.network.model.request_network;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class Interaction {


    private static Interaction instance;
    public static String POST = "POST";
    public static String GET = "GET";
    public static String Ruquest_way = "POST";
    public static LClient okhttp;
    private String hb_url;

    private Interaction() {
    }

    public void init(LClient okhttp, String hb_url) {
        this.okhttp = okhttp;
        this.hb_url = hb_url;
    }

    public static Interaction getInstance() {
        if (instance == null) {
            instance = new Interaction();
        }
        return instance;
    }


    //获取最近一次高血压随访记录
    public void recently_mmHg_HHz(YingyueCallback<Object> callback, Object entiy) {
        if (entiy == null) {
            entiy = "";
        }
        MerchantService server = okhttp.getService(MerchantService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), JSON.toJSONString(entiy));
        Call<Object> call = null;
        if (Ruquest_way.equals("POST")) {
            call = server.createPOST(body, hb_url);
        }
        if (Ruquest_way.equals("GET")) {
            call = server.createGET(hb_url);
        }
        if (YingyueException.isNULL(call)) {
            throw new NullPointerException();
        }
        call.enqueue(callback);
    }

    public String getRuquest_way() {
        return Ruquest_way;
    }

    public void setRuquest_way(String ruquest_way) {
        Ruquest_way = ruquest_way;
    }
}
