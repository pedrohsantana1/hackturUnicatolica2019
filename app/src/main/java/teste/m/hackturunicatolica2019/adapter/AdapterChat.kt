package teste.m.hackturunicatolica2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_balao_um.view.*
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.model.ModelChat

class AdapterChat(var list: ArrayList<ModelChat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View
        when (list[viewType].layoutType) {
            1 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_balao_um, parent, false)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_balao_dois, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        list[position].mensagem?.let { holder.itemView.tvMensagem.text = it }
        list[position].idDrawable?.let { holder.itemView.imgMensagem.setImageResource(it) }
    }
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun atualizarLista(list: ArrayList<ModelChat>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}