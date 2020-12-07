package com.example.project_jones_zulfequar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //Change tvDisplayID to show the id that was clicked on in ViewRecords

        var newScore = etScore.text.toString()
        var newComment = etComments.text.toString()

        btnUpdate.setOnClickListener{
            //obtain the two inputs that the user typed in the two textboxes
            if (newScore == "" || newComment == ""){
                Toast.makeText(this, "Please fill in every field", Toast.LENGTH_SHORT).show()
            }
            else{
                //change them in the database

            }



        }

        btnCancel.setOnClickListener{
            //go back to viewRecords
            val i = Intent(this, ViewRecords::class.java)
            startActivity(i)

        }
    }
}