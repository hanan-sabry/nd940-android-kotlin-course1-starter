package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesSharedViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addNewShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        var size1 = shoeList.value?.size
        var size2 = _shoeList.value?.size
        var d = 5
    }
}