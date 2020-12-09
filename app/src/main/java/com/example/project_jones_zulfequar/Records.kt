package com.example.project_jones_zulfequar

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.*
@Entity

data class Records(
    @PrimaryKey @ColumnInfo(name = "id") var id : String,
    @ColumnInfo(name = "score") var score : String,
    @ColumnInfo(name = "comment") var comment : String
) {


}