package com.ismael.movieflex.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ismael.movieflex.R
import com.ismael.movieflex.databinding.ActivityDetailViewBinding
import com.ismael.movieflex.ui.fragment.MovieDetailFragment
import com.ismael.movieflex.ui.fragment.TVDetailFragment
import com.ismael.movieflex.utils.Constant
import com.ismael.movieflexcontroller.detail.DetailContract
import com.ismael.movieflexcontroller.detail.DetailPresenter
import com.ismael.movieflexcontroller.utils.GsonHandler
import com.ismael.movieflexpersistence.MovieDetailData
import com.ismael.movieflexpersistence.entity.tv.detail.TVDetailData
import com.squareup.picasso.Picasso

class DetailView : AppCompatActivity() , DetailContract.View{
    lateinit var binding: ActivityDetailViewBinding
    lateinit var presenter: DetailContract.Presenter
    val movieDetailFragment: Fragment = MovieDetailFragment.newInstance()
    val tvDetailFragment: Fragment = TVDetailFragment.newInstance()
    val gson : GsonHandler = GsonHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = DetailPresenter(this,this)
       presenter.initItemData(intent.extras!!.getInt("id"),intent.extras!!.getString("source"))



    }

    override fun onClosedActivity() {
        finish()
    }

    override fun onShowMovieDetail(content: MovieDetailData) {
        val data = gson.movieDetailsToString(content)
        val bundle = Bundle()
        bundle.putString("movie_data", data)

        movieDetailFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieDetailFragment)
            .commit()
    }

    override fun onShowTVDetail(content: TVDetailData) {
        val data = gson.tvDetailsToString(content)
        val bundle = Bundle()
        bundle.putString("tv_data", data)

        tvDetailFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, tvDetailFragment)
            .commit()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}