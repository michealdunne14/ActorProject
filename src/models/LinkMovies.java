package models;

public class LinkMovies<Store> {
	public LinkMovies<Store> next = null;

	public Movies mMovie;
	public Actors actors;
	public LinkMovies<Store> mLinkMovies;
	public MoviesStore mMovieStore;
	public int key;
	/**
	 * @param mMovie
	 * @param mLinkMovies
	 */
	public LinkMovies(Movies mMovie, LinkMovies<Store> mLinkMovies) {
		this.mMovie = mMovie;
		this.mLinkMovies = mLinkMovies;
	}

	public String toString() {
		return mMovie.toString();
	}
	/**
	 * @return the next
	 */
	public LinkMovies<Store> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(LinkMovies<Store> next) {
		this.next = next;
	}
	/**
	 * @return the mMovie
	 */
	public Movies getmMovie() {
		return mMovie;
	}
	/**
	 * @param mMovie the mMovie to set
	 */
	public void setmMovie(Movies mMovie) {
		this.mMovie = mMovie;
	}
	/**
	 * @return the mLinkMovies
	 */
	public LinkMovies<Store> getmLinkMovies() {
		return mLinkMovies;
	}
	/**
	 * @param mLinkMovies the mLinkMovies to set
	 */
	public void setmLinkMovies(LinkMovies<Store> mLinkMovies) {
		this.mLinkMovies = mLinkMovies;
	}

	/**
	 * @return the actors
	 */
	public Actors getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(Actors actors) {
		this.actors = actors;
	}

	/**
	 * @return the mMovieStore
	 */
	public MoviesStore getmMovieStore() {
		return mMovieStore;
	}

	/**
	 * @param mMovieStore the mMovieStore to set
	 */
	public void setmMovieStore(MoviesStore mMovieStore) {
		this.mMovieStore = mMovieStore;
	}

}
