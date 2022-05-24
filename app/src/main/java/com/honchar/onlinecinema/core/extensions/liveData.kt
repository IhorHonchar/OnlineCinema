package com.honchar.onlinecinema.core.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData

fun <T: Any> Fragment.observeData(liveData: LiveData<T>, block: (T) -> Unit){
    liveData.observe(viewLifecycleOwner){
        block.invoke(it)
    }
}

fun <T: Any> FragmentActivity.observeData(liveData: LiveData<T>, block: (T) -> Unit){
    liveData.observe(this){
        block.invoke(it)
    }
}