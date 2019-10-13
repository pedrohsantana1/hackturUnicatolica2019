package teste.m.hackturunicatolica2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_filtros.view.*
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.model.ModelListFiltro

class AdapterFiltros(var list:ArrayList<ModelListFiltro>, val clicListener:(item:ModelListFiltro)->Unit):RecyclerView.Adapter<AdapterFiltros.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_filtros,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            clicListener(list[position])
        }
        list[position].idDrawable?.let { holder.itemView.imgFotoFiltro.setImageResource(it) }
        list[position].nomeFiltro?.let { holder.itemView.tvNomeFIltro.text = it }
    }

    fun atualizarLista(list: ArrayList<ModelListFiltro>){
        this.list = list
        notifyDataSetChanged()
    }
  inner class ViewHolder(view:View):RecyclerView.ViewHolder(view)
}