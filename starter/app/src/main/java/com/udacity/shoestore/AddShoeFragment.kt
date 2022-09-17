package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddShoeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        binding.saveButton.setOnClickListener {view: View ->
            view.findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment2(
                Shoe("Shoe Name", 38.toDouble(), "Company", "Description")
            ))
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_shoe_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view?.findNavController()?.popBackStack()
        return super.onOptionsItemSelected(item)
    }
}