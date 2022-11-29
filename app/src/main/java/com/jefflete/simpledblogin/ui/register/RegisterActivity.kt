package com.jefflete.simpledblogin.ui.register

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jefflete.simpledblogin.data.local.entity.Accounts
import com.jefflete.simpledblogin.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            // TODO: Fix if constraint primary key username already exist!
            try {
                viewModel.register(
                    Accounts(
                        binding.usernameEditText.text.toString(),
                        binding.passwordEditText.text.toString()
                    )
                )
            } catch (
                e: SQLiteConstraintException
            ) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}