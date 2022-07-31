package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	    private int id;
	    private String title;
	    private String description;
	    private int releaseYear;
	    private int languageID;
	    private int rentalDuration;
	    private double rentalRate;
	    private int length;
	    private double replacementCost;
	    private String rating;
	    private String specialFeatures;
		private String language;
		
	    public String getLanguage() {
			return language;
		}





		public void setLanguage(String language) {
			this.language = language;
		}





		public Film() {
			super();
		}
	    
	    
	    private List<Actor> actors = new ArrayList<>();






		public Film(int id, String title, String description, int releaseYear, int languageID, int rentalDuration,
				double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
				String language, List<Actor> actors) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.releaseYear = releaseYear;
			this.languageID = languageID;
			this.rentalDuration = rentalDuration;
			this.rentalRate = rentalRate;
			this.length = length;
			this.replacementCost = replacementCost;
			this.rating = rating;
			this.specialFeatures = specialFeatures;
			this.language = language;
			this.actors = actors;
		}





		public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getReleaseYear() {
			return releaseYear;
		}

		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}

		public int getLanguageID() {
			return languageID;
		}

		public void setLanguageID(int languageID) {
			this.languageID = languageID;
		}

		public int getRentalDuration() {
			return rentalDuration;
		}

		public void setRentalDuration(int rentalDuration) {
			this.rentalDuration = rentalDuration;
		}

		public double getRentalRate() {
			return rentalRate;
		}

		public void setRentalRate(double rentalRate) {
			this.rentalRate = rentalRate;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public double getReplacementCost() {
			return replacementCost;
		}

		public void setReplacementCost(double replacementCost) {
			this.replacementCost = replacementCost;
		}

		public String getRating() {
			return rating;
		}

		public void setRating(String string) {
			this.rating = string;
		}

		public String getSpecialFeatures() {
			return specialFeatures;
		}

		public void setSpecialFeatures(String specialFeatures) {
			this.specialFeatures = specialFeatures;
		}

		

		

		@Override
		public String toString() {
			return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear="
					+ releaseYear + ", languageID=" + languageID + ", rentalDuration=" + rentalDuration
					+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost
					+ ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", language=" + language
					+ " Actors: " + actors ;
		}
		public String keywordString() {
			return  "\nTitle: " + title + "\nDescription: " + description + "\nRelease Year: "
					+ releaseYear + "\nRating: " + rating + "\nLanguage: " + language + "\nActors: " + actors;
					
			
		}




		@Override
		public int hashCode() {
			return Objects.hash(actors, description, id, language, languageID, length, rating, releaseYear,
					rentalDuration, rentalRate, replacementCost, specialFeatures, title);
		}





		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Film other = (Film) obj;
			return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
					&& id == other.id && Objects.equals(language, other.language) && languageID == other.languageID
					&& length == other.length && Objects.equals(rating, other.rating)
					&& releaseYear == other.releaseYear && rentalDuration == other.rentalDuration
					&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
					&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
					&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
		}


}
