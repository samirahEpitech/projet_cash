package com.example.cashmanagersam.shoppingcart

import com.google.gson.annotations.SerializedName

data class picture(
    @SerializedName("filename")
    var filename: String? = null
)