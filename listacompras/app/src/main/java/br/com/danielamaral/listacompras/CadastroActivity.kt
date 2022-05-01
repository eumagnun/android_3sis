package br.com.danielamaral.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.danielamaral.listacompras.model.Produto

class CadastroActivity : BaseActivity() {


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

            etNomeProduto.text=""
            etMarcaProduto.text=""
            etPrecoProduto.text=""

            esconderTeclado()

            navegar(classe= ListaActivity::class.java)

        }

    }

    fun cadastraItem(nome:String, marca:String, preco:String){
        Database.listaCompras.add(Produto(nome = nome, marca=marca, preco=preco.toDouble()))
    }
}