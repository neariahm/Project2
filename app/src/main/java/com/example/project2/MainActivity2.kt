package com.example.project2

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.viewmodels.DogImageApplication
import com.example.project2.viewmodels.DogViewModel
import com.example.project2.viewmodels.DogViewModelFactory
import com.squareup.picasso.Picasso

//   In the second activity the previous dog image will show and the button on this screen will
//   allow the user to return to the main/home screen.
class MainActivity2 : AppCompatActivity() {
    private val viewModel: DogViewModel by viewModels{
       DogViewModelFactory((application as DogImageApplication).database.dogDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       viewModel.getAllImagesList().observe(this){
    val count = it.size
            val imageView = findViewById<ImageView>(R.id.imageView8)
           //imageUrl is from ImageEntity, look at Amani's code for the it.get(0)
            Picasso.with(this).load(it[count-1].imageUrl).into(imageView)
            val button: ImageView = findViewById(R.id.imageView10)
            button.setOnClickListener {
                finish()
            }
        }
    }
}



