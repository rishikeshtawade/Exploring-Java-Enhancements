package core_java;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamAPIPractice 
{
	public static void main(String[] args) 
	{
		
//		Q1 ) Given a list of strings, filter out the strings that contain the letter 'a' and 
//		convert the remaining strings to uppercase.
		
		List<String> ls=Arrays.asList("rishi","arya","rahul","hrishi","arushi");
		List<String> strm=ls.stream().filter(n->!n.contains("a"))
				.map(m->m.toUpperCase())
				.collect(Collectors.toList());
		strm.forEach(System.out::println);
		
//		Q2 ) Create a list of integers and find the sum of all even numbers.
		
		List<Integer> ls1=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		Integer strm1=ls1.stream().filter(n->n%2==0)
				.reduce((t, u) -> t+u).get();
		System.out.println(strm1);
		
//		Q3 ) Given a list of names, count the occurrences of each name and store
//		the count in a Map<String, Long>.
		
		List<String> ls2=Arrays.asList("rishi","arya","rahul","hrishi","arushi");
		Map<Object, Long> strm2=ls2.stream()
				.collect(Collectors.groupingBy(s->s,Collectors.counting()));
		System.out.println(strm2);
		
//		Q4 ) Given a list of integers, find the maximum value using streams.
		List<Integer> ls3=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		Integer max = ls3.stream()
                .mapToInt(Integer::intValue) // Convert Stream<Integer> to IntStream
                .max() // Find the maximum value
                .orElseThrow();
		System.out.println(max);
		
//		Q5 ) Given a list of strings, concatenate them all into a single string, separated by a comma.
		List<String> ls4=Arrays.asList("rishi","arya","rahul","hrishi","arushi");
		String strm4=ls4.stream().map(s->s.concat(","))
				.collect(Collectors.joining());
		System.out.println("String concat  :  "+strm4);
		
//		Q6 ) Given a list of objects with a numeric attribute, 
//		filter out objects where the attribute is greater than 50 and 
//		collect the remaining objects into a new list.
		List<A> ls5=Arrays.asList(new A(10),new A(20),new A(30),new A(50),new A(60),new A(70),new A(80));
		List<A> strm5=ls5.stream().filter(num->!(num.getA()>50)).collect(Collectors.toList());
		for(A refA:strm5) {
			System.out.print(refA.getA()+"  ");
		}
		
		System.out.println();
		
//		Q7 ) Generate a Stream of numbers from 1 to 100 and find the average of all even numbers.
		IntStream streamIntegers=IntStream.range(0, 100);
		double average=streamIntegers.filter(n->n%2==0).average().getAsDouble();
		System.out.println(average);
		
//		Q8 ) Filter a list of strings to keep only those longer than 7 characters, 
//		sort them alphabetically, and 
//		collect them into a new list.
		List<String> listOfString=Arrays.asList("risjklhi","arya","rajvkhul","hrisjklhi","arushi");
		List<String> name=listOfString
				.stream()
				.filter(s->s.length()>7)
				.sorted()
				.collect(Collectors.toList());
		name.forEach(System.out::println);
		
//		Q9 )Given a large list of elements, utilize parallel streams to perform filtering or
//		mapping operations for faster processing.
		List<Integer> listOfInteger=IntStream.range(0, 10).boxed().collect(Collectors.toList());
		List<Integer> listOfInteger1=listOfInteger.parallelStream()
		.filter(even->even%2==0)
		.map(square->square*square)
		.collect(Collectors.toList());
		listOfInteger1.forEach(System.out::print);
		
//		Q10 )Merge two lists of integers into a single Stream and find the maximum value.
		  List<Integer> list1 = Arrays.asList(1, 5, 8, 12);
	      List<Integer> list2 = Arrays.asList(3, 6, 9, 15);
	      Stream<Integer> stm=Stream.concat(list1.stream(),list2.stream());
	      Integer max1=stm.max(Integer::compareTo).get();
	      System.out.println("maximum number : "+max1);
	      
//	    Q11 )Flatten a list of lists into a single list using flatMap in Streams.
	      List<Integer> list3 = Arrays.asList(1, 5, 8, 12);
	      List<Integer> list4 = Arrays.asList(3, 6, 9, 15);
	      List<List<Integer>> list5=Arrays.asList(list3,list4);
	      Integer sum=list5.stream()
	    		  .flatMap(List::stream)
	    		  .reduce(Integer::sum).get();
	     System.out.println("sum of list : "+sum); 
	     
//	     Q12 )From a Stream of strings, find the distinct elements 
//	     and limit the output to the first 5 elements.
	     List<String> listOfString1=Arrays.asList("risjklhi","arya","rajvkhul","hrisjklhi","arushi","hvbdskv","vchshcfbs","dahvfvasjfdas");
	     List<String> listOfStriing=listOfString1.stream().distinct().limit(5).toList();
	     listOfStriing.forEach(System.out::println);
	     
//	     Q13 )Check if a list of integers contains a number divisible by 7 using Stream's 
//	     anyMatch() or allMatch() method.
	     List<Integer> listOfInteger2=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
	     Boolean checkDivisibleBy7=listOfInteger2.stream()
	    		 .anyMatch(t -> t%7==0);
	     System.out.println(checkDivisibleBy7);
	     
	     Boolean checkDivisibleBy72=listOfInteger2.stream()
	    		 .allMatch(t -> t%7==0);
	     System.out.println(checkDivisibleBy72);
	     
//	     Q14 )Skip the first 4 elements of a Stream and collect the rest into a new list.
	     List<String> listOfString3=Arrays.asList("risjklhi","arya","rajvkhul","hrisjklhi","arushi","hvbdskv","vchshcfbs","dahvfvasjfdas");
	     List<String> listOfStriing2=listOfString1.stream().skip(4).toList();
	     listOfStriing2.forEach(System.out::println);
	}
}
