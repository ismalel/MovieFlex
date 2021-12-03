package com.ismael.movieflex.ui.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismael.movieflex.databinding.ActivityMainViewBinding
import com.ismael.movieflex.ui.activity.detail.DetailView
import com.ismael.movieflex.ui.adapter.MovieAdapter
import com.ismael.movieflex.ui.adapter.TVAdapter
import com.ismael.movieflexcontroller.main.MainContract
import com.ismael.movieflexcontroller.main.MainPresenter
import com.ismael.movieflexpersistence.entity.movie.MovieResult
import com.ismael.movieflexpersistence.entity.tv.TVResult

class MainView : AppCompatActivity(), MainContract.View, MovieAdapter.OnActionListener, TVAdapter.OnActionListener {
    lateinit var binding: ActivityMainViewBinding
    lateinit var presenter: MainContract.Presenter
    var llmHorizontal: LinearLayoutManager? = null
    var llmHorizontal2: LinearLayoutManager? = null
    var llmHorizontal3: LinearLayoutManager? = null
    var llmHorizontal4: LinearLayoutManager? = null
    var llmHorizontal5: LinearLayoutManager? = null
    var llmHorizontal6: LinearLayoutManager? = null
    var status : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llmHorizontal = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        llmHorizontal3 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        llmHorizontal2 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        llmHorizontal4 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        llmHorizontal5 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        llmHorizontal6 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)


        presenter = MainPresenter(this,this)
        presenter.onGetData()

    }
    override fun showMoviePopularList(content: ArrayList<MovieResult>) {
        binding.rvPopularMovie.layoutManager = llmHorizontal
        binding.rvPopularMovie.adapter = MovieAdapter(content, this)
    }

    override fun showMoviePopularListOffline(content: ArrayList<MovieResult>) {
        binding.rvPopularMovie.layoutManager = llmHorizontal
        binding.rvPopularMovie.adapter = MovieAdapter(content, this)
    }

    override fun showMovieRatedList(content: ArrayList<MovieResult>) {
        binding.rvRatedMovie.layoutManager = llmHorizontal2
        binding.rvRatedMovie.adapter = MovieAdapter(content, this)
    }

    override fun showMovieRatedListOffline(content: ArrayList<MovieResult>) {
        binding.rvRatedMovie.layoutManager = llmHorizontal2
        binding.rvRatedMovie.adapter = MovieAdapter(content, this)
    }

    override fun showMovieRecommendedList(content: ArrayList<MovieResult>) {
        binding.rvRecommendedMovie.layoutManager = llmHorizontal3
        binding.rvRecommendedMovie.adapter = MovieAdapter(content, this)
    }

    override fun showMovieRecommendedListOffline(content: ArrayList<MovieResult>) {
        binding.rvRecommendedMovie.layoutManager = llmHorizontal3
        binding.rvRecommendedMovie.adapter = MovieAdapter(content, this)
    }

    override fun showTVPopularList(content: ArrayList<TVResult>) {
        binding.rvPopularTV.layoutManager = llmHorizontal4
        binding.rvPopularTV.adapter = TVAdapter(content, this)
    }

    override fun showTVPopularListOffline(content: ArrayList<TVResult>) {
        binding.rvPopularTV.layoutManager = llmHorizontal4
        binding.rvPopularTV.adapter = TVAdapter(content, this)
    }

    override fun showTVRatedList(content: ArrayList<TVResult>) {
        binding.rvRatedTV.layoutManager = llmHorizontal5
        binding.rvRatedTV.adapter = TVAdapter(content, this)
    }

    override fun showTVRatedListOffline(content: ArrayList<TVResult>) {
        binding.rvRatedTV.layoutManager = llmHorizontal5
        binding.rvRatedTV.adapter = TVAdapter(content, this)
    }

    override fun showTVRecommendedList(content: ArrayList<TVResult>) {
        binding.rvRecommendedTV.layoutManager = llmHorizontal6
        binding.rvRecommendedTV.adapter = TVAdapter(content, this)
    }

    override fun showTVRecommendedListOffline(content: ArrayList<TVResult>) {
        binding.rvRecommendedTV.layoutManager = llmHorizontal6
        binding.rvRecommendedTV.adapter = TVAdapter(content, this)
    }

    override fun connectionStatus(status: Boolean) {
        this.status = status
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onMovieSelected(content: MovieResult, source: String?) {
        if(status){
            val intent = Intent(this, DetailView::class.java)
            intent.putExtra("id", content.id)
            intent.putExtra("source", source)
            startActivity(intent)
        }else{
            showMessage("This feature is not avaiable offline")
        }

    }

    override fun onTVSelected(content: TVResult, source: String?) {
        if(status){
            val intent = Intent(this, DetailView::class.java)
            intent.putExtra("id", content.id)
            intent.putExtra("source", source)
            startActivity(intent)
        }else{
            showMessage("This feature is not avaiable offline")
        }
    }
}