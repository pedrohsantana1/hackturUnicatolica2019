package teste.m.hackturunicatolica2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_lista_local.view.*
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.model.ModelListaHome

class AdapterListaHome(var lista: ArrayList<ModelListaHome>) :
    RecyclerView.Adapter<AdapterListaHome.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_lista_local, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lista[position].nome?.let { holder.itemView.tvNome.text = it }
        lista[position].idDrawable?.let { holder.itemView.imgPerfil.setImageResource(it) }
        lista[position].catedoria?.let { holder.itemView.tvCategoria.text = it }
        lista[position].descricao?.let { holder.itemView.tvDescricao.text = it }

        holder.itemView.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_fragmentHome_to_fragmentDetalhesItem,
                bundleOf(
                    "idDrawable" to lista[position].idDrawable,
                    "nome" to lista[position].nome,
                    "descricao" to lista[position].descricao,
                    "detalhes" to lista[position].detalhes,
                    "cadegoria" to lista[position].catedoria,
                    "idDrawableStatus" to lista[position].idBarraStatusDrawable,
                    "longLat" to lista[position].latLong
                )
            )
        }
    }

    fun atualizarLista(lista: ArrayList<ModelListaHome>) {
        this.lista = lista
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}