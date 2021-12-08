package com.example.project2.network

import com.example.project2.database.DogPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


    // Starts the request
    private const val BASE_URL = "https://dog.ceo/api/"

    // Helps w something
    private val networkLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Creates a Moshi object
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Creates Retrofit object
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


    /* Define an interface that will describe how
    Retrofit talks to the web server using HTTP requests */

    interface DogApiService {
        // Specify type of HTTP request and the endpoint for the web service
        @GET(" breeds/image/random")
        // Add a function to get the response string from the web service
        suspend fun getDogPhotos() : DogPhoto
    }
    /*  - Declare a singleton to ensure that only one instance of an object is created.
      - This tells Retrofit to create connection to DogAPI + what we call from the ViewModel
      - "by lazy" means don't do this until ready to use it so it won't mess with app performance */

// 12/7 i had double of these:
object DogAPI {
        val retrofitService: DogApiService by lazy {
            retrofit.create(DogApiService::class.java)
        }


    }


