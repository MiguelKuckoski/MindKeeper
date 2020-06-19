package com.blocodenotas.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.blocodenotas.dao.AnotacaoRepository
import com.blocodenotas.dao.AnotacaoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnotacaoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AnotacaoRepository

    val allAnotacoes: LiveData<List<Anotacao>>

    init {
        val anotacaoDao = AnotacaoDatabase.getDatabase(application).anotacaoDao()
        repository = AnotacaoRepository(anotacaoDao)
        allAnotacoes = repository.anotacoes
    }

    fun insert(anotacao: Anotacao) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(anotacao)
    }
}