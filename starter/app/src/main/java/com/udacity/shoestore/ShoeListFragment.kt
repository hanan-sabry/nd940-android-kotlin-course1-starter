package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoesSharedViewModel
import kotlinx.android.synthetic.main.shoe_item_layout.view.*

class ShoeListFragment : Fragment() {

    private val shoeSharedViewModel: ShoesSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        binding.addShoeFab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }

        binding.sharedViewModel = shoeSharedViewModel
        binding.lifecycleOwner = this

        shoeSharedViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe: Shoe in shoeList) {
                val shoeItemViewInflater = LayoutInflater.from(context).inflate(R.layout.shoe_item_layout, null)
                shoeItemViewInflater.shoe_name_value.text = shoe.name
                shoeItemViewInflater.company_value.text = shoe.company
                shoeItemViewInflater.size_value.text = shoe.size.toString()
                shoeItemViewInflater.desc_value.text = shoe.description
                val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                layoutParams.bottomMargin = 24
                binding.shoesListLayout.addView(shoeItemViewInflater, binding.shoesListLayout.childCount, layoutParams)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoes_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            view?.findNavController()?.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}