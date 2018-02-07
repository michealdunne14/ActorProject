package models;

public class LinkActors<Store> {
	public LinkActors<Store> next = null;

	public Actors mActor;
	public Movies movies;
	public LinkActors<Store> mLinkActors;
	/**
	 * @param mActor
	 * @param mLinkActors
	 */
	public LinkActors(Actors mActor, LinkActors<Store> mLinkActors) {
		this.mActor = mActor;
		this.mLinkActors = mLinkActors;
	}

	public String toString() {
		return mActor.toString();
	}
	/**
	 * @return the next
	 */
	public LinkActors<Store> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(LinkActors<Store> next) {
		this.next = next;
	}
	/**
	 * @return the mActor
	 */
	public Actors getmActor() {
		return mActor;
	}
	/**
	 * @param mActor the mActor to set
	 */
	public void setmActor(Actors mActor) {
		this.mActor = mActor;
	}
	/**
	 * @return the mLinkActors
	 */
	public LinkActors<Store> getmLinkActors() {
		return mLinkActors;
	}
	/**
	 * @param mLinkActors the mLinkActors to set
	 */
	public void setmLinkActors(LinkActors<Store> mLinkActors) {
		this.mLinkActors = mLinkActors;
	}

	/**
	 * @return the movies
	 */
	public Movies getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(Movies movies) {
		this.movies = movies;
	}

}
