package com.blusmart.assignment.api;

import com.blusmart.assignment.duty.model.ModelForDutyDetail;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {

    @GET("dutyid/list")
    Observable<Object> getDutyList(@Header("Cache-Control") String contentRange, @Header("checksum") String checksum);

    @GET("duty/{id}")
    Observable<ModelForDutyDetail> getDutyDetail(@Path("id") String id , @Header("Cache-Control") String contentRange, @Header("checksum") String checksum);

    @PUT("update/duty/{id}")
    Observable<ModelForDutyDetail> updateDuty(@Path("id") String id, @Header("Cache-Control") String contentRange,
                                              @Header("checksum") String checksum,
                                              @Body Map<String, String> paramObject);
}
