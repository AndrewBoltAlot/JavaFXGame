package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *@author Andrew Bolt
 *<p>This class holds the serializable instance of points, so that the name and points of users can be stored on a file</p>
 */
public class Points implements Serializable {
	public int points = 0;
	public String name = "Player";

	public Points(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
/**
 * Adds to points the amount given in the parameter pointToAdd
 * @param pointToAdd
 */
	public void addPoints(int pointToAdd){
		points += pointToAdd;
	}
/**
 * resets the points value to 0
 */
	public void resetPoints() {
		points = 0;
	}
}
