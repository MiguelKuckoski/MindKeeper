package com.blocodenotas.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blocodenotas.model.Anotacao
import com.example.blocodenotas.R
import java.util.*

class EditAnotacaoActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anotacao)

        val button : ImageButton = findViewById(R.id.saveButton)
        button.setOnClickListener {
            salvarAnotacao()
        }

        val bundle = intent.extras
        if (bundle != null) {
//            textViewName.text = bundle.getString("name")
//            textViewAge.text = bundle.getString("age")
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        salvarAnotacao()
    }

    fun salvarAnotacao() {
        val textbody : EditText = findViewById(R.id.editText)
        val titulo : TextView = findViewById(R.id.textView2)
        val anotacao = Anotacao(id = 1, titulo = titulo.text.toString(), conteudo = textbody.text.toString(), dataModificacao = Calendar.getInstance().getTime())

    }

}