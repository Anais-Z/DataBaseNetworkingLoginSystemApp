package com.example.project_jones_zulfequar

import android.accessibilityservice.GestureDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
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
                    intent.putExtra("Username", name)
                    startActivity(i)
                    userNameText.text.clear()
                    passwordText.text.clear()
                    if (loggedIn.isChecked){

                    }
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
}