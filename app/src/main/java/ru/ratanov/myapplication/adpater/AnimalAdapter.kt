package ru.ratanov.myapplication.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.ratanov.myapplication.entity.AnimalItem
import ru.ratanov.myapplication.R

class AnimalAdapter(
    private val animalItems: ArrayList<AnimalItem>,
    private val animalItemClickListener: AnimalItemClickListener
) : RecyclerView.Adapter<AnimalAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_animal_square, parent, false)
        )


    override fun getItemCount() = animalItems.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val animalItem = animalItems[position]

        Picasso.get()
            .load(animalItem.imageUrl)
            .into(holder.animalImageView)

        ViewCompat.setTransitionName(holder.animalImageView, animalItem.name)

        holder.itemView.setOnClickListener {
            animalItemClickListener.onAnimalItemClick(animalItem.imageUrl, holder.animalImageView)
        }
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalImageView: ImageView = itemView.findViewById<View>(R.id.item_animal_square_image) as ImageView
    }
}