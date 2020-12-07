package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMain2Binding

import com.example.recyclerview.model.Animals
import java.io.Serializable


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val animals: Serializable? = intent.getSerializableExtra(EXTRA_MESSAGE)
        setuprRecyclerView2(animals as ArrayList<Animals>)


    }

    private fun setuprRecyclerView2(listilla: MutableList<Animals>) {
        binding.recyclerViewMain2.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain2.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )


            binding.recyclerViewMain2.adapter = RecyclerAdapter(this,
                listilla.filter { it.isDomestic } as MutableList<Animals>)



        }

}

