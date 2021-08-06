package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var elements: List<ExampleModel> = listOf()

    fun setElements(elements: List<ExampleModel>) {
        this.elements = elements
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(elements[position])
    }

    override fun getItemCount(): Int = elements.size

    inner class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ExampleModel) {
            binding.apply {
                textViewString1.text = model.string1
                textViewString2.text = model.string2

                textViewSubString1.text = model.map["SubStringTitle1"]
                textViewSubString2.text = model.map["SubStringTitle2"]
                textViewSubString3.text = model.map["SubStringTitle3"]
                textViewSubString4.text = model.map["SubStringTitle4"]
            }
        }
    }
}