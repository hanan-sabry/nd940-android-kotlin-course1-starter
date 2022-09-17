package com.udacity.shoestore

import android.os.Bundle
import android.os.TokenWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.addShoeFab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }
        if (!arguments!!.isEmpty) {
            val args = ShoeListFragmentArgs.fromBundle(arguments!!)
            Toast.makeText(
                context,
                "Shoe Item Name ${args.shoeItem.name}, size = ${args.shoeItem.size}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return binding.root
    }
}