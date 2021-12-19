package com.example.DoggoApp.network

import com.squareup.moshi.Json

data class DogImage( @Json(name = "message") val imgSrcUrl: String)