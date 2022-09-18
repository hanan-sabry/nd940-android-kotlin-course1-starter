package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesSharedViewModel : ViewModel() {

    var shoe: Shoe = Shoe()
    private var _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addNewShoe() {
        _shoeList.value?.add(shoe)
        shoe = Shoe()
    }
}