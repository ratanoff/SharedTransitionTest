package ru.ratanov.myapplication.adpater

import android.widget.ImageView

interface AnimalItemClickListener {
    fun onAnimalItemClick(imageUrl: String, sharedImage: ImageView)
}