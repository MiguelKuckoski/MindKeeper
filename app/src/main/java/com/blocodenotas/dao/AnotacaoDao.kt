package com.blocodenotas.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.blocodenotas.model.Anotacao

@Dao
interface AnotacaoDao {

    @Query("SELECT * FROM ANOTACAO")
    fun getAnotacoes() : LiveData<List<Anotacao>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anotacao: Anotacao)

    @Delete
    fun delete(anotacao : Anotacao)

    @Query("SELECT * FROM ANOTACAO where ANOTACAO.titulo LIKE :name or LOWER(ANOTACAO.titulo) like LOWER(:name)")
    fun allAnotacoesByName(name: String): LiveData<List<Anotacao>>

}