package com.honchar.onlinecinema.core.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T: Any> Fragment.observeData(liveData: LiveData<T>, block: (T) -> Unit){
    liveData.observe(viewLifecycleOwner){
        block.invoke(it)
    }
}