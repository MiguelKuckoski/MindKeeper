package com.blocodenotas.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blocodenotas.adapter.AdapterNotas
import com.blocodenotas.model.Anotacao
import com.blocodenotas.model.AnotacaoViewModel
import com.example.blocodenotas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var anotacaoViewModel: AnotacaoViewModel
    private val newActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =initReciclerView()

        anotacaoViewModel = ViewModelProvider(this).get(AnotacaoViewModel::class.java)
        anotacaoViewModel.allAnotacoes.observe(this, Observer { anotacoes ->
            anotacoes?.let { adapter.setAnotacoes(it) }
        })

        val adicionar : FloatingActionButton = findViewById(R.id.floatingActionButton2)

        adicionar.setOnClickListener {
            val intent = Intent(this, EditAnotacaoActivity::class.java)
            startActivityForResult(intent, newActivityRequestCode)
        }

        val search : SearchView = findViewById(R.id.searchButton)


    }

    private fun initReciclerView(): AdapterNotas {
        val listView : ListView = findViewById(R.id.listViewAnotacoes)
        val adapter = AdapterNotas(this)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, EditAnotacaoActivity::class.java)
            var anotacao : Anotacao? = anotacaoViewModel.allAnotacoes.value?.get(position)
            intent.putExtra("editAnotacao", anotacao)
            startActivityForResult(intent, newActivityRequestCode)
        }


        listView.setOnItemLongClickListener { parent, view, position, id ->
            var anotacao : Anotacao? = anotacaoViewModel.allAnotacoes.value?.get(position)
            if (anotacao != null) {
                solicitaConfirmacao(anotacao)
            }
            true
        }
        return adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getSerializableExtra(EditAnotacaoActivity.EXTRA_REPLY)?.let {
                val anotacao = it
                anotacaoViewModel.insert(anotacao as Anotacao)
            }
        }
    }

    fun solicitaConfirmacao(anotacao : Anotacao) {

        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alerta")
        alertDialog.setMessage("Apagar anotacao ?")

        alertDialog.setPositiveButton("Sim") { _, _ ->
            anotacaoViewModel.delete(anotacao)
            return@setPositiveButton
        }

        alertDialog.setNegativeButton("Não") { _, _ ->
            return@setNegativeButton
        }
        alertDialog.show()
    }

}
