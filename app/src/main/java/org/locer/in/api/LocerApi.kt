package org.locer.`in`.api

import org.locer.`in`.utils.PopularFood
import retrofit2.http.GET

interface LocerApi {

    companion object {
        const val BASE_URL = "http://locerappdemo.herokuapp.com/api/"
    }

    @GET("products")
    suspend fun getProducts(): List<PopularFood>

}