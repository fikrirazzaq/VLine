package com.example.telc2.vline.api;

import com.example.telc2.vline.model.responsemodel.BankMarkerResponseModel;
import com.example.telc2.vline.model.responsemodel.BankResponseModel;
import com.example.telc2.vline.model.responsemodel.InfoBankResponseModel;
import com.example.telc2.vline.model.responsemodel.StatusBankResponseModel;
import com.example.telc2.vline.model.responsemodel.UserLoginResponseModel;
import com.example.telc2.vline.model.responsemodel.UserRegisResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by juvetic on 9/23/17.
 */

public interface ApiRequest {

    @FormUrlEncoded
    @POST("bni/mobileapi/register.php")
    Call<UserRegisResponseModel> regisUser(@Field("nama_user") String nama_user,
                                             @Field("username_user") String username_user,
                                             @Field("password_user") String password_user,
                                             @Field("notelp_user") String notelp_user);

    @FormUrlEncoded
    @POST("bni/mobileapi/login.php")
    Call<UserLoginResponseModel> loginUser(@Field("username_user") String username_user,
                                           @Field("password_user") String password_user);


    @GET("bni/mobileapi/bank.php")
    Call<StatusBankResponseModel> getBank();

    @GET("bni/mobileapi/statusbank.php")
    Call<StatusBankResponseModel> getStatusBank();

    @GET("bni/mobileapi/infobank.php")
    Call<InfoBankResponseModel> getInfoBank();
}
