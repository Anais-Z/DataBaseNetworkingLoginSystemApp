package com.example.project_jones_zulfequar

import androidx.room.*
@Entity

data class User(
    @PrimaryKey var id : String,
    var score : String,
    var comment : String

)  {
    override fun toString(): String {
        return "$id , $score , $comment"
    }

}