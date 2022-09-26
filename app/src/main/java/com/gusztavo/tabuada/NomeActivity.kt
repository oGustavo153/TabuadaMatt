package com.gusztavo.tabuada

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_congrats.*
import kotlinx.android.synthetic.main.activity_nome.*

open class NomeActivity : AppCompatActivity(){

    var NOME : String = "NOME"
    lateinit var etxtNome: EditText
    protected lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nome)

        etxtNome = findViewById(R.id.etxtNome)
        preferences = getSharedPreferences("PREF",Context.MODE_PRIVATE)
    }

    fun inicia (view : View)
    {
        if(!etxtNome.text.isEmpty())
        {
            //valores
            NOME = etxtNome.text.toString().trim()

            //editor dos valores
            val editor = preferences.edit()

            //coloca os valores na variavel
            editor.putString("NOME", NOME)
            editor.apply()

            val i = Intent(this, Main::class.java)
            startActivity(i)
        }
        else
        {
            Toast.makeText(this,"Digite seu nome!", Toast.LENGTH_SHORT).show()
        }
        //Verificação no Log (Linha opcional!)
        Log.e("Nome ----------> ", NOME)
    }
}