package com.blocodenotas.dao

import androidx.lifecycle.LiveData
import com.blocodenotas.model.Anotacao

class AnotacaoRepository(private val anotacaoDao: AnotacaoDao) {

    val anotacoes: LiveData<List<Anotacao>> = anotacaoDao.getAnotacoes()
    fun allAnotacoesByName(name:String):LiveData<List<Anotacao>> = anotacaoDao.allAnotacoesByName(name)

    suspend fun insert(anotacao: Anotacao) {
        anotacaoDao.insert(anotacao)
    }

    suspend fun delete(anotacao: Anotacao) {
        anotacaoDao.delete(anotacao)
    }
}