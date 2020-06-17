package com.blocodenotas.reciclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blocodenotas.model.Anotacao
import com.example.blocodenotas.R
import kotlinx.android.synthetic.main.anotacao_view.view.*

class AdapterNotas(
    private val context: Context,
    private val list: List<Anotacao>

) : RecyclerView.Adapter<AdapterNotas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.anotacao_view, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.titulo.text = item.titulo
        holder.textBody.setText(item.conteudo)
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.list_titulo
        val textBody = itemView.textbody
    }
}