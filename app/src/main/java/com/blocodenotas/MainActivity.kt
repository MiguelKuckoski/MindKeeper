package com.blocodenotas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blocodenotas.model.Anotacao
import com.blocodenotas.reciclerView.AdapterNotas
import com.example.blocodenotas.R

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
        val button : Button = findViewById(R.id.recyclerViewAnotacoes)

        button.setOnClickListener {
            setContentView(R.layout.activity_anotacao)
        }
    }
}
