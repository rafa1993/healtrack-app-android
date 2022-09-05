package com.example.healthtrack_imc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var toastNotification = MutableLiveData<String>()
    private val repository = Repository()

    init {
        textWelcome.value = "Bom dia!"
    }

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<String> {
        return toastNotification
    }

    fun doLogin(email: String) {
        if (this.repository.login(email))
            toastNotification.setValue("Success")
        else
            toastNotification.setValue("Falha")
    }
}