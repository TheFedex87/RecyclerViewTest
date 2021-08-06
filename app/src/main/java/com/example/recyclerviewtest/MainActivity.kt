package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtest.databinding.ActivityMainBinding
import androidx.recyclerview.widget.DividerItemDecoration




class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = Adapter()

        binding.apply {
            recyclerView.apply {
                adapter = this@MainActivity.adapter
                layoutManager = LinearLayoutManager(this@MainActivity)

                val dividerItemDecoration = DividerItemDecoration(
                    recyclerView.context,
                    LinearLayoutManager.VERTICAL
                )
                addItemDecoration(dividerItemDecoration)
            }
            buttonFillList.setOnClickListener {
                fillList()
            }
        }
    }

    private fun fillList() {
        val elements = mutableListOf<ExampleModel>()
        for (i: Int in 1..5000) {
            elements.add(
                ExampleModel(
                    "String A: $i",
                    "String B: $i",
                    mapOf(
                        "SubStringTitle1" to "SubStringValue 1",
                        "SubStringTitle2" to "SubStringValue 2",
                        "SubStringTitle3" to "SubStringValue 3",
                        "SubStringTitle4" to "SubStringValue 4",
                        "SubStringTitle5" to "SubStringValue 5",
                        "SubStringTitle6" to "SubStringValue 6",
                        "SubStringTitle7" to "SubStringValue 7",
                        "SubStringTitle8" to "SubStringValue 8"
                    )
                )
            )
        }

        adapter.setElements(elements)
    }
}