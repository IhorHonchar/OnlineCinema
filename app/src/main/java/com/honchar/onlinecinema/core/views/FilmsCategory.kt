package com.honchar.onlinecinema.core.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.honchar.onlinecinema.databinding.ViewFilmsCategoryBinding

class FilmsCategory @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
): LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: ViewFilmsCategoryBinding =
        ViewFilmsCategoryBinding.inflate(LayoutInflater.from(context), this, true)


}