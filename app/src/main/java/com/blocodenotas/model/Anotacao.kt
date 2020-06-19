package com.blocodenotas.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Anotacao(val titulo: String, val conteudo: String, val dataModificacao: Long) : Serializable {

    @PrimaryKey(autoGenerate = true) var id: Int? = null

}