package com.fshou.burgers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fshou.burgers.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BURGER = "Burger"
    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()


        val burger = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_BURGER, Burger::class.java)
        } else {
            intent.getParcelableExtra<Burger>(EXTRA_BURGER)
        }

        val formattedPrice = "\$${burger?.price}"
        val formattedRate = "${burger?.rate}/5"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, burger?.image)
            putExtra(Intent.EXTRA_TITLE, burger?.name)
            type = "text/plain"

        }
        val shareIntent = Intent.createChooser(sendIntent, null)

        binding.apply {
            tvName.text = burger?.name
            tvCountry.text = burger?.country
            tvPrice.text = formattedPrice
            tvRate.text = formattedRate
            tvAbout.text = burger?.about

            actionShare.setOnClickListener {
                startActivity(shareIntent)
            }
            tvBack.setOnClickListener {
                finish()
            }
        }

        Glide
            .with(this)
            .load(burger?.image)
            .into(binding.imgBurger)


        setContentView(binding.root)
    }
}