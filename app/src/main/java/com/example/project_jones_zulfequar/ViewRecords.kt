package com.example.project_jones_zulfequar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_view_records.*


class ViewRecords : AppCompatActivity() {
    var db : MyDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_records)
        db = MyDatabase.getDatabase(this)

           var layoutManager = LinearLayoutManager(this)
            var theData = getData()
          var adapter = MyAdapter(theData, this)
           recyclerView.layoutManager = layoutManager
          recyclerView.adapter = adapter

        button3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
    fun getData(): ArrayList<Records>{
        var list = ArrayList<Records>(0)
        var records = db?.recordsDao()?.getAll()
        if(records != null){
            for( i in records){
                list.add(i)
            }
        }
        return list


    }

}