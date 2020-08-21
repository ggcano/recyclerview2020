package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.Animals
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setuprRecyclerView()
    }

    private fun setuprRecyclerView() {
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        val listAnimals = listOf(
            Animals(
                "Perro",
                "https://dam.ngenespanol.com/wp-content/uploads/2019/06/mirada-perros.png",
                true
            ),
            Animals(
                "gato",
                "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/59c4f5655bafe82c692a7052/gato-marron_0.jpg",
                true
            ),
            Animals(
                "Rinoceronte",
                "https://www.lavanguardia.com/r/GODO/LV/p7/WebSite/2020/03/20/Recortada/img_emartinezb_20200320-175132_imagenes_lv_terceros_uicn-rino_negro_2-krh-U474275244584CBF-992x558@LaVanguardia-Web.jpg",
                false
            ), Animals(
                "Tigre",
                "https://vignette.wikia.nocookie.net/reinoanimalia/images/5/58/Tigre_de_bengala_wiki.png/revision/latest?cb=20130303105615&path-prefix=es",
                false
            ), Animals(
                "Cobaya",
                "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/595112135bafe8e5023c98f0/cobaya-cesped_0.jpg",
                true
            ))
            my_recycler_view.adapter = RecyclerAdapter (this,listAnimals)

    }
}