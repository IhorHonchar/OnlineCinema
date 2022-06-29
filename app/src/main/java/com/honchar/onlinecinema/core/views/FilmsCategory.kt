package com.honchar.onlinecinema.core.views

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.safeLet
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.databinding.ViewFilmsCategoryBinding
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.databinding.ViewFilmsMoreItemBinding
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import kotlinx.android.parcel.Parcelize

class FilmsCategory @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding = ViewFilmsCategoryBinding.inflate(LayoutInflater.from(context), this, true)

    private var clickListener: FilmCategoryClickListener? = null
    private var filmCategory: FilmCategory? = null

    private val adapter = BaseViewBindingAdapter()
        .map(
            ViewFilmsItemBinding::inflate,
            FilmHolder()
        )
        .map(
            ViewFilmsMoreItemBinding::inflate,
            MoreHolder()
        )

    init {
        initView()
        initListeners()
    }

    fun loadFilmCategory(filmCategory: FilmCategory) {
        this.filmCategory = filmCategory
        initView()
    }

    fun setListener(clickListener: FilmCategoryClickListener) {
        this.clickListener = clickListener
    }

    private fun initView() {
        if (binding.rvFilms.adapter == null)
            binding.rvFilms.adapter = adapter

        filmCategory?.let {
            binding.tvCategoryTitle.text = it.filmCategoryTitle
            val filmsList: MutableList<Any> = it.films.toMutableList()
            filmsList.add(Unit)
            adapter.loadItems(filmsList)
        }
    }

    private fun initListeners() {
        binding.tvSeeAll.setClickListener(::onAllSeeClick)
    }

    private fun onAllSeeClick(){
        safeLet(clickListener, filmCategory) { listener, category ->
            listener.onSeeAllClick(category)
        }
    }

    @Parcelize
    data class Film(
        val filmId: String = "",
        val filmName: String,
        val filmPoster: String,
        val filmRate: String,
        val desc: String,
        val videoUrl: String = "https://www.nusenglish.com/wp-content/uploads/2022/05/videoplayback.mp4",
        var isLike: Boolean = false,
        var isLater: Boolean = false,
        val actors: List<ActorModel>,
        val categories: List<CategoryModel>,
        @DrawableRes val placeholder: Int = R.drawable.ic_launcher_foreground
    ): Parcelable

    data class FilmCategory(
        val filmCategoryTitle: String,
        val films: List<Film>
    )

    interface FilmCategoryClickListener {
        fun onFilmClick(film: Film)
        fun onSeeAllClick(filmCategory: FilmCategory)
    }

    private inner class FilmHolder : Holder<Film, ViewFilmsItemBinding>() {

        override fun bind(binding: ViewFilmsItemBinding, item: Film) {
            binding.ivFilmPreview.loadImage(item.filmPoster, item.placeholder)
            binding.tvFilmName.text = item.filmName
            binding.tvFilmRate.text = item.filmRate
            binding.root.setOnClickListener {
                clickListener?.onFilmClick(item)
            }
        }
    }

    private inner class MoreHolder: Holder<Unit, ViewFilmsMoreItemBinding>(){
        override fun bind(binding: ViewFilmsMoreItemBinding, item: Unit) {
            binding.root.setClickListener(::onAllSeeClick)
        }

    }

}