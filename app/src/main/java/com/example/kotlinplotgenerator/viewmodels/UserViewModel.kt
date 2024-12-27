package com.example.kotlinplotgenerator.viewmodels


import com.example.kotlinplotgenerator.database.AppDatabase;
import com.example.kotlinplotgenerator.models.User;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val db:AppDatabase) : ViewModel() {

    fun insertUser(user:User) {
        viewModelScope.launch {
            db.userDao().insertUser(user)
        }
    }


    fun getAllUsers(onResult: (List<User>) -> Unit) {
        viewModelScope.launch {
            val users = db.userDao().getAllUsers()
            onResult(users)
        }
    }
}