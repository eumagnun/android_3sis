package br.com.danielamaral.listacompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.danielamaral.listacompras.model.Produto

class MainActivity : AppCompatActivity() {

    //private val listaCompras = listOf<String>("carne","cerveja","farofa","gelo")
    private lateinit var listaCompras:MutableList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSaida:TextView = findViewById(R.id.tvSaida)

        val etNomeProduto:TextView = findViewById(R.id.etNomeProduto)
        val etMarcaProduto:TextView = findViewById(R.id.etMarcaProduto)
        val etPrecoProduto:TextView = findViewById(R.id.etPrecoProduto)

        val btAdicionar:TextView = findViewById(R.id.btAdicionar)

        btAdicionar.setOnClickListener {
            cadastraItem(etNomeProduto.text.toString()
                        ,etMarcaProduto.text.toString()
                        ,etPrecoProduto.text.toString())

            atualizarTela(tvSaida)
            etNomeProduto.text=""
            etMarcaProduto.text=""
            etPrecoProduto.text=""
        }
        listaCompras = mutableListOf()
    }

    fun atualizarTela(saida:TextView){
        saida.text  =""
        listaCompras.forEach{
            val texto = "${saida.text} ${it.nome} - ${it.marca} - ${it.preco} \n"
            saida.text = texto
        }
    }

    fun cadastraItem(nome:String, marca:String, preco:String){
        listaCompras.add(Produto(nome = nome, marca=marca, preco=preco.toDouble()))
    }
}