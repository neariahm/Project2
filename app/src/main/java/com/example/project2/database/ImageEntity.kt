package com.example.project2.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Data entities represent tables in your app's database
@Entity(tableName = "images")
data class ImageEntity (
    // autoGenerate = true means increment the number automatically for the key, starting at 0
    @PrimaryKey(autoGenerate = true)
    // Always need a column for an unique Id, doesn't always have to be a number though
    @NonNull @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "image") val imageUrl: String,
)

