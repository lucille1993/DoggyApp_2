package com.example.DoggoApp.viewmodels


import androidx.lifecycle.*
import com.example.DoggoApp.database.DogDao
import com.example.DoggoApp.database.DogEntity
import com.example.DoggoApp.network.DogImage
import com.example.DoggoApp.network.DogImageApi
import kotlinx.coroutines.launch

class MainViewModel(private val dogDao: DogDao) : ViewModel() {

    private val _currentlyDisplayedImage = MutableLiveData<DogImage>()
    val currentlyDisplayedImage: LiveData<DogImage> = _currentlyDisplayedImage

    init {
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            // are getting the first item in the list from the response.
            _currentlyDisplayedImage.value = DogImageApi.retrofitService.getRandomDogImage()
        }
    }

    fun addDog(dogEntity: DogEntity)
    {
        viewModelScope.launch {
            dogDao.addDogImage(dogEntity)
        }
    }

     fun deleteMostRecentDog(){
         viewModelScope.launch {
             dogDao.deleteDog()
         }
    }

    fun getAllDogs(): LiveData<List<DogEntity>>
    {
        return dogDao.getAllDogImages().asLiveData()
    }
}

class MainViewModelFactory(
    private val dogDao: DogDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(dogDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}
