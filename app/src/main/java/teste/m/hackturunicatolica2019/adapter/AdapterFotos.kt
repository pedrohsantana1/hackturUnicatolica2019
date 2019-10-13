package teste.m.hackturunicatolica2019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_maps.view.*
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.model.ModelListFotos

class AdapterFotos(var list: ArrayList<ModelListFotos>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_maps,parent,false)
        return  ViewModel(view)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        list[position].idDrawable?.let {  holder.itemView.imgFotos.setImageResource(it) }
    }
    inner class ViewModel(view:View):RecyclerView.ViewHolder(view)
}