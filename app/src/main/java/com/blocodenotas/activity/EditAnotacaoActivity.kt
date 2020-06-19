package com.blocodenotas.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
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

    }

    override fun onBackPressed() {
        super.onBackPressed()
        salvarAnotacao()
    }

    fun salvarAnotacao() {
        val textbody : EditText = findViewById(R.id.textBody)
        val titulo : EditText = findViewById(R.id.titulo)
        val anotacao = Anotacao(titulo = titulo.text.toString(), conteudo = textbody.text.toString(), dataModificacao = Calendar.getInstance().getTime().time)
        val replyIntent = Intent()

        replyIntent.putExtra(EXTRA_REPLY, anotacao)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "com.android.anotacaolistsql.REPLY"
    }

}