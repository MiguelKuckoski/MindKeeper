package com.blocodenotas.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blocodenotas.model.Anotacao
import com.blocodenotas.model.AnotacaoViewModel
import com.blocodenotas.reciclerView.AdapterNotas
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

        val button : FloatingActionButton = findViewById(R.id.floatingActionButton2)

        button.setOnClickListener {
            val intent = Intent(this, EditAnotacaoActivity::class.java)
            startActivityForResult(intent, newActivityRequestCode)
        }
    }

    private fun initReciclerView(): AdapterNotas {
        val listRecycler : RecyclerView = findViewById(R.id.recyclerViewAnotacoes)
        listRecycler.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterNotas(this)
        listRecycler.adapter = adapter

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
}
