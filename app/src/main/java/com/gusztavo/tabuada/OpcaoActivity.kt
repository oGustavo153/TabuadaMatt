package com.gusztavo.tabuada

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class OpcaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcao)
    }

        fun tabuada(view: View){
            val intent = Intent (this, TabuadaActivity::class.java)
            startActivity(intent)
        }
    }