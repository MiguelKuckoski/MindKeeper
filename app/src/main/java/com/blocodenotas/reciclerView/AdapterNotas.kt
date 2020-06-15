package com.blocodenotas.reciclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blocodenotas.model.Anotacao
import com.example.blocodenotas.R

class AdapterNotas(
    private val context: Context,
    private val list: List<Anotacao>

) : RecyclerView.Adapter<AdapterNotas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.activity_main, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
//        holder.name.text = item.name;
//        holder.phone.text = item.phone;
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
//        val name = itemView.list_name
//        val phone = itemView.list_phone
    }
}