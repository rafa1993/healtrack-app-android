package com.example.healthtrack_imc

enum class Classification(val classification: String, val obesity: String) {
    MAGREZA("Magreza", "0"),
    NORMAL("Normal", "0"),
    SOBREPESO("Sobrepeso", "I"),
    OBESIDADE("Obesidade", "I"),
    OBESIDADE_2("Obesidade", "II"),
    OBESIDADE_GRAVE("Obesidade Grave", "III")
}