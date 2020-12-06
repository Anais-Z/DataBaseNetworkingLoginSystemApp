package com.example.project_jones_zulfequar

import androidx.room.*
@Entity

data class User(
    @PrimaryKey @ColumnInfo(name = "id") var id : String,
    @ColumnInfo(name = "score") var score : String,
   @ColumnInfo(name = "comment") var comment : String

)  {
    override fun toString(): String {
        return "    $id                                   $score                                          $comment "
    }

}