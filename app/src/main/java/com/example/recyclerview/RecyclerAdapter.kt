package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.base.BaseViewHolder
import com.example.recyclerview.model.Animals
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerAdapter(val context: Context, private val animalList: MutableList<Animals>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimalViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is AnimalViewHolder -> holder.bind(animalList[position], position)
            else -> throw IllegalArgumentException("no run")
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    private fun onDelete(pos: Int) {
        animalList.removeAt(pos)
        notifyDataSetChanged()
        // Los Toast mejor en el Activity
        Toast.makeText(context, "Eliminado", Toast.LENGTH_SHORT).show()
    }

    inner class AnimalViewHolder(itemView: View) : BaseViewHolder<Animals>(itemView) {
        override fun bind(item: Animals, position: Int) {

            itemView.setOnClickListener {
                onDelete(position)
            }

            itemView.txt_name_animal.text = item.name
            Glide.with(context).load(item.image).into(itemView.profile_image)

            if (item.isDomestic) {
                itemView.txt_is_visible.text = context.getString(R.string.domestico)
            } else {
                itemView.txt_is_visible.text = context.getString(R.string.no_domestico)
            }
        }
    }
}


