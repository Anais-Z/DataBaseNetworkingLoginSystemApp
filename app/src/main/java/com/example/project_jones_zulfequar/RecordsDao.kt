package com.example.project_jones_zulfequar

import androidx.room.Dao
import androidx.room.*
@Dao
interface RecordsDao {
    @Insert
    fun insertAll(vararg records: Records)


    @Update
    fun updateRecord(vararg records: Records)

    @Delete
    fun deleteRecord(vararg records: Records)

    @Query(" SELECT * From  records")
    fun getAll() : List<Records>
}