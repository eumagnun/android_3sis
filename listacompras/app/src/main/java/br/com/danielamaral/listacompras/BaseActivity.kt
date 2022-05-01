package br.com.danielamaral.listacompras

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    fun navegar(parametro:String?=null,classe:Class<*>){
        val intent = Intent(this,classe)
        if(parametro !=null){
            intent.putExtra("param",parametro)
        }
        startActivity(intent)
    }

    fun esconderTeclado(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view: View? = currentFocus
        if(view !=null){
            imm.hideSoftInputFromWindow(view.windowToken,0)
        }
    }
}