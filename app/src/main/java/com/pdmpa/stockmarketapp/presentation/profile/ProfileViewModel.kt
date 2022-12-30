package com.pdmpa.stockmarketapp.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmpa.stockmarketapp.domain.repository.AuthenticationRepository
import com.pdmpa.stockmarketapp.navigation.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: AuthenticationRepository) :
    ViewModel() {
    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.SignOutClickAction -> {
                viewModelScope.launch {
                    repository.logOut()
                    event.navController.navigate(Login.route)
                }
            }
        }
    }
}