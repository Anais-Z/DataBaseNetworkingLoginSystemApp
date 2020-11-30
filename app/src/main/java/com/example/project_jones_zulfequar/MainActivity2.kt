package com.example.project_jones_zulfequar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var theName = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        theName = intent.getStringExtra("Username" ).toString()
        if (nameText.text == null) {
            nameText.text = theName
        }
        submitButton.setOnClickListener {
             if (newRecordButton.isChecked){
                val i = Intent(this, MainActivity4::class.java)
                startActivity(i)
            }else if (previousRecordButton.isChecked){
                val i2 = Intent(this, ViewRecords::class.java)
                startActivity(i2)
            }else if (logOutButton.isChecked){
                System.exit(0);
                 Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}