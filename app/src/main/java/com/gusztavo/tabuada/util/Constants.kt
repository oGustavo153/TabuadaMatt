package com.gusztavo.tabuada.util

import com.gusztavo.tabuada.R

//Aqui ficam armazenadas as questões.
object Constants{

    fun getQuestao(): ArrayList<Questao>{

        val questaoLista = ArrayList<Questao>()

        val q1 = Questao(1, "Gustavo tinha tarefas atrasadas para fazer, então decidiu fazer duas tarefas por dia. Quantas tarefas Gustavo fez em 2 dias?",
            R.drawable.questao_um, "4", "2", "22", "8", 1)
        questaoLista.add(q1)

        val q2 = Questao(2, "Partindo do 0 e contando de 3 em 3, quais são os números que você vai falar até chegar ao 24?",
            R.drawable.questao_dois, "0, 3, 9, 12, 15, 18, 21, 24", "0, 3, 6, 9, 12, 15, 21, 24", "0, 3, 6, 9, 12, 15, 18, 24", "0, 3, 6, 9, 12, 15, 18, 21, 24", 4)
        questaoLista.add(q2)

        val q3 = Questao(3, "Vendi 6 copos em um dia, 8 copos em outro dia, e 6 copos em outro, dando um total de 20 copos. Como isso ficaria em multiplicação?",
            R.drawable.questao_tres, "2 x 9", "4 x 5", "5 x 6", "3 x 6", 2)
        questaoLista.add(q3)

        val q4 = Questao(4, "Gustavo quer comprar 3 sorvetes. Cada um custa 4 reais. Quantos reais Gustavo vai precisar para comprar os três?",
            R.drawable.questao_quatro, "R$08,00", "R$06,00", "R$12,00", "R$14,00", 3)
        questaoLista.add(q4)

        val q5 = Questao(5,"A casa de João fica a 200 metros da escola. Quantos metros ele percorre para ir e voltar de segunda a sexta-feira?",
            R.drawable.questao_cinco,"4000", "1000", "2000", "1200",3)
        questaoLista.add(q5)

        val q6 = Questao(6, "Em uma sala de cinema, há 6 fileiras, cada uma com 6 cadeiras. Quantas cadeiras no total tem nesse cinema?",
            R.drawable.questao_seis, "30","16","66","36",4)
        questaoLista.add(q6)

        val q7 = Questao(7, "A cada 7 horas, 5 barcos passam por uma rota no mar. Quantos barcos irão passar por essa rota depois de 28 horas?",
            R.drawable.questao_sete, "20","15", "35", "24", 1)
        questaoLista.add(q7)

        val q8 = Questao(8, "Uma parede tem 5 metros de altura, e 8 de largura. Os blocos usados para erguer essa parede tem 1 metro de altura, e 1 de largura. Quantos blocos foram usados no total?",
            R.drawable.questao_oito, "30","40","80","50", 2)
        questaoLista.add(q8)

        val q9 = Questao(9, "Rita fez 95 travessas de barrinha de cereal, com 35 barrinhas em cada travessa. Ela distribuiu 1.100 barrinhas para os vizinhos experimentarem. Quantas barrinhas sobraram?",
            R.drawable.questao_nove, "3325", "2500", "1100", "2225", 4)
        questaoLista.add(q9)

        val q10 = Questao(10, "A lanchonete utiliza 5 litros de leite para fazer o café com leite todos os dias. Quantos litros de leite serão utilizados no mês de abril?",
            R.drawable.questao_dez, "120", "140", "30", "150", 4)
        questaoLista.add(q10)
        return questaoLista
    }
}