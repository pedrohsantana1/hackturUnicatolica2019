package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_splash.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.viewModel.ViewModelLogin

class FragmentLogin : Fragment() {

    lateinit var viewewModelLogin: ViewModelLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        view.tvNovaConta.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_fragmentLogin_to_fragmentCadastroUser)
        }
        view.imgConfirma.setOnClickListener {
            var chave = false
            if (!view.etUser.text.isEmpty() && !view.novaSenha.text.isEmpty()) {
                viewewModelLogin.getALL().observe(this, Observer {
                    if (it.isNotEmpty()) {
                        for (obj in it) {
                            if(obj.userName == view.etUser.text.toString() && obj.senha == view.novaSenha.text.toString()){
                                Navigation.findNavController(view)
                                    .navigate(R.id.action_fragmentLogin_to_fragmentHomeLogim)
                                chave = true
                            }
                        }
                        if(!chave){
                            view.etUser.error = "senha ou usuario invalido"
                        }
                    }else{
                        view.etUser.error = "favor criar um usuario"
                    }
                }
                )

            }
        }

        return view
    }

}
