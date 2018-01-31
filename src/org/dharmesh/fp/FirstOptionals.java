/*
 * https://flyingbytes.github.io/programming/java8/functional/part2/2017/02/04/Java8-Part2.html
 * 
 * 1. Optionals in Java 8
 * 
 */

package org.dharmesh.fp;

import java.util.Optional;

public class FirstOptionals {
	
	public void playingWithOptionals() {
	    String s = "Hello World!";
	    String nullString = null;

	    Optional<String> optionalS1 = Optional.of(s); // Will work
	    Optional<String> optionalS2 = Optional.ofNullable(s); // Will work too
	    //Optional<String> optionalNull1 = Optional.of(nullString); // -> NullPointerException
	    Optional<String> optionalNull2 = Optional.ofNullable(nullString); // Will work

	    System.out.println(optionalS1.get()); // prints "Hello World!"
	   // System.out.println(optionalNull2.get()); // -> NoSuchElementException
	    if(!optionalNull2.isPresent()) {
	        System.out.println("Is empty"); // Will be printed
	    }
	}
	
	public static void main(String args[]) {	
		FirstOptionals optionals = new FirstOptionals();
		optionals.playingWithOptionals();
	}
}
