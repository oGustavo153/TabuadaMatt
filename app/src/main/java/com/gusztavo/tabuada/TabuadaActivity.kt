package com.gusztavo.tabuada

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.gusztavo.tabuada.util.Explicacao
import com.gusztavo.tabuada.util.Explicacoes
import com.gusztavo.tabuada.util.Questao
import kotlinx.android.synthetic.main.activity_tabuada.*

class TabuadaActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var txt_Explicacao: TextView
    private var explicacaoAtual: Int = 1//Qual explicação está aparecendo
    private var explicacaoLista: ArrayList<Explicacao>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuada)

        explicacaoLista = Explicacoes.getExplicacao()
        txt_Explicacao = findViewById(R.id.txt_Explicacao)
        setExplicacao()

        img_next.setOnClickListener(this)

        Glide.with(this)
            .load(R.drawable.matt_handup)
            .into(findViewById(R.id.matt_handup))
    }

    fun setExplicacao(){
        val explicacao = explicacaoLista!![explicacaoAtual - 1]

        txt_Explicacao.text = explicacao!!.texto
    }

    override fun onClick(v: View){
        explicacaoAtual++
        when {
            explicacaoAtual <= explicacaoLista!!.size -> {
                setExplicacao()
            }
        }
    }

    fun muda (view : View)
    {
        val intent = Intent (this, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun ready(view: View){
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.builder_message))
            .setTitle(getString(R.string.builder_title))
            .setPositiveButton("Sim!", DialogInterface.OnClickListener { _, _ -> muda(view)})
            .setNegativeButton("Não.", DialogInterface.OnClickListener { _, _ -> finish()})
            .setIcon(R.mipmap.matt_head)
            .show()
    }
}