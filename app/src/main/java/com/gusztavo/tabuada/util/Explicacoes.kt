package com.gusztavo.tabuada.util

//Nesse objeto, poderão ser adicionadas as explicações que são exibidas na lousa em "TabuadaActivity".

object Explicacoes {

    fun getExplicacao(): ArrayList<Explicacao>{
        val explicacaoLista = ArrayList<Explicacao>()

        val e1 = Explicacao("\nA tabuada é um tópico muito importante para aprendermos, pois iremos usar lá na frente de diversas maneiras.\nSeu conceito é bem simples, é só pensar ''quantas vezes alguma coisa foi feita?''. Por exemplo:\nJoão comprou 2 vezes 2 brinquedos. Isso fica 2x2, que é 4!\nPara facilitar, podemos usar a soma:\nSe João comprou 2 vezes 3 brinquedos, somamos 3 vezes o 2, que dá 2+2+2, que é 6!\n")
        explicacaoLista.add(e1)

        val e2 = Explicacao("\nbla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla \n")
        explicacaoLista.add(e2)


        return explicacaoLista
    }
}