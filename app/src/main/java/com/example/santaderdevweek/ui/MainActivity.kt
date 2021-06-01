package com.example.santaderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santaderdevweek.R
import com.example.santaderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer {
            bindOnView(it)
        })
    }

    private fun bindOnView(it: Conta) {
        findViewById<TextView>(R.id.tv_usuario).text = getString(R.string.txt_bemvindo) + ", " + it.cliente.nome
        findViewById<TextView>(R.id.tv_agencia).text = "Ag " + it.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = "CC " + it.numero
        findViewById<TextView>(R.id.tv_saldo_conta_corrente).text = "R$ " + it.saldo
        findViewById<TextView>(R.id.tv_valor_limite).text = "R$ " + it.limite
        findViewById<TextView>(R.id.tv_numero_cartao_final).text = it.cartao.numeroCartao.substring(it.cartao.numeroCartao.length-4, it.cartao.numeroCartao.length)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_notificacao -> {
                Log.d("CLICK", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}