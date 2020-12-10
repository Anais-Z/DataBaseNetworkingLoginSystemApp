package com.example.project_jones_zulfequar

import android.accessibilityservice.GestureDescription
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {
    val myPrefs = "PrefsFile"
    lateinit  var vm : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this,  ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MyViewModel :: class.java)
        var name = ""
        loginButton.setOnClickListener {
            var url = "http://mohameom.dev.fast.sheridanc.on.ca/login/verify.php?name=user&password=12345"
            var url2 = "http://mohameom.dev.fast.sheridanc.on.ca/login/verify.php"
            if(userNameText.text.isNotBlank() || passwordText.text.isNotBlank()) {
                var username = userNameText.text.toString();
                var password = passwordText.text.toString();

                if(username == "" || password == ""){
                    Toast.makeText(this, "Please fill in every field", Toast.LENGTH_SHORT).show()
                    userNameText.text.clear()
                    passwordText.text.clear()
                } else if (username == "admin" && password == "admin" || username == "user" && password == "12345"){
                    if(username == "admin"){
                        name = "Admin"
                    }else{ name = "User"}

                        getData(url)
                    val i = Intent(this, MainActivity2::class.java)

                    if (loggedIn.isChecked){
                        saveLogin()
                    }
                    intent.putExtra("Username", name)
                    startActivity(i)
                    userNameText.text.clear()
                    passwordText.text.clear()

                }else{
                    getData(url2)
                    userNameText.text.clear()
                    passwordText.text.clear()
                }

            }else{
                Toast.makeText(this, "Please fill in every field", Toast.LENGTH_SHORT).show()
            }

        }


    }
    fun getData(url : String) {
            vm.makeRequest(url)
    }

    fun saveLogin(){
        var username = userNameText.text.toString()
        var password = passwordText.text.toString()

        if(username.isNotBlank() && password.isNotBlank()){
            val sharedPrefs = getSharedPreferences(myPrefs, Context.MODE_PRIVATE)

            val editor = sharedPrefs.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.commit()
        }
    }

    fun getLogin(){
        val sharedPrefs = getSharedPreferences(myPrefs, MODE_PRIVATE)
        var username = sharedPrefs.getString("username", " ")

        Toast.makeText(this, "Saved username as: $username", Toast.LENGTH_LONG).show()
        nameText.text = username
    }




}