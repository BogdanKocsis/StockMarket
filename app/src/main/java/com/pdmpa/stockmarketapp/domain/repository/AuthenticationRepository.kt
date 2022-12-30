package com.pdmpa.stockmarketapp.domain.repository

import android.content.ContentValues
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class AuthenticationRepository @Inject constructor(
    private val auth: FirebaseAuth
) {

    fun getUserCurrentStatus() = flowOf(auth.currentUser != null)

    fun logInWithEmail(
        email: String,
        password: String
    ): Flow<AuthStatus> {
        return callbackFlow {
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    trySend(AuthStatus.Success)
                }
                .addOnFailureListener {
                    trySend(AuthStatus.Failure(it.message.toString()))
                }
            awaitClose()
        }
    }

    fun signUpWithEmail(email: String, password: String): Flow<AuthStatus> {
        return callbackFlow {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    trySend(AuthStatus.Success)
                }
                .addOnFailureListener {
                    trySend(AuthStatus.Failure(it.message.toString()))
                }
            awaitClose()
        }
    }

    fun logOut(): Boolean {
        return try {
            auth.signOut()
            true
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "log out from Firebase: log out failed: ${e.message}", e)
            false
        }
    }
}

sealed class AuthStatus {
    object Success : AuthStatus()
    data class Failure(val message: String?) : AuthStatus()
}