package com.ismael.movieflex.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismael.movieflex.R
import com.ismael.movieflex.databinding.FragmentTVDetailBinding
import com.ismael.movieflex.utils.Constant
import com.ismael.movieflexcontroller.utils.GsonHandler
import com.ismael.movieflexpersistence.entity.tv.detail.TVDetailData
import com.squareup.picasso.Picasso

class TVDetailFragment : Fragment() {
    lateinit var binding: FragmentTVDetailBinding
    val gson: GsonHandler = GsonHandler()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTVDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val data = requireArguments().getString("tv_data")
        val content : TVDetailData = gson.stringToTVDetails(data)

        Picasso.get()
            .load(Constant.PREFIX_IMAGE.URL_IMAGE+content.backdrop_path)
            .fit()
            .centerInside()
            .into(binding.imgItem)
        binding.tvTitle.text = content.name
        binding.tvEpisodesValue.text = content.episode_run_time.toString()
        binding.tvDateValue.text = content.first_air_date
        binding.tvRateValue.text = "${content.vote_average}/10"
        var genres = ""
        for(genre in content.genres){
            genres += "* " + genre.name + "\n"
        }
        binding.tvGenresValue.text = genres
        binding.tvOverviewValue.text = content.overview
        return root
    }

    companion object {
        fun newInstance() = TVDetailFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}