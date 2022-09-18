package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoesSharedViewModel

class AddShoeFragment : Fragment() {

    private val shoeSharedViewModel: ShoesSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentAddShoeBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        setHasOptionsMenu(true)
        binding.sharedViewModel = shoeSharedViewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {view: View ->
            shoeSharedViewModel.addNewShoe()
            view.findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment2())
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