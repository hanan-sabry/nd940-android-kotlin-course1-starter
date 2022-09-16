package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.getStartedButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomFragment_to_instructionsFragment)
        }
        return binding.root
    }

}