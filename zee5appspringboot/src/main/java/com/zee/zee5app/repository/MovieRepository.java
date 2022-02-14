package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	Boolean existsByMovieName(String movieName);
//	Boolean findByLanguage(String language);
	Optional<Movie> findByMovieNameAndLanguage(String movieName  , String language);
	Optional<Movie> findByMovieNameAndReleaseDate(String movieName , String releaseDate);
//	Optional<List<Movie>> findByMovieName(String movieName);
	Optional<Movie> findByMovieName(String movieName);
	Optional<List<Movie>>  findByCast(String cast);
}
