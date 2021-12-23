package com.jaikeerthick.genderchecker.api

import com.jaikeerthick.genderchecker.ui.model.GenderResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIHub {

    @GET(".")
    suspend fun getGender(@Query("name") name : String) : GenderResponse

}