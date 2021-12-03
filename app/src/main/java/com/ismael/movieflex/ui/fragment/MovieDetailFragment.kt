package com.ismael.movieflex.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismael.movieflex.R
import com.ismael.movieflex.databinding.FragmentMovieDetailBinding
import com.ismael.movieflex.utils.Constant
import com.ismael.movieflexcontroller.utils.GsonHandler
import com.ismael.movieflexpersistence.MovieDetailData
import com.squareup.picasso.Picasso

class MovieDetailFragment : Fragment() {
    lateinit var binding: FragmentMovieDetailBinding
    val gson: GsonHandler = GsonHandler()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val data = requireArguments().getString("movie_data")
        val content : MovieDetailData = gson.stringToMovieDetails(data)

        Picasso.get()
            .load(Constant.PREFIX_IMAGE.URL_IMAGE+content.backdrop_path)
            .fit()
            .centerInside()
            .into(binding.imgItem)
        binding.tvTitle.text = content.title
        binding.tvDateValue.text = content.release_date
        binding.tvRateValue.text = "${content.vote_average}/10"
        var genres = ""
        for(genre in content.genres){
            genres += "* " + genre.name + "\n"
        }
        binding.tvGenresValue.text = genres
        binding.tvOverviewValue.text = content.overview

        if(content.belongs_to_collection != null){
            binding.tvBelongsto.visibility = View.VISIBLE
            binding.imgItemBelongs.visibility = View.VISIBLE
            Picasso.get()
                .load(Constant.PREFIX_IMAGE.URL_IMAGE+content.belongs_to_collection!!.poster_path)
                .fit()
                .centerInside()
                .into(binding.imgItemBelongs)
        }else{
            binding.tvBelongsto.visibility = View.GONE
            binding.imgItemBelongs.visibility = View.GONE

        }

        return root
    }


    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}