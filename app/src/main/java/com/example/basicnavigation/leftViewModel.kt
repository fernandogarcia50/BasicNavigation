package com.example.basicnavigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicnavigation.database.DatabaseManager
import com.example.basicnavigation.database.User
import com.example.basicnavigation.database.myAppDataSource
import kotlinx.coroutines.launch

class leftViewMode: ViewModel() {
    fun save(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            myAppDataSource(userDao).save(user)
        }
    }
}