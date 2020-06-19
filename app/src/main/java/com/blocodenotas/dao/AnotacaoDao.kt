package com.blocodenotas.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.blocodenotas.model.Anotacao

@Dao
interface AnotacaoDao {

    @Query("SELECT * FROM ANOTACAO")
    fun getAnotacoes() : LiveData<List<Anotacao>>

    @Insert
    fun insert(anotacao: Anotacao)

}