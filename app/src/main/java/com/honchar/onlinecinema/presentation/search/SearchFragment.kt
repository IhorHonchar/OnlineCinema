package com.honchar.onlinecinema.presentation.search

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.databinding.FragmentSearchBinding
import com.honchar.onlinecinema.presentation.search.searchFilter.SearchFilterFragment
import com.honchar.onlinecinema.presentation.search.searchQuery.SearchQueryFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(
    R.layout.fragment_search,
    FragmentSearchBinding::inflate
) {

    override val viewModel: SearchViewModel by sharedViewModel()

    private val filter: String?
        get() = arguments?.getString(FILTERS)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpSearch.adapter = SearchPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tbSearch, binding.vpSearch) { tab, position ->
            tab.text = getString(
                if (position == FILTER_PAGE) R.string.search_filter_tab_title
                else R.string.search_query_tab_title
            )
        }.attach()
    }

    private inner class SearchPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = PAGE_COUNT

        override fun createFragment(position: Int): Fragment {
            return if (position == FILTER_PAGE) {
                SearchFilterFragment().apply { arguments = bundleOf(FILTERS to filter) }
            } else {
                SearchQueryFragment()
            }
        }
    }

    companion object {
        const val FILTERS = "filters"
        private const val PAGE_COUNT = 2
        private const val FILTER_PAGE = 0
    }
}