package br.com.danielamaral.jogo_domilhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.danielamaral.jogo_domilhao.databinding.FragmentHomeBinding
import br.com.danielamaral.show_do_milhao.Database
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        binding.btJogar.setOnClickListener {

            val nomeDigitado = binding.etNomeJogador.text.toString()

            if(!nomeDigitado.equals("")) {
                Database.jogador.nome = nomeDigitado
                view?.findNavController()?.navigate(R.id.action_homeFragment_to_jogoFragment)
            }else{
                val msg = Snackbar.make(binding.root,"Nome inválido",Snackbar.LENGTH_SHORT)
                msg.show()
            }
        }
        return binding.root
    }

}