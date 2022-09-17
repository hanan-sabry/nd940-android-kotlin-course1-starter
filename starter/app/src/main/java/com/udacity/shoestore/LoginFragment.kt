package com.udacity.shoestore

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.newLoginButton.setOnClickListener { view: View ->
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            navigateToWelcomeScreen(email, password, view)
        }
        binding.exitAccountLoginButton.setOnClickListener { view: View ->
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            navigateToWelcomeScreen(email, password, view)
        }
        return binding.root
    }

    private fun validateEmailAndPassword(email: String, password: String): Boolean {
        val validEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return when {
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(context, "You must enter email and password!!", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            !validEmail -> {
                Toast.makeText(context, "Not valid email address!!", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun navigateToWelcomeScreen(email: String, password: String, view: View) {
        if (validateEmailAndPassword(email, password)) {
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomFragment)
        }
    }
}