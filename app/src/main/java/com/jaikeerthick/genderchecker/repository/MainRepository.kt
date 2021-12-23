package com.jaikeerthick.genderchecker.repository

import android.util.Log
import com.jaikeerthick.genderchecker.api.APIHub
import com.jaikeerthick.genderchecker.ui.model.GenderResponse
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHub: APIHub) {

    suspend fun getGender(username: String): GenderResponse{

        val response = try{
            apiHub.getGender(username)
        }catch(e: Exception){
            Log.d("GENDER-API", "Error: ${e.message}")
            return GenderResponse(null, null, null)
        }
        return response

    }

}