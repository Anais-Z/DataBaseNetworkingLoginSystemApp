package com.example.project_jones_zulfequar

import androidx.room.*
@Dao
interface UserDao {


    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insertUser(vararg user: User)

    @Update
    fun updateUser(vararg users: User)

    @Delete
    fun deleteUser(vararg users: User)

    @Query(" SELECT * From  user")
    fun getAll() : List<User>





}