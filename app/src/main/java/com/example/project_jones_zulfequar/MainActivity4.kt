package com.example.project_jones_zulfequar

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project_jones_zulfequar.MyDatabase.Companion.getDatabase

import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    lateinit var viewModel: MyViewModel
     lateinit var score : SeekBar
    var score1 = 0
    var id = ""
    var comment = ""
    var theNum = 8
    var count = 8
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var vm = MyDatabase.getDatabase(this)
        setContentView(R.layout.activity_main4)

        sbScore.progress++
        sbScore.max = 10
        sbScore.min = 0



        sbScore?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p0 != null) {
                    score = p0
                }
              score1 =  score.progress
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
                }else{
                    theNum++
                    count++
                    intent.putExtra("number", theNum)
                    intent.putExtra("count", count)
                    val user = User(id, score1.toString(), comment)

                    Thread{
                        var db = MyDatabase.getDatabase(this)
                        if (db != null){
                            db.userDao().insertAll(user)

                            runOnUiThread {
                                etStudentID.text.clear()
                                etComments.text.clear()
                            }
                        }
                    }.start()
                }

                var intent = Intent(this, ViewRecords::class.java)

                startActivity(intent)

            }else{
                Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show()

            }
        }

        fun onDelereClickListener(user: User){

        }


        btnBack.setOnClickListener {
            var i = Intent(this, MainActivity2::class.java)

            startActivity(i)
        }




    }

}








