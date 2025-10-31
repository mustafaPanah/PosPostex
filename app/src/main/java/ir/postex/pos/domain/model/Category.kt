package ir.postex.pos.domain.model

import ir.postex.pos.R

data class Category(
    val title: String,
    val description: String,
    val image: Int = R.drawable.media
)
