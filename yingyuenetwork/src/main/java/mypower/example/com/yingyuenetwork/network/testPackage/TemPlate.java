package mypower.example.com.yingyuenetwork.network.testPackage;

import mypower.example.com.yingyuenetwork.network.Interface.ResponseCallback;
import mypower.example.com.yingyuenetwork.network.controller.Interaction;
import mypower.example.com.yingyuenetwork.network.model.YingyueCallback;
import mypower.example.com.yingyuenetwork.network.model.request_network;
import mypower.example.com.yingyuenetwork.network.testPackage.myObj;
import retrofit2.Call;
import retrofit2.Response;

public class TemPlate {
    Interaction ction;
    String qus = "GET";

    public void Test() {
        String urcsl = "http://192.168.0.116:8080/store/";
        String url_parameter_json = "";
        //get
        if (qus.equals("GET")) {
            url_parameter_json = "classschedule/getDetailsByGrade/32b80bb67f01d503db9afa69e2ab7f62";
        }
        if (qus.equals("POST")) {
            url_parameter_json = "teachcourse/queryCourses";
        }
        myObj entiy = new myObj();
        entiy.setPageSize("1");
        entiy.setPageNumber("1");
        entiy.setCourseType("0770f61be7179c3b1f3c173ddb9fc695");
        ction = request_network.getInstance().create_network(urcsl, url_parameter_json);
        ction.setRuquest_way(qus);
        ction.recently_mmHg_HHz(new YingyueCallback<Object>(new ResponseCallback() {
            @Override
            public void onResponse(Call call, Response response, String request_data) {
                String url_parameter_json = "teachcourse/queryCourses";
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                String url_parameter_json = "teachcourse/queryCourses";

            }
        }), entiy);
    }


}
