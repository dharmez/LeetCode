/*
 * https://flyingbytes.github.io/programming/java8/functional/part3/2017/02/18/Java8-Part3.html
 * 
 * 1. Streams: In Java 8, Streams is functional alternative of working with Collections.
 * 
 */

package org.dharmesh.fp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class TryStreams {
	public void convertObjects() {
	    Stream<String> objectStream = Stream.of("Hello", "World");
	    System.out.println(objectStream.count());
	}
	
	public void convertCollections() {
		String[] array = {"apple", "banana"};
		Set<String> emptySet = new HashSet<>();
		List<Integer> emptyList = new LinkedList<>();
		Stream<String> arrayStream = Arrays.stream(array);
		Stream<String> setStream = emptySet.stream();
		Stream<Integer> listStream = emptyList.stream();
		arrayStream.forEach(TryStreams::prettyPrint);
		setStream.forEach(TryStreams::prettyPrint);
		listStream.forEach(TryStreams::prettyPrint);
	}
	
	public void showMap() {
		Stream.of(1,2,3,4).map(i -> i*i).forEach(TryStreams::prettyPrint);
	}
	private static void prettyPrint(Object i) {
		System.out.print(i+" ");
	}
	
	public static void main(String args[]) {	
		TryStreams thiz = new TryStreams();
		System.out.println(thiz.getClass().getName());
		thiz.convertObjects();
		thiz.convertCollections();
		thiz.showMap();
	}
}
