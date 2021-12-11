package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.example.project2.database.ImageEntity
import com.example.project2.viewmodels.DogImageApplication
import com.example.project2.viewmodels.DogViewModel
import com.example.project2.viewmodels.DogViewModelFactory
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private val viewModel: DogViewModel by viewModels {
        DogViewModelFactory((application as DogImageApplication).database.dogDao())
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

         // Add randomDog button and previousDog button
          val randomDog: TextView = findViewById(R.id.textView2)
            val previousDog :TextView = findViewById(R.id.textView)

            //Displays picture of a dog from API in imageView
            viewModel.dogPhoto.observe(this, {
                val mainImage : ImageView = findViewById(R.id.imageView)
                Picasso.with(this).load(it.message).into(mainImage)
            })

// textView2 should display the next random dog image
            randomDog.setOnClickListener {
                val currentImgUrl = viewModel.dogPhoto.value?.message
                viewModel.insertNewImage()

                val newDogImage = currentImgUrl?.let { it1 -> ImageEntity(imageUrl = it1) }
                if (newDogImage != null) {
                    viewModel.addDog(newDogImage)
                }
            }
            //textView opens the MainActivity2 class
            previousDog.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)


            }
        }
        }

