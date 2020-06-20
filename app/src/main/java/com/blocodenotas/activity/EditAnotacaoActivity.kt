package com.blocodenotas.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blocodenotas.model.Anotacao
import com.example.blocodenotas.R
import java.util.*

class EditAnotacaoActivity : AppCompatActivity()  {

    lateinit var textbody : EditText
    lateinit var titulo : EditText
    lateinit var idNota : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anotacao)

        this.textbody = findViewById(R.id.textBody)
        this.titulo = findViewById(R.id.titulo)
        this.idNota = findViewById(R.id.idNota)

        val bundle : Bundle? = intent.extras
        if(bundle != null) {
            val anotacao: Anotacao = bundle.get("editAnotacao") as Anotacao
            titulo.setText(anotacao.titulo)
            textbody.setText(anotacao.conteudo)
            idNota.text = anotacao.id.toString()

        }

        val button : ImageButton = findViewById(R.id.saveButton)
        button.setOnClickListener {
            salvarAnotacao()
        }

        val returnButton : ImageButton = findViewById(R.id.imageView)
        returnButton.setOnClickListener {
            this.onBackPressed()
        }
    }

    fun salvarAnotacao() {
        val anotacao = Anotacao(titulo = titulo.text.toString(), conteudo = textbody.text.toString(), dataModificacao = Calendar.getInstance().getTime().time)

        if(idNota.text != null) {
            anotacao.id = idNota.text.toString().toInt()
        }

        val replyIntent = Intent()

        replyIntent.putExtra(EXTRA_REPLY, anotacao)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "com.android.anotacaolistsql.REPLY"
    }

}