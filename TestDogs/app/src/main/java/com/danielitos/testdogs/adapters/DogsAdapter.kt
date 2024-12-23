package com.danielitos.testdogs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danielitos.testdogs.R
import com.danielitos.testdogs.databinding.CellListBinding
import com.danielitos.testdogs.domain.models.Dog


/**
 * Created by danielsanchez on 20/12/24
 */


class DogsAdapter(private var dogList: List<Dog>) : RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    lateinit var binding: CellListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CellListBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogList.get(position))
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    fun updateItems(newList: List<Dog> ){
        dogList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: CellListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: Dog){
            binding.apply {
                tvTitle.text = dog.dogName
                tvDesc.text = dog.description
                tvNote.text = root.resources.getString(R.string.label_age, dog.age)

                Glide.with(binding.root)
                    .load(dog.image)
                    /*.apply(
                        RequestOptions()
                            .placeholder(R.drawable.placeholder_image)
                            .error(R.drawable.error_image)
                    )*/
                    .into(ivPic)
            }
        }
    }
}