package mypower.example.com.yingyuenetwork.network.model;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface MerchantService {

    @POST
//    @POST("chis/*.jsonRequest?uid={uid}&manageUnitId={manageUnitId}")
    Call<Object> createPOST(@Body RequestBody request, @Url String url);

    @GET
    Call<Object> createGET(@Url String url);
}
