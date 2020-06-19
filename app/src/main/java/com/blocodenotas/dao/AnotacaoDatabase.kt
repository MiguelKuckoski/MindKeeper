package com.blocodenotas.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blocodenotas.model.Anotacao

@Database(entities = arrayOf(Anotacao::class), version = 1, exportSchema = false)
abstract class AnotacaoDatabase : RoomDatabase() {
    abstract fun anotacaoDao(): AnotacaoDao

    companion object {
        @Volatile
        private var INSTANCE: AnotacaoDatabase? = null

        fun getDatabase(context: Context): AnotacaoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnotacaoDatabase::class.java,
                    "anotacao_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}