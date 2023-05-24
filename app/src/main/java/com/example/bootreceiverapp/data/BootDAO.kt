package com.example.bootreceiverapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BootDAO {
    @Insert
    fun insert(boot: BootModel)

    @Query("SELECT * FROM boots")
    fun getAll(): List<BootModel>
}