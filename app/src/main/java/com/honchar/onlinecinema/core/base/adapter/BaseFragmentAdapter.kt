package com.honchar.onlinecinema.core.base.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.lang.ref.WeakReference
import java.util.concurrent.CopyOnWriteArrayList

class BaseFragmentAdapter(
    private val fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    fragmentInfoContainers: List<FragmentInfoContainer>,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragment = hashMapOf<Int, WeakReference<Fragment>>()
    private val items: CopyOnWriteArrayList<FragmentInfoContainer> = CopyOnWriteArrayList(fragmentInfoContainers)
    private val pageIds = items.map { it.hashCode().toLong() }

    override fun getItemCount() = items.size

    override fun createFragment(position: Int): Fragment {
        val fragmentInfoContainer = items[position]
        return fragmentManager.fragmentFactory
            .instantiate(ClassLoader.getSystemClassLoader(), fragmentInfoContainer.fragmentClass.name)
            .apply {
                arguments = fragmentInfoContainer.args
                fragment[position] = WeakReference(this)
            }
    }

    override fun getItemId(position: Int): Long {
        return items[position].hashCode().toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return pageIds.contains(itemId)
    }

    fun itemsLoaded(infoContainers: List<FragmentInfoContainer>) {
        fragment.clear()
        items.clear()
        items.addAll(infoContainers)
        notifyDataSetChanged()
    }

    fun getFragments() = fragment.values

    fun getFragment(position: Int) = fragment[position]?.get()

    class FragmentInfoContainer(
        val fragmentClass: Class<out Fragment>,
        val args: Bundle = Bundle.EMPTY,
    )
}