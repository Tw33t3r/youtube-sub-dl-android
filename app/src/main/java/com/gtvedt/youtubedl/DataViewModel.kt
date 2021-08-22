package com.gtvedt.youtubedl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel(){
    private val subs: MutableLiveData<ArrayList<Sub>> by lazy {
        MutableLiveData<ArrayList<Sub>>()
    }

    fun setSubs(subList: ArrayList<Sub>){
        subs.value = subList
    }

    fun getSubscriptions(): MutableLiveData<ArrayList<Sub>>{
        return subs
    }

}