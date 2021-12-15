package com.geekbrains.dictionary.view

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.geekbrains.dictionary.Constants
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityDetailBinding
import com.geekbrains.dictionary.model.data.DataModel


class DetailActivity: Activity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DataModel>(Constants.DATA_MODEL_BUNDLE_KEY)
        if (data?.meanings != null) {
            data.meanings.forEach {
                val image = ImageView(this)
                Glide.with(this)
                    .load("https:${it.imageUrl}")
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .apply(RequestOptions().override(400, 400))
                    .into(image)
                val translation = TextView(this).apply {
                    text = it.translation?.translation
                    textSize = 20f
                }
                val element = LinearLayout(this).apply {
                    orientation = LinearLayout.HORIZONTAL
                    addView(image)
                    addView(translation)
                }
                val delimeter = View(this).apply {
                    setBackgroundColor(resources.getColor(R.color.black))
                    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
                }
                binding.container.addView(element)
                binding.container.addView(delimeter)
            }
        }
    }
}