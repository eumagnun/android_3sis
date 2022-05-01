package br.com.danielamaral.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danielamaral.listacompras.adapter.ItemAdapter
import br.com.danielamaral.listacompras.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(),ItemAdapter.OnProdutoClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        Log.i("DADOS", Database.listaCompras.toString())
        val rvListaCompras:RecyclerView  = findViewById(R.id.rvListaCompras)
        rvListaCompras.layoutManager = LinearLayoutManager(this)

        rvListaCompras.adapter = ItemAdapter(Database.listaCompras,this)

        val fabCadastrarProduto:FloatingActionButton = findViewById(R.id.fabCadastraProduto)
        fabCadastrarProduto.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onProdutoClick(produtoPosition: Int) {
        val intent = Intent(this, VisualizarActivity::class.java)
        intent.putExtra("dados",Database.listaCompras[produtoPosition])
        startActivity(intent)
    }
}