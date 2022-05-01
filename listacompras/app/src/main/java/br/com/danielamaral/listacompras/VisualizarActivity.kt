package br.com.danielamaral.listacompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.danielamaral.listacompras.model.Produto

class VisualizarActivity : AppCompatActivity() {

    private lateinit var produtoSelecionado:Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        produtoSelecionado = intent.getSerializableExtra("dados") as Produto

        val tvItemNome:TextView = findViewById(R.id.tvItemNome)
        val tvItemMarca:TextView = findViewById(R.id.tvItemMarca)
        val tvItemPreco:TextView = findViewById(R.id.tvItemPreco)

        tvItemNome.text = produtoSelecionado.nome
        tvItemMarca.text = produtoSelecionado.marca
        tvItemPreco.text = produtoSelecionado.preco.toString()

    }
}