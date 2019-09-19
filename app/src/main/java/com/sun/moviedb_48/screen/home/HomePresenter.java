package com.sun.moviedb_48.screen.home;

import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.repository.MovieRepository;
import com.sun.moviedb_48.data.source.remote.OnFetchDataJsonListener;
import com.sun.moviedb_48.utils.Categories;
import java.util.ArrayList;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private MovieRepository mMovieRepository;

    HomePresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Override
    public void getMoviesByCategories(Categories category) {
        mMovieRepository.getMovieByCategories(category, new OnFetchDataJsonListener<Movie>() {
            @Override
            public void onSuccess(ArrayList<Movie> data) {
                mView.onGetMovieByCategoriesSuccess(data);
            }

            @Override
            public void onError(Exception e) {
                mView.onGetMovieByCategoriesError(e);
            }
        });
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }
}
