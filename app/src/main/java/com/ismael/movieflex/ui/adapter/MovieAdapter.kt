package com.ismael.movieflex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.movieflex.databinding.ItemMovieListBinding
import com.ismael.movieflex.utils.Constant
import com.ismael.movieflexpersistence.entity.movie.MovieResult

import com.squareup.picasso.Picasso

class MovieAdapter(val data: ArrayList<MovieResult>,
                     val onActionListener: OnActionListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private var binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(content: MovieResult) {
            Picasso.get()
                .load(Constant.PREFIX_IMAGE.URL_IMAGE+content.poster_path)
                .fit()
                .centerInside()
                .into(binding.imgMovies)

            binding.cvItemList.setOnClickListener{
                onActionListener.onMovieSelected(content, "movie")
            }
        }
    }


    interface OnActionListener{
        fun onMovieSelected(content: MovieResult, source: String?)
    }
}