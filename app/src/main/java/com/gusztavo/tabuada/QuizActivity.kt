package com.gusztavo.tabuada

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.gusztavo.tabuada.util.Constants
import com.gusztavo.tabuada.util.Questao
import kotlinx.android.synthetic.main.activity_questao_quiz.*

open class QuizActivity : NomeActivity(), View.OnClickListener{

    private var posicaoAtual:Int = 1    //Qual questão está aparecendo
    private var questaoLista: ArrayList<Questao>? = null
    private var altSelecionada: Int = 0 //vamos usar isso para checar se a questao selecionada foi correta ou nao
    private var questoesErradas: ArrayList<Questao>? = null
    lateinit var mp: MediaPlayer
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questao_quiz)

        //sPreferencesQE = getSharedPreferences("questoesErradas", Context.MODE_PRIVATE)
        questaoLista = Constants.getQuestao()

        setQuestao()//chama a função para iniciar a questao

        txt_AltUm.setOnClickListener(this)      //
        txt_AltDois.setOnClickListener(this)    //Faz com que as alternativas sejam clicaveis, mesmo
        txt_AltTres.setOnClickListener(this)    //sendo um TextView
        txt_AltQuatro.setOnClickListener(this)  //
        btn_Responder.setOnClickListener(this)
    }

    private fun setQuestao(){

        //O -1 é utilizado pois a posição atual na verdade está no vetor 0
        val questao = questaoLista!![posicaoAtual-1]

        altDefaultDesign()

        //se a posição da questão atual for do mesmo tamanho de 'questaoLista', quer dizer que é a última questão, então o texto do botão será 'TERMINAR'.
        if(posicaoAtual == questaoLista!!.size){
            btn_Responder.text = "TERMINAR"
        }
        else{
            btn_Responder.text = "RESPONDER"
        }

        pb_Questao.progress = posicaoAtual //progresso da barra de progresso é posicaoAtual, que é 1
        txt_Progresso.text = "$posicaoAtual" + "/" + pb_Questao.max

        //Val 'questao' é do tipo "Questao". "Questao" é a classe que contém os atributos questao, image, etc..
        txt_Questao.text = questao!!.questao
        img_Questao.setImageResource(questao.imagem)
        txt_AltUm.text = questao.altUm
        txt_AltDois.text = questao.altDois
        txt_AltTres.text = questao.altTres
        txt_AltQuatro.text = questao.altQuatro
    }

    //vai setar a aparencia padrao das alternativas.
    private fun altDefaultDesign(){
        val alternativas = ArrayList<TextView>()
        alternativas.add(0,txt_AltUm)
        alternativas.add(1,txt_AltDois)
        alternativas.add(2,txt_AltTres)
        alternativas.add(3,txt_AltQuatro)

        for (alt in alternativas){
            alt.setTextColor(Color.parseColor("grey"))
            alt.typeface = Typeface.DEFAULT
            alt.background = ContextCompat.getDrawable(this,R.drawable.alt_default_design)
        }
    }

    private fun altSelecionadaDesign(textView: TextView, altNumSelecionada: Int){//vai setar a aparencia da alternativa selecionada.
        altDefaultDesign()
        altSelecionada = altNumSelecionada

        textView.setTextColor(Color.parseColor("black"))
        textView.setTypeface(Typeface.DEFAULT_BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.alt_selecionada_design)
    }

    private fun altRespostaDesign(resposta: Int, altDesign: Int){
        when (resposta){
            1 ->{
                txt_AltUm.background = ContextCompat.getDrawable(this,altDesign)
            }
            2 ->{
                txt_AltDois.background = ContextCompat.getDrawable(this,altDesign)
            }
            3 ->{
                txt_AltTres.background = ContextCompat.getDrawable(this,altDesign)
            }
            4 ->{
                txt_AltQuatro.background = ContextCompat.getDrawable(this,altDesign)
            }
        }
    }

    override fun onClick(v: View?) {

        //quando a alternativa for selecionada, vai chamar a função "altSelecionadaDesign", que vai aplicar o design para txt_...
        when(v?.id){
            R.id.txt_AltUm ->{
                altSelecionadaDesign(txt_AltUm, 1)
            }
            R.id.txt_AltDois ->{
                altSelecionadaDesign(txt_AltDois, 2)
            }
            R.id.txt_AltTres ->{
                altSelecionadaDesign(txt_AltTres, 3)
            }
            R.id.txt_AltQuatro ->{
                altSelecionadaDesign(txt_AltQuatro, 4)
            }
            R.id.btn_Responder ->{
                if(altSelecionada == 0){
                    posicaoAtual ++
                    txt_AltUm.setOnClickListener(this)
                    txt_AltDois.setOnClickListener(this)
                    txt_AltTres.setOnClickListener(this)
                    txt_AltQuatro.setOnClickListener(this)

                    when{
                        posicaoAtual <= questaoLista!!.size ->
                        {
                            setQuestao()
                        }
                        else ->{
                            val intent = Intent (this, CongratsActivity::class.java). apply {
                                putExtra("ACERTOS", count)
                            }
                            startActivity(intent)
                            finish()
                        }
                    }
                }else {
                    val questao = questaoLista!![posicaoAtual - 1]
                    if (questao.altCorreta != altSelecionada) {
                        altRespostaDesign(altSelecionada, R.drawable.alt_errada_design)
                        /*//Adicionar as questões erradas para "questoesErradas"
                        questoesErradas?.add(questao)
                        Log.v("Errou a questão: ", questao.toString())*/
                        mp = MediaPlayer.create(this, R.raw.answer_wrong)
                        mp.start()


                    } else {
                        altRespostaDesign(questao.altCorreta, R.drawable.alt_correta_design)
                        //Som emitido ao acertar a questão
                        mp = MediaPlayer.create(this, R.raw.answer_correct)
                        mp.start()

                        count++
                    }
                    txt_AltUm.setOnClickListener(null)
                    txt_AltDois.setOnClickListener(null)
                    txt_AltTres.setOnClickListener(null)
                    txt_AltQuatro.setOnClickListener(null)


                    if (posicaoAtual == questaoLista!!.size) {
                        btn_Responder.text =
                            "TERMINAR"
                    } else {
                        btn_Responder.text = "PRÓXIMA QUESTÃO"
                    }
                    altSelecionada = 0
                    //Essa parte do código só irá acontecer, caso altSelecionada = 0, como mostra na linha 108
                    //Quando for 0 (linha 133), a posiçãoAtual vai aumentar +1, ou seja, vai para a próxima questão
                }

            }
        }
    }
}