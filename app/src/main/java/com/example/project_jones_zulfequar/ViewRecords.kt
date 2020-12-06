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
    var count = 0
    var theNum = ""
    var actualNum=  0
    var theCount = ""
    var actualC = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_records)
        db = MyDatabase.getDatabase(this)




          /*  theId = this.intent.getStringExtra("Id").toString()
            theComment = this.intent.getStringExtra("Comment").toString()
            theScore = this.intent.getStringExtra("Score").toString()
            textView4.text = this.intent.getStringExtra("Id").toString()*/


            var layoutManager = LinearLayoutManager(this)
            var data = getData(actualNum, actualC)
            var adapter = MyAdapter(data, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter

    }
    fun getData(num : Int, count : Int): ArrayList<User>{

        var list = ArrayList<User>(0)
        var users = db?.userDao()?.getAll()



        var user4 = User(users?.get(5).toString(), users?.get(2).toString(), users?.get(2).toString())
        list.add(user4)
        var user5 = User(users?.get(6).toString(), users?.get(2).toString(), users?.get(2).toString())
        list.add(user5)
       // var user6 = User(users?.get(7).toString(), users?.get(2).toString(), users?.get(2).toString())
       // list.add(user6)
        var user7 = User(users?.get(9).toString(), users?.get(2).toString(), users?.get(2).toString())
        list.add(user7)

      //  while (num == count){
      //     var  theUser = User(users?.get(num).toString(), users?.get(2).toString(), users?.get(2).toString())
       //     list.add(theUser)

     //   }


        return list
    }
}