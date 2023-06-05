package com.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getDao(): LoveDao
}