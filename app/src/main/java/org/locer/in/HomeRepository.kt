package org.locer.`in`

import org.locer.`in`.api.LocerApi
import javax.inject.Inject

class HomeRepository @Inject constructor(private val locerApi: LocerApi) {

    suspend fun getProducts() = locerApi.getProducts()

}