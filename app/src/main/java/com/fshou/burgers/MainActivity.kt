package com.fshou.burgers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fshou.burgers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val burgersList = ArrayList<Burger>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBurgers.setHasFixedSize(true)

        getBurgers()
        showRecyclerView()

    }

    private fun getBurgers(){

        val dataName = resources.getStringArray(R.array.data_name)
        val dataImg = resources.getStringArray(R.array.data_img)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataRate = resources.getStringArray(R.array.data_rate)
        val dataCountry  = resources.getStringArray(R.array.data_country)
        val dataAbout = resources.getStringArray(R.array.data_about)



        dataName.forEachIndexed { i, _ ->
            burgersList.add(Burger(
                name = dataName[i],
                description = dataDesc[i],
                price = dataPrice[i],
                image = dataImg[i],
                rate = dataRate[i],
                country = dataCountry[i],
                about = dataAbout[i]
            ))
        }

    }

    private fun showRecyclerView(){
        binding.rvBurgers.layoutManager = LinearLayoutManager(this)
        val listBurgerAdapter = ListBurgerAdapter(burgersList)
        binding.rvBurgers.adapter = listBurgerAdapter

    }
}