package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_fragment_detalhes_item.view.*
import kotlinx.android.synthetic.main.layout_agencias.view.*
import kotlinx.android.synthetic.main.layout_descricao.view.*
import kotlinx.android.synthetic.main.layout_descricao.view.tvDescricao
import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterAgencias
import teste.m.hackturunicatolica2019.model.ModelListAngencias
import teste.m.hackturunicatolica2019.model.ModelListaHome

class FragmentDetalhesItem : Fragment() {
    private lateinit var mMap: GoogleMap
    private lateinit var modelListaHome: ModelListaHome
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            modelListaHome =
                ModelListaHome(
                    it.get("idDrawable") as Int,
                    it.get("nome").toString(),
                    it.get("descricao").toString(),
                    it.get("cadegoria").toString(),
                    it.get("detalhes").toString(),
                    it.getInt("idDrawableStatus"),
                    it.get("longLat") as LatLng

                )
        }
        val view = inflater.inflate(R.layout.fragment_fragment_detalhes_item, container, false)
        val viewDescricao = inflater.inflate(R.layout.layout_descricao, container, false)
        val viewMaps = inflater.inflate(R.layout.layout_map, container, false)
        val viewAgencias = inflater.inflate(R.layout.layout_agencias, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync { googleMap ->
            googleMap?.let {
                mMap = it
            }
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            modelListaHome.latLong?.let {
                val cameraPosition =
                    CameraPosition.builder().target(it)
                        .zoom(15f)
                        .bearing(0f)
                        .tilt(45f)
                        .build()
                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                mMap.addMarker(MarkerOptions().position(it).title(modelListaHome.nome))
            }
        }

        viewAgencias.recycleAgencias.layoutManager = LinearLayoutManager(activity)
        viewAgencias.recycleAgencias.adapter = AdapterAgencias(
            arrayListOf(
                ModelListAngencias(null, "Agencia 1", "9 9999-9999"),
                ModelListAngencias(null, "Agencia 2", "9 9999-9999")
            )
        )


        view.frameLayout.addView(viewDescricao)
        modelListaHome.idDrawable?.let { view.imgHeader.setImageResource(it as Int) }
        modelListaHome.nome?.let { viewDescricao.tvTitle.text = it as String }
        modelListaHome.detalhes?.let { viewDescricao.tvDescricao.text = it as String }
        view.buttonDireita.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewDescricao)
        }
        view.buttonCentro.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewMaps)
        }
        view.buttonEsquerda.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewAgencias)
        }
        return view
    }


}
