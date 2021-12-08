package com.example.project2.database

import com.squareup.moshi.Json
// Declare a data class to say all of the things that we are expecting back in our JSON objects
data class DogPhoto(
    @Json(name = "message") val message: String?,
    @Json(name = "status") val status: String?
)
