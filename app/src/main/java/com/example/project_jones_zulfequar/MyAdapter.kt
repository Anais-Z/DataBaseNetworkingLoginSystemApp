package com.example.project_jones_zulfequar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.rows.view.*

class MyAdapter(val data: ArrayList<User>, val content: Context) : RecyclerView.Adapter<MyAdapter.MyViewFolder>() {
    var items = ArrayList<User>()

    fun setListData(data: ArrayList<User>){
        this.items = data

    }
    class MyViewFolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewFolder {
        return MyViewFolder(LayoutInflater.from(content).inflate(R.layout.rows, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewFolder, position: Int) {
   //     holder.itemView.studentId3.text = data[position].id
        holder.itemView.textView4.text = data[position].id

      //  holder.itemView.studentScore3.text = data[position].score
     //   holder.itemView.studentComment3.text = data[position].comment

    }
}