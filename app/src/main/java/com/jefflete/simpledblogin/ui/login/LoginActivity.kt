package com.jefflete.simpledblogin.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jefflete.simpledblogin.data.local.entity.Accounts
import com.jefflete.simpledblogin.databinding.ActivityLoginBinding
import com.jefflete.simpledblogin.ui.HomeActivity
import com.jefflete.simpledblogin.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    // viewmodel
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            viewModel.login(
                Accounts(
                    binding.usernameEditText.text.toString(),
                    binding.passwordEditText.text.toString()
                )
            )
        }

        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        viewModel.account.observe(this) {
            Log.d("LoginActivity", "username: ${it?.username} password: ${it?.password}")
            if (it != null) {
                if (binding.passwordEditText.text.toString() == it.password) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    binding.passwordEditText.error = "Password is incorrect"
                }
            } else {
                binding.usernameEditText.error = "Username not found"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}