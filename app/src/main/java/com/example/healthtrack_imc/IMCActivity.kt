package com.example.healthtrack_imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class IMCActivity : AppCompatActivity() {

    private var txtHeight: TextView? = null
    private var txtWeight: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Intent(this, LoginActivity::class.java)

        setContentView(R.layout.activity_imc)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)

        this.txtHeight = findViewById(R.id.txtHeight)
        this.txtWeight = findViewById(R.id.txtWeight)

        btnCalculate.setOnClickListener {
            val height = txtHeight?.text.toString()
            val weight = txtWeight?.text.toString()

            if (height.isEmpty() || weight.isEmpty()) {
                Toast.makeText(this, "Fill correctly the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //IMC
            val imc = IMC(height.toDouble(), weight.toDouble())

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ResultActivity.IMC_RESULT, imc.result)
            intent.putExtra(ResultActivity.IMC_CLASSIFICATION, imc.classification)
            intent.putExtra(ResultActivity.IMC_OBESITY, imc.obesity)
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            txtHeight?.text = ""
            txtWeight?.text = ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence("HEIGHT", this.txtHeight?.text)
        outState.putCharSequence("WEIGHT", this.txtWeight?.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.txtHeight?.text = savedInstanceState.getCharSequence("HEIGHT")
        this.txtWeight?.text = savedInstanceState.getCharSequence("WEIGHT")
    }
}