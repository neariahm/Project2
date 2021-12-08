package com.example.project2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



/* Purpose of this class:  tell Room what to do with all of these classes (models, DAO, viewmodel)
    - Specify which entities are defined in the database.
    - Provide access to a single instance of each DAO class.
    - Perform any additional setup, such as pre-populating the database.
    The AppDatabase class gives you complete control over your models, DAO classes,
    and any database setup you wish to perform.
 */

@Database(entities = [ImageEntity::class], version = 1) // this line from Ayana
abstract class ImageDatabase : RoomDatabase() {

    //The AppDatabase class allows other classes easy access to the DAO classes
    abstract fun dogDao(): ImageDao

    /* Store the instance in the companion object to to ensure that only one instance of the
        database exists to prevent race conditions or other potential issues */
    companion object {
        @Volatile
        private var INSTANCE: ImageDatabase? = null

      fun getDatabase(context: Context): ImageDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ImageDatabase::class.java,
                    "image_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance

                 instance
            }

        }
    }
}