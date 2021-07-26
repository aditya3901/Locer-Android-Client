package org.locer.`in`.utils

import com.google.gson.annotations.SerializedName

data class PopularFood(
    @SerializedName("__v")
    val version: Int,
    @SerializedName("_id")
    val id: String,
    val countInStock: Int,
    val createdAt: String,
    val description: String,
    val filename: String,
    val numReviews: Int,
    val price: Double,
    val rating: Double,
    val reviews: List<Any>,
    val store: String,
    val title: String,
    val type: String,
    val updatedAt: String
)