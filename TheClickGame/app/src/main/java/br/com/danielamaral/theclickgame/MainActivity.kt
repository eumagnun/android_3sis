package br.com.danielamaral.theclickgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import br.com.danielamaral.theclickgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var contadorPontos = 0
    private var contadorCliques = 0
    private var pontosPorClique = 10
    private lateinit var binding: ActivityMainBinding
    private val processoPesado = ProcessoPesado(this.lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btRed.setOnClickListener {
            contadorCliques++
            contadorPontos = contadorCliques * pontosPorClique
            binding.tvCliques.text = contadorCliques.toString()
            binding.tvPontos.text = contadorPontos.toString()
        }

        Log.i("CICLO_DE_VIDA","onCreate")
        if(savedInstanceState!=null){
            contadorCliques = savedInstanceState.getInt("contadorCliques")
            contadorPontos = savedInstanceState.getInt("contadorPontos")
            binding.tvCliques.text = contadorCliques.toString()
            binding.tvPontos.text = contadorPontos.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_DE_VIDA","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_DE_VIDA","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO_DE_VIDA","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_DE_VIDA","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLO_DE_VIDA","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_DE_VIDA","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contadorPontos",contadorPontos)
        outState.putInt("contadorCliques",contadorCliques)
        Log.i("CICLO_DE_VIDA","onSaveInstanceState invocado")
    }
}