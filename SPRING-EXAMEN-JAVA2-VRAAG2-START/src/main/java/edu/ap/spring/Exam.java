package edu.ap.spring;

import java.awt.Point;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.*;
import java.util.function.IntPredicate;

import org.springframework.stereotype.Component;

@Component
public class Exam {

	
	/*public Exam() {
		
	}*/

	String all;
	
	public List<Point> generatePoints() {
		List<Point> result = new ArrayList<>();
		result.add(new Point(-4, -8));
	    result.add(new Point(-2, 9));
	    result.add(new Point(-1, -8));
	    result.add(new Point(0, -7));
	    result.add(new Point(1, 1));
	    result.add(new Point(2, 3));
	    result.add(new Point(2, 3));
	    result.add(new Point(2, -2));
	    result.add(new Point(4, -1));
	    return result;
	}
	
	public int[] toIntArray(List<Integer> list){
		  int[] ret = new int[list.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = list.get(i);
		  return ret;
	}
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		IntStream intStream = Arrays.stream(numbers);
		List<Integer> primes = new ArrayList<>();
		intStream.filter(Exam::isPrime).forEach(p -> primes.add(p));
		
		//Integer[] array = primes.toArray(new Integer[primes.size()]);
		

		return toIntArray(primes);
	}
	
	  private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
	}
	
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {
		Stream<Character> characterStream = string.chars().mapToObj(c -> (char) c);
		Long aantalKarakters = characterStream.filter(c -> c.isLowerCase(c)).count();
		return aantalKarakters.intValue();
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	
	public int sumOfX(List<Point> points) {
		List<Integer> list = new ArrayList<>();
		int total = 0;
		
		points.stream().map(p -> p.x ).forEach(p -> list.add(p));
		
		for (Integer i:list) {
			total = total + i;
		}
		
		return total;
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
		List<Double> xovertwo = points.stream()
			.filter(p -> (p.getX() >= 2))
			.map(p -> p.getX())
			.collect(Collectors.toList());
		
		all = "";
		xovertwo.forEach(x -> all += x.intValue() + ", ");
		all = all.substring(0, all.length() - 2);
		return all;
	}
}
