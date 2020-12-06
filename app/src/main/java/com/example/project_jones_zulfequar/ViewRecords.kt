package com.example.project_jones_zulfequar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view_records.*
import kotlinx.android.synthetic.main.row.*

class ViewRecords : AppCompatActivity() {
    var db : MyDatabase? = null
    var theId = ""
    var theComment = ""
    var theScore = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_records)
        db = MyDatabase.getDatabase(this)




          /*  theId = this.intent.getStringExtra("Id").toString()
            theComment = this.intent.getStringExtra("Comment").toString()
            theScore = this.intent.getStringExtra("Score").toString()
            textView4.text = this.intent.getStringExtra("Id").toString()*/


            var layoutManager = LinearLayoutManager(this)
            var data = getData()
            var adapter = MyAdapter(data, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter

    }
    fun getData(): ArrayList<User>{
        var list = ArrayList<User>(0)
        var users = db?.userDao()?.getAll()
        var user = User(users?.get(0).toString(), users?.get(1).toString(), users?.get(2).toString())
        list.add(user)
        return list
    }
}