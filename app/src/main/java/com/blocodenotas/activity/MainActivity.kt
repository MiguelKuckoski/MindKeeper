package com.blocodenotas.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blocodenotas.model.Anotacao
import com.blocodenotas.reciclerView.AdapterNotas
import com.example.blocodenotas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listRecycler : RecyclerView = findViewById(R.id.recyclerViewAnotacoes)

        val list = ArrayList<Anotacao>()
        val layoutManager = LinearLayoutManager(this)
        listRecycler.layoutManager = layoutManager
        val adapter = AdapterNotas(this, list)
        listRecycler.adapter = adapter
        val button : FloatingActionButton = findViewById(R.id.floatingActionButton2)

        button.setOnClickListener {
            val intent = Intent(this, EditAnotacaoActivity::class.java)
            startActivityForResult(intent, 1)
        }

        insertItem(list, adapter)


    }

    private fun insertItem(list: ArrayList<Anotacao>, adapter : AdapterNotas) {
        list.add(Anotacao(0, "teste0", "vaarios itens0 na lista", Calendar.getInstance().getTime()))
        list.add(Anotacao(1, "teste1", "vaarios itens1 na lista", Calendar.getInstance().getTime()))
        list.add(Anotacao(2, "teste2", "vaarios itens2 na lista", Calendar.getInstance().getTime()))
        adapter.notifyDataSetChanged()
    }
}
