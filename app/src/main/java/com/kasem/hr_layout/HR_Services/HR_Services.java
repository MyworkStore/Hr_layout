package com.kasem.hr_layout.HR_Services;

import com.kasem.hr_layout.HR_Services.HRDAO.HRDAO;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Kasemsuk Laiwtakul on 9/5/2560.
 */

public interface HR_Services {

    @POST("application/views/hr/moblie_service/v_skill.php")
    Call<HRDAO> getData();

}
