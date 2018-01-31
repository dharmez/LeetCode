/*
 * https://flyingbytes.github.io/programming/java8/functional/part2/2017/02/04/Java8-Part2.html
 * 
 * 1. Optionals: In Java 8, java.util.Optional<T> was introduced to handle objects which might 
 * 	not exist better. It is a container object that can hold another object. 
 * 	The Generic T is the type of the object you want to contain.
 * 
 */

package org.dharmesh.fp;

import java.util.Optional;

public class TryOptionals {
	
	public void playingWithOptionals() {
	    String s = "Hello World!";
	    String nullString = null;

	    Optional<String> optionalS1 = Optional.of(s); // Will work
	    Optional<String> optionalS2 = Optional.ofNullable(s); // Will work too
	    //Optional<String> optionalNull1 = Optional.of(nullString); // -> NullPointerException
	    Optional<String> optionalNull2 = Optional.ofNullable(nullString); // Will work

	    System.out.println(optionalS1.get()); // prints "Hello World!"
	    System.out.println(optionalS2.get()); // prints "Hello World!"
	   // System.out.println(optionalNull2.get()); // -> NoSuchElementException
	    if(!optionalNull2.isPresent()) {
	        System.out.println("Is empty"); // Will be printed
	    }
	}
	
	public Integer doubleValueOrZero(Optional<Integer> value) {
	    return value.map(i -> i * 2).orElse(0);
	}
	
	public void showFlatMap() {
	    Optional<Double> two = Optional.of(2.0);
	    Optional<Double> zero = Optional.of(0.0);
	    Double a = two.flatMap(num -> divide(1.0, num)).orElse(0.0); // 0.5
	    Double b = zero.flatMap(num -> divide(0.0, num)).orElse(0.0); // 0.0
	    System.out.println("1.0/2.0 = "+a);
	    System.out.println("0.0/0.0 = "+b);
	}

	public Optional<Double> divide(Double first, Double second) {
	    if(second == 0.0) {
	       return Optional.empty();
	    }
	    return Optional.of(first / second);
	}
	
	public static void main(String args[]) {	
		TryOptionals optionals = new TryOptionals();
		optionals.playingWithOptionals();
		System.out.println(optionals.doubleValueOrZero(Optional.of(123)));
		System.out.println(optionals.doubleValueOrZero(Optional.ofNullable(null)));
		optionals.showFlatMap();
	}
}
