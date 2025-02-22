package com.example.finalproject001.viewmodel

import androidx.lifecycle.ViewModel
import com.example.finalproject001.model.UserModel
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

    fun signup(firstName : String, lastName : String, email : String, phone : String, username : String, password : String, onResult: (Boolean,String?)-> Unit){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    var userId = it.result?.user?.uid

                    val userModel = UserModel(firstName,lastName,email,phone,username,password,userId!!)
                    firestore.collection("users").document()
                        .set(userModel)
                        .addOnCompleteListener{ dbTask->
                            if(dbTask.isSuccessful){
                                onResult(true,null)
                            }else{
                                onResult(false,"Something went wrong")
                            }

                        }

                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }
    }
}