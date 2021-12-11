package com.example.project2.viewmodels

import androidx.lifecycle.*
import com.example.project2.database.ImageDao
import com.example.project2.database.ImageEntity
import com.example.project2.database.DogPhoto
import com.example.project2.network.DogAPI
import kotlinx.coroutines.launch

class DogViewModel(private val imageDao: ImageDao) : ViewModel() {

    // added 12/7: LiveData list, init
    private val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto : LiveData<DogPhoto> = _dogPhoto

    init {
        insertNewImage()
    }
    fun insertNewImage() {
        viewModelScope.launch {
           _dogPhoto.value = DogAPI.retrofitService.getDogPhotos()

        }
        }

     // 12/7 added a function
    fun addDog(imageEntity: ImageEntity){
        viewModelScope.launch{
            imageDao.insertImage(imageEntity)
        }
    }
            fun getAllImagesList(): LiveData<List<ImageEntity>> {
                return imageDao.getAllImages().asLiveData()
            }
        }

// 12/7 made dogImageDao private
    class DogViewModelFactory(private val dogImageDao: ImageDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DogViewModel(dogImageDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }

