package com.fshou.burgers

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fshou.burgers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val burgersList = ArrayList<Burger>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        binding.rvBurgers.setHasFixedSize(true)

        getBurgers()
        showRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        when(item.itemId){
            R.id.action_about -> {
                startActivity(aboutIntent)
            }
        }

        return super.onOptionsItemSelected(item)
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
                name = dataName[i].trim(),
                description = dataDesc[i].trim(),
                price = dataPrice[i].trim(),
                image = dataImg[i].trim(),
                rate = dataRate[i].trim(),
                country = dataCountry[i].trim(),
                about = dataAbout[i].trim()
            ))
        }

    }

    private fun showRecyclerView(){
        when(resources.configuration.orientation){
            Configuration.ORIENTATION_LANDSCAPE -> {
                binding.rvBurgers.layoutManager = GridLayoutManager(this,2)

        }
            Configuration.ORIENTATION_PORTRAIT -> {
                binding.rvBurgers.layoutManager = LinearLayoutManager(this)            }
        }

        val listBurgerAdapter = ListBurgerAdapter(burgersList)
        binding.rvBurgers.adapter = listBurgerAdapter

    }
}