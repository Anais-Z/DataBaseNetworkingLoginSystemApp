package com.example.project_jones_zulfequar

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
     var score : SeekBar? = null
    var id = ""
    var comment = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        sbScore.progress++
        sbScore.max = 10
        sbScore.min = 0



        sbScore?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                score = p0
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(applicationContext, "Drag and pick a value", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(applicationContext, "Selected: ${p0?.progress}", Toast.LENGTH_SHORT).show()
            }
        })

        btnSaveRecord.setOnClickListener {
            if (etStudentID.text.isNotBlank() || etComments.text.isNotBlank()){
                 id = etStudentID.text.toString();
                 comment = etComments.text.toString();
                if (id == "" || comment == ""){
                    Toast.makeText(this, "Fill in every field please!!!", Toast.LENGTH_SHORT).show()
                    etStudentID.text.clear()
                    etComments.text.clear()
                }

                var intent = Intent(this, ViewRecords::class.java)

                intent.putExtra("Id", id)
                intent.putExtra("Score", score.toString())
                intent.putExtra("Comment", comment)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show()

            }
        }

        btnBack.setOnClickListener {
            var i = Intent(this, MainActivity2::class.java)

            startActivity(i)
        }




    }

}








