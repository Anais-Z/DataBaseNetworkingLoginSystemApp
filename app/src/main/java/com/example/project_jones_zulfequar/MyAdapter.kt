package com.example.project_jones_zulfequar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val data: ArrayList<User>, val content: Context) : RecyclerView.Adapter<MyAdapter.MyViewFolder>() {

    class MyViewFolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewFolder {
        return MyViewFolder(LayoutInflater.from(content).inflate(R.layout.row, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewFolder, position: Int) {
        holder.itemView.studentId.text = data[position].id
        holder.itemView.studentScore.text = data[position].score
        holder.itemView.studentComment.text = data[position].comment
    }
}