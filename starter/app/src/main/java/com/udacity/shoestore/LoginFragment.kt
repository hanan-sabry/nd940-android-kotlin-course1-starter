package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.newLoginButton.setOnClickListener{view: View ->
            run {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomFragment)
            }
        }
        binding.exitAccountLoginButton.setOnClickListener{view: View ->
            run {
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomFragment)
            }
        }
        return binding.root
    }

}