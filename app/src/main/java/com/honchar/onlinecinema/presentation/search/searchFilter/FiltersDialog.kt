package com.honchar.onlinecinema.presentation.search.searchFilter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.gone
import com.honchar.onlinecinema.databinding.DialogFiltersBinding
import com.honchar.onlinecinema.databinding.FilterItemAddBinding
import com.honchar.onlinecinema.databinding.FilterItemBinding
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel

class FiltersDialog(private val onSelected: (CategoryModel) -> Unit): BottomSheetDialogFragment() {

    private lateinit var binding: DialogFiltersBinding

    private val adapter = BaseViewBindingAdapter()
        .map(
            FilterItemAddBinding::inflate,
            FilterHolder{
                onSelected.invoke(it)
                dismiss()
            }
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFiltersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFilters.adapter = adapter
        adapter.loadItems(FilmsFactory.getCategories())
    }


    private inner class FilterHolder(private val onClick: (CategoryModel) -> Unit) : Holder<CategoryModel, FilterItemAddBinding>() {

        override fun bind(binding: FilterItemAddBinding, item: CategoryModel) {
            binding.tvFilterName.text = binding.root.context.getString(item.name)
            binding.root.setOnClickListener { onClick.invoke(item) }
        }

    }

}