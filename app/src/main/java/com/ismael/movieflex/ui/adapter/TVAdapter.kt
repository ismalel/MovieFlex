package com.ismael.movieflex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.movieflex.databinding.ItemMovieListBinding
import com.ismael.movieflex.utils.Constant
import com.ismael.movieflexpersistence.entity.tv.TVResult

import com.squareup.picasso.Picasso

class TVAdapter(val data: ArrayList<TVResult>,
                val onActionListener: OnActionListener) : RecyclerView.Adapter<TVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVAdapter.ViewHolder {
        val binding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private var binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(content: TVResult) {
            Picasso.get()
                .load(Constant.PREFIX_IMAGE.URL_IMAGE+content.poster_path)
                .fit()
                .centerInside()
                .into(binding.imgMovies)

            binding.cvItemList.setOnClickListener{
                onActionListener.onTVSelected(content, "tv")
            }
        }
    }


    interface OnActionListener{
        fun onTVSelected(content: TVResult, source: String?)
    }
}