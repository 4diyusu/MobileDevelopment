package com.example.finalproject001.viewmodel

import androidx.lifecycle.ViewModel
import com.example.finalproject001.model.UserModel
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AuthViewModel : ViewModel(){

    private val auth = Firebase.auth

    private val firestore = Firebase.firestore

    fun login(username: String, password: String, onResult : (Boolean,String?)-> Unit){
        auth.signInWithEmailAndPassword(username,password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onResult(true,null)
                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }

    }

    fun signup(
        firstName: String, lastName: String, email: String, phone: String, username: String, password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val userId = it.result?.user?.uid ?: return@addOnCompleteListener
                    val userModel = UserModel(firstName, lastName, email, phone, username, userId, userId)

                    // 🔥 Save user using UID as document ID
                    firestore.collection("users").document(userId)
                        .set(userModel)
                        .addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                onResult(true, null)
                            } else {
                                onResult(false, "Failed to save user in Firestore")
                            }
                        }
                } else {
                    onResult(false, it.exception?.localizedMessage)
                }
            }
    }


    fun updateAccount(
        firstName: String? = null,
        lastName: String? = null,
        phone: String? = null,
        username: String? = null,
        onResult: (Boolean, String?) -> Unit
    ) {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            onResult(false, "User is not authenticated")
            return
        }

        val userId = currentUser.uid  // ✅ Get correct UID
        val userRef = firestore.collection("users").document(userId)

        val updateMap = mutableMapOf<String, Any>()
        firstName?.let { updateMap["firstName"] = it }
        lastName?.let { updateMap["lastName"] = it }
        phone?.let { updateMap["phone"] = it }
        username?.let { updateMap["username"] = it }

        if (updateMap.isEmpty()) {
            onResult(false, "No changes provided")
            return
        }

        userRef.get().addOnSuccessListener { document ->
            if (document.exists()) {
                userRef.update(updateMap)
                    .addOnSuccessListener { onResult(true, "Account updated successfully") }
                    .addOnFailureListener { e -> onResult(false, "Update failed: ${e.localizedMessage}") }
            } else {
                onResult(false, "User document does not exist")
            }
        }.addOnFailureListener { e ->
            onResult(false, "Failed to check document: ${e.localizedMessage}")
        }
    }

    fun changePassword(currentPassword: String, newPassword: String, onResult: (Boolean, String?) -> Unit) {
        val user = auth.currentUser

        if (user == null) {
            onResult(false, "User not logged in")
            return
        }

        val email = user.email
        if (email.isNullOrEmpty()) {
            onResult(false, "Email not found for user")
            return
        }

        // Reauthenticate user before changing password
        val credential = EmailAuthProvider.getCredential(email, currentPassword)
        user.reauthenticate(credential)
            .addOnSuccessListener {
                // If reauthentication is successful, update the password
                user.updatePassword(newPassword)
                    .addOnSuccessListener {
                        onResult(true, null) // Password changed successfully
                    }
                    .addOnFailureListener { exception ->
                        onResult(false, exception.localizedMessage)
                    }
            }
            .addOnFailureListener { exception ->
                onResult(false, "Reauthentication failed: ${exception.localizedMessage}")
            }
    }

    fun forgotPassword(email: String, username: String, onResult: (Boolean, String?) -> Unit) {
        // Reference Firestore "users" collection
        firestore.collection("users")
            .whereEqualTo("email", email)
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    // Email exists, send reset email
                    auth.sendPasswordResetEmail(email)
                        .addOnSuccessListener {
                            onResult(true, "Password reset email sent. Check your inbox.")
                        }
                        .addOnFailureListener { exception ->
                            onResult(false, exception.localizedMessage)
                        }
                } else {
                    onResult(false, "No matching account found.")
                }
            }
            .addOnFailureListener { exception ->
                onResult(false, exception.localizedMessage)
            }
    }
}