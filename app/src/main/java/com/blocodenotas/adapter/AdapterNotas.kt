package com.blocodenotas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.blocodenotas.model.Anotacao
import com.example.blocodenotas.R
import kotlinx.android.synthetic.main.anotacao_view.view.*


class AdapterNotas(
    private val context: Context
) : BaseAdapter() {

    private var anotacoesList = emptyList<Anotacao>()
    private var mInflator: LayoutInflater = LayoutInflater.from(context)

    internal fun setAnotacoes(anotacoes: List<Anotacao>) {
        this.anotacoesList = anotacoes
        notifyDataSetChanged()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.anotacao_view,null)

        val titulo : TextView = view.list_titulo
        val textbody : TextView = view.textbody

        val item = anotacoesList[position]
        textbody.text = item.conteudo
        titulo.text = item.titulo

        return view
    }

    override fun getItem(position: Int): Any {
        return anotacoesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return anotacoesList.size
    }

}

