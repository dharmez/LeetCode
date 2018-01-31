/*
 * https://flyingbytes.github.io/programming/java8/functional/part0/2017/01/16/Java8-Part0.html
 * 
 * 1. All variables are final
 * 2. Don’t use global variables (and forget about side effects)
 * 3. Use functions as parameters
 * 4.  
 * 
 */

package org.dharmesh.fp;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FirstFunctions {
	
	public static Integer compute(Function<Integer, Integer> function, Integer value) {
	    return function.apply(value);
	}
	
	public static Double compute(Function<Double, Double> function, Double value) {
	    return function.apply(value);
	}
	
	private static BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
	
	
	public static Integer invertTheNumber(Integer toInvert){
        return compute((a) -> -a, toInvert);
    }
	public static Integer squareTheNumber(Integer num){
        return compute((a) -> a*a, num);
    }
	public static Double squareRootOfTheNumber(Double num){
        return compute((a) -> Math.sqrt(a), num);
    }
	
	public static Integer addNumbers(Integer a, Integer b){
        return add.apply(a, b);
    }
	
	public static void main(String args[]) {	
		System.out.println(invertTheNumber(5));
		System.out.println(squareTheNumber(5));
		System.out.println(squareRootOfTheNumber(49.5));
		System.out.println(addNumbers(1, 3));
	}
}
