package com.example.project_jones_zulfequar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rows.view.*

class MyAdapter(val data: ArrayList<Records>, val content: Context) : RecyclerView.Adapter<MyAdapter.MyViewFolder>() {
   // var items = ArrayList<User>()

  //  fun setListData(data: ArrayList<User>){
   //     this.items = data

  //  }
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
        holder.itemView.idText.text = data[position].id
        holder.itemView.scoreText.text = data[position].score
        holder.itemView.commentText.text = data[position].comment
        val id =  holder.itemView.idText.text
        val score =  holder.itemView.scoreText.text
        val comment =  holder.itemView.commentText.text
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MainActivity3::class.java)
            intent.putExtra("id", id)
            intent.putExtra("score", score)
            intent.putExtra("comment", comment)
            holder.itemView.context.startActivity(intent)
        }
      //  holder.itemView.studentScore3.text = data[position].score
     //   holder.itemView.studentComment3.text = data[position].comment

    }
}