package com.example.basicnavigation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicnavigation.database.DatabaseManager
import com.example.basicnavigation.database.User
import com.example.basicnavigation.database.myAppDataSource
import kotlinx.coroutines.launch

class DestinationViewModel : ViewModel() {
    val savedUser= MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUser.value = myAppDataSource(userDao).getUsers().value

        }
    }
}