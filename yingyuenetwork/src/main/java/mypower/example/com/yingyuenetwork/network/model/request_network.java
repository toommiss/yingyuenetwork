package mypower.example.com.yingyuenetwork.network.model;

import com.alibaba.fastjson.JSON;

import mypower.example.com.yingyuenetwork.network.controller.Interaction;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class request_network {
    public static String url = "";
    public static LClient okhttp;
    public static String hb_url;
    private static request_network instance;

    public static request_network getInstance() {
        if (instance == null) {
            instance = new request_network();
        }
        return instance;
    }

    /**
     * @hide
     */
    private request_network() {

    }
//    String urcsl = "http://182.151.200.122:23653/chis/";

    /**
     * @param url_path           访问的路径
     * @param url_parameter_json 字符串携带的url 参数
     */
    public Interaction create_network(String url_path, String url_parameter_json) {
        if (YingyueException.isNULL(url_path)) {
            throw new NullPointerException();
        }
        if (YingyueException.isNULL(url_parameter_json)) {
            throw new NullPointerException();
        }
        url = url_path;
        hb_url = url + url_parameter_json;
        okhttp = new LClient(url);
        okhttp.setTimeout(25);
        return create_request_obj();
    }

    /**
     * 创建请求实体
     */
    public Interaction create_request_obj() {
        if (YingyueException.isNULL(okhttp)) {
            throw new NullPointerException();
        }
        Interaction obj = Interaction.getInstance();
        obj.init(okhttp, hb_url);
        return obj;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
