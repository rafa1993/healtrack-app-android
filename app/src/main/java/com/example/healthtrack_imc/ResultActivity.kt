package com.example.healthtrack_imc

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {

    companion object{
        const val IMC_RESULT = "imc"
        const val IMC_CLASSIFICATION = "classification"
        const val IMC_OBESITY = "obesity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val result = intent.getDoubleExtra(IMC_RESULT, -1.0)
        val classification = intent.getStringExtra(IMC_CLASSIFICATION)
        val obesity = intent.getStringExtra(IMC_OBESITY)

        val txtResult = findViewById<TextView>(R.id.txtResult)

        txtResult.text = "IMC: ${"%.2f".format(result)} \nCLASSIFICAÇÃO: $classification \nGRAU DE OBESIDADE: $obesity"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}