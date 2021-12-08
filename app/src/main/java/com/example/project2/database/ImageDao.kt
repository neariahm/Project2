package com.example.project2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
// this one doesnt work for some reason: import java.util.concurrent.Flow
import kotlinx.coroutines.flow.Flow



// This class is used to define out SQL queries and relate them to our application.
//In later steps, we will use these queries in our DogViewModel class.


    @Dao
    interface ImageDao {


//Add a query to insert a new image into the database that accepts an ImageEntity as an argument
// I do not understand where dogImageEntity comes from
        @Insert
        suspend fun insertImage(dogImageEntity: ImageEntity)


       /* @Query("DELETE from images where id=(select max(id)-1 from images)")
        suspend fun deleteImage() */


        // a query that will select all images from the database and return them in a list.
        //  a Kotlin feature called asynchronous flow (often just called flow) that will allow the
        //  DAO to continuously emit data from the database.
        @Query("SELECT * FROM images")
        fun getAllImages(): kotlinx.coroutines.flow.Flow<List<ImageEntity>>

        //Finally, we will create a query that will receive the last image in the database.
        //12/7: put imageEntity in the parentheses
    @Query("SELECT * FROM images ORDER BY id DESC LIMIT 1")
 suspend   fun getNewImage(imageEntity: ImageEntity)
}