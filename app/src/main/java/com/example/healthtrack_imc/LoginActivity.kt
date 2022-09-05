package com.example.healthtrack_imc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.healthtrack_imc.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var binding: LoginActivityBinding
        private lateinit var viewModel: LoginViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = LoginActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)

            viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

            binding.buttonLogin.setOnClickListener(this)

            createObservers()
        }

        override fun onClick(v: View?) {
          val name = binding.editName.text.toString()
          viewModel.doLogin(name)
            binding.buttonLogin.setOnClickListener{
               val back = Intent(this, IMCActivity::class.java)
                startActivity(back)
            }
        }

        private fun createObservers() {
            viewModel.welcome().observe(this, Observer {
                binding.textWelcome
            })
            viewModel.login().observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
        }
    }