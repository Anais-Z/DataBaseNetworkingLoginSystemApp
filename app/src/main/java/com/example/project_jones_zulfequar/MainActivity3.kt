package com.example.project_jones_zulfequar

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*


class MainActivity3 : AppCompatActivity() {

    var sameId : String? = ""
    var sameScore : String? = ""
    var sameComment : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        sameId = intent.getStringExtra("id").toString()
        sameScore = intent.getStringExtra("score").toString()
        sameComment = intent.getStringExtra("comment").toString()
        //Change tvDisplayID to show the id that was clicked on in ViewRecords

        btnUpdate.setOnClickListener{
            //obtain the two inputs that the user typed in the two textboxes
            var newScore = newScoreText.text.toString()
            var newComment = addComment.text.toString()

            if (newScore == "" || newComment == "") {
                Toast.makeText(this, "Please fill in every field", Toast.LENGTH_SHORT).show()
            }else{
                val record = Records(sameId.toString(), newScore, newComment)

                Thread{
                    var db = MyDatabase.getDatabase(this)
                    if (db != null){
                        db.recordsDao().updateRecord(record)

                        runOnUiThread {
                            newScoreText.text.clear()
                            addComment.text.clear()
                            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show()

                        }
                    }
                }.start()
            }
            }
        btnCancel.setOnClickListener{
            //go back to viewRecords
            val i = Intent(this, ViewRecords::class.java)
            startActivity(i)

        }

        deleteButton.setOnClickListener {
            val record = Records(sameId.toString(), sameScore.toString(), sameComment.toString())
            Thread{
                var db = MyDatabase.getDatabase(this)
                if (db != null){
                    db.recordsDao().deleteRecord(record)
                    runOnUiThread {
                        Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show()

                    }
                }
            }.start()

        }
        }


    }
