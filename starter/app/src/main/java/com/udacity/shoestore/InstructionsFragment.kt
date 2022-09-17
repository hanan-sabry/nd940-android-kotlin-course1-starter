package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding =
            FragmentInstructionsBinding.inflate(inflater, container, false)
        binding.startNowButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}