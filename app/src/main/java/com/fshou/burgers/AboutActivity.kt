package com.fshou.burgers



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class AboutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_about)

        val imgProfile: ImageView = findViewById(R.id.img_profile)
        val tvBack:TextView = findViewById(R.id.tv_back)
        Glide
            .with(this)
            .load(R.drawable.profile)
            .circleCrop()
            .into(imgProfile)

       tvBack.setOnClickListener {
            finish()
        }
    }
}