package com.example.offlinecaching_cif.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.offlinecaching_cif.data.Restaurant
import com.example.offlinecaching_cif.databinding.RestaurantLayoutBinding
import kotlinx.coroutines.withContext

class RestaurantAdapter (
//    private val listener: ClickListener
) : RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding: RestaurantLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.binding.apply {

            textView.text = currentItem?.name

            Glide.with(holder.itemView)
                .load(currentItem.logo)
                .into(imageView)
//
//            val imageLink = currentItem?.logo
//
//            imageView.load(imageLink)
////            {
////                crossfade(true)
////                crossfade(1000)
////
////            }

        }

//        holder.itemView.setOnClickListener {
//            listener.onMyItemClick(currentItem)
//        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RestaurantLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = differ.currentList.size

    interface ClickListener {
        // item on click listener
        fun onMyItemClick(restaurant: Restaurant)
    }

}