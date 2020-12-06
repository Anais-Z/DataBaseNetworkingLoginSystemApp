package com.example.project_jones_zulfequar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view_records.*
import kotlinx.android.synthetic.main.row.*

class ViewRecords : AppCompatActivity() {

    var theId = ""
    var theComment = ""
    var theScore = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_records)
        if(false) {

            theId = this.intent.getStringExtra("Id").toString()
            theComment = this.intent.getStringExtra("Comment").toString()
            theScore = this.intent.getStringExtra("Score").toString()
            textView4.text = this.intent.getStringExtra("Id").toString()


            var layoutManager = LinearLayoutManager(this)
            var data = getData(theId, theScore, theComment)
            var adapter = MyAdapter(data, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }
    fun getData(id: String, score: String, comment: String): ArrayList<User>{
        var list = ArrayList<User>(0)
        var user = User(id, score, comment)
        list.add(user)
        return list
    }
}