package com.example.project2.viewmodels

import android.app.Application
import com.example.project2.database.ImageDatabase

/* Instantiate a reference to the ImageDatabase class using the lazy delegate and calling the
 getDatabase() function. */
class DogImageApplication : Application() {
    val database: ImageDatabase by lazy { ImageDatabase.getDatabase(this) }
}