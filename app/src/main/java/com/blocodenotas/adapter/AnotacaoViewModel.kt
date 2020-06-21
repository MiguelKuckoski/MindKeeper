package com.blocodenotas.adapter

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.*
import com.blocodenotas.dao.AnotacaoDatabase
import com.blocodenotas.dao.AnotacaoRepository
import com.blocodenotas.model.Anotacao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnotacaoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AnotacaoRepository
    init {
        val anotacaoDao = AnotacaoDatabase.getDatabase(application).anotacaoDao()
        repository = AnotacaoRepository(anotacaoDao)
    }

    private val searchStringLiveData = MutableLiveData<String>("")
    val allAnotacoes: LiveData<List<Anotacao>> = Transformations.switchMap(searchStringLiveData) {
            string->
        if (TextUtils.isEmpty(string)) {
            repository.anotacoes
        } else {
            repository.allAnotacoesByName(string)
        }
    }

    fun insert(anotacao: Anotacao) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(anotacao)
    }

    fun delete(anotacao : Anotacao) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(anotacao)
    }

    fun searchNameChanged(name: String) {
        searchStringLiveData.value = "%$name%"
    }
}