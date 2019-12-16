package com.iamidin.dureners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val benefit = intent.getStringExtra(EXTRA_BENEFIT)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail " + name
        }

        val imgView: ImageView = findViewById(R.id.img_fruit)
        Glide.with(this)
            .load(photo)
            .into(imgView)

        val textTitle: TextView = findViewById(R.id.tv_title_fruit)
        textTitle.text = name

        val textDescription: TextView = findViewById(R.id.tv_description_mini)
        textDescription.text = description

        val textBenefit: TextView = findViewById(R.id.tv_benefit)
        textBenefit.text = benefit

        val tvSub: TextView = findViewById((R.id.tv_sub))
        tvSub.text = "Manfaat " + name

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_BENEFIT = "extra_benefit"
    }
}
