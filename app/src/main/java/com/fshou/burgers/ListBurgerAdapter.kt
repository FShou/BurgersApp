package com.fshou.burgers

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.fshou.burgers.databinding.ItemLayoutBinding

class ListBurgerAdapter(private val listBurger: ArrayList<Burger>) :
    RecyclerView.Adapter<ListBurgerAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemLayoutBinding) : ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ListViewHolder(binding)
    }

    override fun getItemCount() = listBurger.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (
            name,
            description,
            price,
            rate,
            image,
            country,
        ) = listBurger[position]

        val formattedPrice = "\$$price"
        val formattedRate = "($rate)"


        holder.binding.apply {
            tvName.text = name
            tvPrice.text = formattedPrice
            tvCountry.text = country
            tvDesc.text = description
            tvRate.text = formattedRate
        }
        Glide
            .with(holder.itemView.context)
            .load(image)
            .into(holder.binding.imgBurger)

        val detailIntent = Intent(holder.itemView.context, DetailActivity::class.java)

        detailIntent.putExtra(DetailActivity.EXTRA_BURGER, listBurger[holder.adapterPosition])

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(detailIntent)
        }
    }
}