package com.gusztavo.tabuada.util

//é uma DATA class, pois essa classe não tem uma outra função que não seja armazenar atributos das questões.
data class Questao
(
    val Id: Int, //Id da questão
    val questao: String, //questão
    val imagem: Int, //Imagem da questão

    val altUm: String, //
    val altDois: String,  //  Alternativas
    val altTres: String, //
    val altQuatro: String,   //
    val altCorreta: Int        // opção correta
)