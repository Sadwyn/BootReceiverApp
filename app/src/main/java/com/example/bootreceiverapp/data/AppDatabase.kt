package com.example.bootreceiverapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BootModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bootDAO(): BootDAO
}