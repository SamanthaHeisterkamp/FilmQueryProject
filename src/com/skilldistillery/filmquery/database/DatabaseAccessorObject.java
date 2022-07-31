package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	 String user = "student";
	 String pass = "student";

	@Override
	public Film findFilmById(int filmId){
		Film film = null ;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				  int id = rs.getInt("id");
	    	      String title = rs.getString("title");
	    	      String desc = rs.getString("description");
	    	      int releaseYear = rs.getInt("release_year");
	    	      int langId = rs.getInt("language_id");
	    	      int rentDur = rs.getInt("rental_duration");
	    	      double rate = rs.getDouble("rental_rate");
	    	      int length = rs.getInt("length");
	    	      double repCost = rs.getDouble("replacement_cost");
	    	      String rating = rs.getString("rating");
	    	      String features = rs.getString("special_features");
	    	      
	    	   film = new Film(id, title, desc, releaseYear, langId, 
	    			   rentDur, rate, length, repCost, rating, features, null);
				
	    	//   film.setActors(findActorsByFilmId(filmId));
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("DataBase Error");
			e.printStackTrace();
		}
		return film;
	}
	
	@Override
	public List <Film> findFilmByKeyword(String str) {
		Film film = null;
		List<Film> films = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			str = "%" + str + "%";
			String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, str);
			stmt.setString(2, str);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				film = new Film();
				  film.setId(rs.getInt("id"));
	    	      film.setTitle(rs.getString("title"));
	    	      film.setDescription(rs.getString("description"));
	    	      film.setReleaseYear(rs.getInt("release_year"));
	    	      film.setRating(rs.getString("rating"));
	    	      films.add(film);
	    	      
	      
		
		
	    	//   film.setActors(findActorsByFilmId(filmId));
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch (SQLException e) {
			System.out.println("DataBase Error");
			e.printStackTrace();
		}
		return films;
	}
	

	@Override
	public Actor findActorById(int actorId){
		Actor actor = null ;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet actorResult = stmt.executeQuery();
			
			
			if (actorResult.next()) {
			  actor = new Actor(); 
			  // Create the object
			  // Here is our mapping of query columns to our object fields:
			  actor.setId(actorResult.getInt("id"));
			  actor.setFirstName(actorResult.getString("first_name"));
			  actor.setLastName(actorResult.getString("last_name"));
			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
		return actor;
      }

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorByFilmId = new ArrayList<>();
		Actor actorID = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * "
				+ " FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
//			SELECT a.id, a.first_name, a.last_name
//			FROM actor a
//			INNER JOIN film_actor fa ON a.id = fa.actor_id
//			INNER JOIN film f ON fa.film_id = f.id
//			WHERE film_id = ?;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			System.out.println(stmt);

			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				actorID = new Actor();
				actorID.setId(rs.getInt("id"));
				actorID.setFirstName(rs.getString("first_name"));
				actorID.setLastName(rs.getString("last_name"));
			
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<Actor>) actorID;
	}
	}