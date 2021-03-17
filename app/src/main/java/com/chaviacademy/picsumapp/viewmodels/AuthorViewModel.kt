package com.chaviacademy.picsumapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chaviacademy.picsumapp.model.AuthorDetails
import com.chaviacademy.picsumapp.network.RetrofitNetworking
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorViewModel : ViewModel() {

    val liveDataAuthorList = MutableLiveData<ArrayList<AuthorDetails>>()

    fun callPicsumApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitNetworking.create().getPhotosList()

            withContext(Dispatchers.Main) {
                when {
                    response.isSuccessful && response.body() != null -> {
                        Log.i("log", "Response: ${Gson().toJson(response.body())}")
                        liveDataAuthorList.postValue(response.body())
                    }
                    else ->{
                        Log.e("log", "Response Error")
                    }
                }
            }

        }
    }


}