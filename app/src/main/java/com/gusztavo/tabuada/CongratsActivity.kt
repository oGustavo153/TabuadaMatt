package com.gusztavo.tabuada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_congrats.*
import kotlinx.android.synthetic.main.activity_nome.*

class CongratsActivity : NomeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)

        val acertos = intent.getIntExtra("ACERTOS", 0)
        val NOME = preferences.getString("NOME", "")

        txtNome.text = NOME

        if (acertos >= 0 && acertos < 4)
        {
            txtNome.text = "$NOME, dá para ir melhor na próxima!"
            txtAcertos.text = "Você acertou $acertos Questões!"
        }
        else if (acertos >= 5 && acertos < 8)
        {
            txtNome.text = "$NOME, você foi bem!"
            txtAcertos.text = "Você acertou $acertos Questões!"
        }
        else if (acertos >= 8 && acertos < 9)
        {
            txtNome.text = "$NOME, você foi ótimo!"
            txtAcertos.text = "Você acertou $acertos Questões!"
        }
        else if (acertos == 10)
        {
            txtNome.text = "$NOME, você é GENIAL!"
            txtAcertos.text = "Você acertou TODAS as questões!"
        }
    }
    fun voltar(view: View){
        val intent = Intent(this, OpcaoActivity::class.java)
        startActivity(intent)
        finish()
    }
}