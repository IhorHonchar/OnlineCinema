package com.honchar.onlinecinema.core.base.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.honchar.onlinecinema.core.navigation.NavigationHandler

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding>(
    @LayoutRes
    protected val layoutId: Int,
    private val inflate: Inflate<B>
) : Fragment(layoutId) {

    protected abstract val viewModel: BaseViewModel

    private var _binding: B? = null
    val binding: B
        get() = _binding!!

    protected var navigationHandler: NavigationHandler? = null

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationHandler = context as? NavigationHandler
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeData()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    open fun initViews() = Unit
    open fun subscribeData() = Unit

}