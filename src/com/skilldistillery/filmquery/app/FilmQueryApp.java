package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
  // app.test();
   app.launch();
  }

  private void test() throws SQLException {
    Film film = db.findFilmById(1);
   // System.out.println(film);
  }

  private void launch() {
	
    Scanner input = new Scanner(System.in);
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
		    System.out.println("----Welcome to FQ the HQ for Films!----");
		boolean loop = true;
		while (loop) { // user story #4
			System.out.println("------------FILM QUERY MENU------------");
			System.out.println(".______________________________________.");
			System.out.println("| (1)Look up film by ID                |");
			System.out.println("| (2)Look up film by Keyword           |");
			System.out.println("| (3)Exit                              |");
			System.out.println("|______________________________________|");
			int userInput = 0;
			userInput = input.nextInt();

			if (userInput < 4) {
				switch (userInput) {
				case 1:
					System.out.println("Look up film by ID ");
					System.out.println("Enter films ID: ");
					int id = input.nextInt();
					Film film = db.findFilmById(id);
					if(film != null) {	
						System.out.println("-----------------------------------------------------------------------------------------------");
						System.out.println( "Film: " + film.getTitle() 
								+  "\nRelease Year: " + film.getReleaseYear() 
								+ "\nRating: " + film.getRating() 
								+ "\nDescription: " + film.getDescription()
								+ "\nLanguage: " + film.getLanguage()
								+ "\nActors: " + db.findActorsByFilmId(id));
						System.out.println("-----------------------------------------------------------------------------------------------");
						System.out.println(" ");
					} else {
						System.out.println("Please enter a valid Film Id.");
					}
					break;
				case 2:
					System.out.println("Look up film by search keyword.");
					System.out.println("Please enter a search keyword: ");
					List<Film> films = db.findFilmByKeyword(input.next());
					if(films.size() == 0 ) {
						System.out.println("---------------------------------");
						System.out.println("No Film with that keyword exists.");
						System.out.println("---------------------------------");
					}else {
						for (Film film2 : films) {
							System.out.println("--------------------------------------------------------------------------------------------------------------");
							System.out.println(film2.keywordString());
							System.out.println("--------------------------------------------------------------------------------------------------------------");
							
						}
					}
					break;
				case 3:
					System.out.println("Bye");
					loop = false;
					break;
				default:
					System.out.println("----------------------------------");
					System.out.println("Please choose a vaild menu option.");
					System.out.println("----------------------------------");
					break;
  }
			}
		}}}

