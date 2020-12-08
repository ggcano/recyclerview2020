package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        setupRecyclerView2(animals as ArrayList<Animals>)

        val toolbar = binding.toolbarMain2.toolbar
        setSupportActionBar(toolbar)


        //actionbar
        setSupportActionBar(toolbar).apply {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.title = getString(R.string.domestic_animals)
        }

    }

    private fun setupRecyclerView2(list: MutableList<Animals>) {
        binding.recyclerViewMain2.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain2.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        //Filtrado animales domesticos
            binding.recyclerViewMain2.adapter = RecyclerAdapter(this,
                list.filter { it.isDomestic } as MutableList<Animals>)
        }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

