package com.gusztavo.tabuada

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Main : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this)
            .load(R.drawable.matt_stand)
            .into(findViewById(R.id.matt_stand))
    }
    //É a função que mudará a tela após o botão "Começar" for clicado
    fun muda (view : View)
    {
        val intent = Intent (this, OpcaoActivity::class.java)
        startActivity(intent)
    }
}