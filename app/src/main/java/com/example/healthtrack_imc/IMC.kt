package com.example.healthtrack_imc

import kotlin.math.pow

class IMC(var height: Double, var weight: Double) {

    var result: Double = 0.00
    var classification: String = ""
    var obesity: String = ""

    init {
        this.calculate()
        this.setClassificationAndObesity()
    }

    fun calculate() {
        this.result = weight / height.pow(2.0)
    }

    fun setClassificationAndObesity() {
        if (result < 18.5) {
            classification = Classification.MAGREZA.classification
            obesity = Classification.MAGREZA.obesity

        } else if (result > 18.5 && result <= 24.9) {
            classification = Classification.NORMAL.classification
            obesity = Classification.NORMAL.obesity

        } else if (result > 24.9 && result <= 29.9) {
            classification = Classification.SOBREPESO.classification
            obesity = Classification.SOBREPESO.obesity

        } else if (result > 29.9 && result <= 34.9) {
            classification = Classification.OBESIDADE.classification
            obesity = Classification.OBESIDADE.obesity

        } else if (result > 34.9 && result <= 39.9) {
            classification = Classification.OBESIDADE_2.classification
            obesity = Classification.OBESIDADE_2.obesity

        } else {
            classification = Classification.OBESIDADE_GRAVE.classification
            obesity = Classification.OBESIDADE_GRAVE.obesity
        }
    }
}