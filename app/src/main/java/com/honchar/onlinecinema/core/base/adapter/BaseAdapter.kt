package com.honchar.onlinecinema.core.base.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.honchar.onlinecinema.core.base.presentation.Inflate
import java.util.concurrent.CopyOnWriteArrayList

open class BaseViewBindingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items: CopyOnWriteArrayList<Any> = CopyOnWriteArrayList()

    val entities: MutableMap<Class<*>, Int> = mutableMapOf()

    val itemsTyped: MutableMap<Int, BaseAdapterItemModel<*, out ViewBinding>> = mutableMapOf()

    val itemTypes: ArrayList<Int> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun loadItems(newItems: List<Any>?) {
        items.clear()
        newItems?.let(items::addAll)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadItem(item: Any) {
        items.clear()
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.animation?.start()
    }

    inline fun <reified T : Any> replaceIf(item: T, predicate: (T) -> Boolean): Boolean {
        var isReplace = false
        items.forEachIndexed { index, itemToChange ->
            if (itemToChange is T) {
                if (predicate.invoke(itemToChange)) {
                    items[index] = item
                    isReplace = true
                    notifyItemChanged(index)
                }
            }
        }
        return isReplace
    }

    fun addItem(position: Int? = null, item: Any) {
        position?.let {  if (items.size > it) items.add(it, item) else items.add(item) } ?: items.add(item)
        notifyItemInserted(items.indexOf(item))
    }

    fun addItems(newItems: List<Any>?) {
        newItems?.let(items::addAll)
        notifyItemInserted(items.lastIndex)
    }

    fun remove(item: Any) {
        val index = items.indexOf(item)
        if(items.remove(item)) notifyItemRemoved(index)
    }

    fun itemChanged(item: Any) {
        val index = items.indexOf(item)
        if(-1 != index) notifyItemChanged(index)
    }

    fun getAllItems(): List<Any> = items

    inline fun <reified T : Any> getAllTypedItems() =
        getAllItems().filterIsInstance<T>()

    inline fun <reified T : Any, reified B : ViewBinding> map(noinline inflate: Inflate<B>, holder: Holder<T, B>): BaseViewBindingAdapter {
        val itemType = entities.size
        entities[T::class.java] = itemType
        itemsTyped[itemType] = BaseAdapterItemModel(inflate, holder)
        itemTypes.add(itemType)
        return this
    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = requireNotNull(itemsTyped[viewType]?.inflate?.invoke(LayoutInflater.from(view.context), view, false))
        val holder = RecyclerViewHolder(binding, itemsTyped[viewType]?.holder as? Holder<*, ViewBinding>)
        holder.create(items)
        return holder
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return entities[items[position]::class.java] ?: super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind(holder, items[position])
    }

    inline fun <reified T> bind(holder: RecyclerView.ViewHolder, item: T) {
        (holder as? RecyclerViewHolder<T, out ViewBinding>)?.bind(item)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? RecyclerViewHolder<Any, out ViewBinding>)?.recycle()
    }
}

abstract class Holder<T, B : ViewBinding> {
    abstract fun bind(binding: B, item: T)
    open fun create(binding: B, items: List<Any?>, holder: RecyclerViewHolder<T, B>) = Unit
    open fun recycle() = Unit
}

class RecyclerViewHolder<T, B : ViewBinding>(
    private val viewBinding: B,
    private val holder: Holder<T, B>?
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: T) {
        holder?.bind(viewBinding, item)
    }

    fun recycle() {
        holder?.recycle()
    }

    fun create(items: List<Any?>) {
        holder?.create(viewBinding, items, this)
    }
}

data class BaseAdapterItemModel<T, B : ViewBinding>(
    val inflate: Inflate<B>,
    val holder: Holder<T, B>,
)