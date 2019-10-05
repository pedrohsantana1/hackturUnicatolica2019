package teste.m.hackturunicatolica2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_agencias.view.*
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.model.ModelListAngencias

class AdapterAgencias(val list:ArrayList<ModelListAngencias>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_agencias,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        list[position].idDrawable?.let { holder.itemView.imgPerfil.setImageResource(it) }
        list[position].contato?.let { holder.itemView.tvContato.text = it }
        list[position].nome?.let { holder.itemView.tvNome.text = it }
    }

    inner class  ViewHolder(view:View):RecyclerView.ViewHolder(view)
}