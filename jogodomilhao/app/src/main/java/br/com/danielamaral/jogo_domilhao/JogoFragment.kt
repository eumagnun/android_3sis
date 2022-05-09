package br.com.danielamaral.jogo_domilhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import br.com.danielamaral.jogo_domilhao.databinding.FragmentJogoBinding
import br.com.danielamaral.show_do_milhao.Database

class JogoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentJogoBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_jogo,container,false)

        binding.tvPergunta.text = Database.perguntas[0].texto
        binding.rbResposta1.text  = Database.perguntas[0].respostas[0].texto
        binding.rbResposta2.text  = Database.perguntas[0].respostas[1].texto
        binding.rbResposta3.text  = Database.perguntas[0].respostas[2].texto

        return binding.root
    }

}