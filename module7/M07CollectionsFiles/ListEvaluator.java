import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ListEvaluator {

	public static void main(String[] args) {
		
		/* ************************ COMPARE WHETHER TWO LISTS HAVE EQUIVALENT CONTENTS */
		
		//Instant startTime = Instant.now();
		List<Integer> numberListA = createNumberList(32_000_000, 5000, true);
		//System.out.println(numberListA);
		//List<Integer> numberListA = createNumberListSlow(100_000, 500_000, false);
		//Instant stopTime = Instant.now();
		//long totalMillisTime = Duration.between(startTime, stopTime).toMillis();
		//System.out.println("Creating the number list took " + totalMillisTime);
		
		//List<Integer> numberListB = createNumberList(8_000_000, 5000, true);
		List<Integer> numberListB = new ArrayList<Integer>(numberListA);
		Collections.shuffle(numberListB);
		//System.out.println(numberListB);
	
		Instant start = Instant.now();	
		//boolean equivalent = equivalentListContentsRemoval(numberListA, numberListB);
		boolean equivalent = equivalentListContentsSorting(numberListA, numberListB);
		//boolean equivalent = equivalentListContentsMap(numberListA, numberListB);

		Instant stop = Instant.now();
		System.out.println("Method took " + Duration.between(start, stop).toMillis());
		System.out.println(equivalent);
		
		/* ************************ FIND THE LIST WITH THE MOST OVERLAP */
		
		//List<Integer> targetList = createNumberList(5, 10, true);
		List<Integer> targetList = createNumberList(1_000_000, 100_000, true);
		//Collections.sort(targetList); // sorting is for display purposes only
		//System.out.println("Target: \n" + targetList);
		//Collections.shuffle(targetList);

		//System.out.println("Possible Lists:");
		List<List<Integer>> possibleLists = new ArrayList<List<Integer>>();
		for(int i=0; i<100; i++) {
			//List<Integer> possibleList = createNumberList(5, 10, true);
			List<Integer> possibleList = createNumberList(1_000_000, 100_000, true);
			possibleLists.add(possibleList);
		}
		
		Instant startMatch = Instant.now();
		List<Integer> bestMatch = findListWithMostOverlap(targetList, possibleLists);
		//Collections.sort(bestMatch); // sorting is for display purposes only
		//System.out.println("Best Match: \n" + bestMatch);
		Instant stopMatch = Instant.now();
		long totalMillis = Duration.between(startMatch, stopMatch).toMillis();
		System.out.println("Finding a match took " + totalMillis);
		
	}
	
	//Instant start = Instant.now();
	//Instant stop = Instant.now();
	//System.out.println("Method took " + Duration.between(start, stop).toMillis());


	public static boolean equivalentListContentsRemoval(List<Integer> originalListA, List<Integer> originalListB) {
	
		// create a copy that we can modify so that the lists are not changed outside the method
		List<Integer> listA = new ArrayList<Integer>(originalListA);
		List<Integer> listB = new ArrayList<Integer>(originalListB);
		
		for(Integer number : listA) {
			if(!listB.remove(Integer.valueOf(number))) {
				return false;
			}
		}
		
		return listB.isEmpty();
	}
	
	
	public static boolean equivalentListContentsSorting(List<Integer> originalListA, List<Integer> originalListB) {
		// create a copy that we can modify so that the lists are not changed outside the method
		List<Integer> listA = new ArrayList<Integer>(originalListA);
		List<Integer> listB = new ArrayList<Integer>(originalListB);
		
		// this only works if the element in the list can be sorted
		// that means the class must implement Comparable
		Collections.sort(listA);
		Collections.sort(listB);

		return listA.equals(listB);		
	}
		
	public static boolean equivalentListContentsMap(List<Integer> listA, List<Integer> listB) {	
		// key = element from the list; value = count (how many times that element appears on the list)
		Map<Integer, Integer> mapA = createMapFromList(listA);
		//System.out.println(listA);
		//System.out.println(mapA);
		
		Map<Integer, Integer> mapB = createMapFromList(listB);
		//System.out.println(listB);
		//System.out.println(mapB);
		return mapA.equals(mapB);	
	}
	
	private static Map<Integer, Integer> createMapFromList(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer number : list) {
			if(map.containsKey(number)) {
				int currentCount = map.get(number);
				currentCount++;
				map.put(number, currentCount);
			} else { // number is not yet in the map
				map.put(number, 1);
			}
		}
		return map;
	}
	
	
	
	
	public static List<Integer> findListWithMostOverlap(List<Integer> targetList, List<List<Integer>> possibleLists) {
		Map<Integer, Integer> targetMap = createMapFromList(targetList);
		
		int maximumOverlapped = 0;
		int indexOfListWithMaximumOverlapped = 0;
		
		for(int i=0; i<possibleLists.size(); i++) {
			List<Integer> possibleList = possibleLists.get(i);

			// create a copy so I can modify the map
			Map<Integer, Integer> targetMapCopy = new HashMap<>(targetMap);
			
			for(Integer number : possibleList) {
				if(targetMapCopy.containsKey(number)) {
					int currentCount = targetMapCopy.get(number);
					currentCount--;
					if(currentCount==0) {
						targetMapCopy.remove(number);
					} else {
						targetMapCopy.put(number, currentCount);
					}
				}
			}
			// at the end of the loop, the targetMapCopy contains all elements that did NOT overlap

			int itemsNotOverlapped = 0;
			for(Map.Entry<Integer, Integer> entry : targetMapCopy.entrySet()) {
				// Map.Entry entry: key- number on the list, value- count
				itemsNotOverlapped += entry.getValue();
			}
			int itemsOverlapped = targetList.size() - itemsNotOverlapped;
			
			//Collections.sort(possibleList); // sorting is for display purposes only
			//System.out.println(possibleList + "\tItems Overlapped=" + itemsOverlapped);
			
			
			// if there are more than one possible list with the same max:
			// > means that the first maximum overlap will be chosen
			// >= means that the last one will
			if(itemsOverlapped > maximumOverlapped) {
				maximumOverlapped = itemsOverlapped;
				indexOfListWithMaximumOverlapped = i; // the index of the list with the current maximum overlaps
			}
		}

		System.out.println("The number of overlaps = " + maximumOverlapped);
		return possibleLists.get(indexOfListWithMaximumOverlapped);
	}
	
	public static List<Integer> createNumberList(int size, int maxNumber, boolean duplicates) {
		if(!duplicates && size>maxNumber) {
			throw new IllegalArgumentException("Cannot create a list of size " + size + " in the range of 0 to " + (maxNumber-1) + " without duplicates.");
		}
		List<Integer> numberList = new ArrayList<Integer>();	
		Random generator = new Random();
		
		if(duplicates) {
			for(int i=0; i<size; i++) {
				int number = generator.nextInt(maxNumber);
				numberList.add(number);
			}
		} else { // no duplicates allowed
			Set<Integer> set = new HashSet<Integer>();
			while(set.size() < size) {
				int number = generator.nextInt(maxNumber);
				set.add(number);
			}
			numberList.addAll(set);
		}
	
		return numberList;
	}
	
	public static List<Integer> createNumberListSlow(int size, int maxNumber, boolean duplicates) {
		if(!duplicates && size>maxNumber) {
			throw new IllegalArgumentException("Cannot create a list of size " + size + " in the range of 0 to " + (maxNumber-1) + " without duplicates.");
		}
		List<Integer> numberList = new ArrayList<Integer>();	
		Random generator = new Random();
		
		if(duplicates) {
			for(int i=0; i<size; i++) {
				int number = generator.nextInt(maxNumber);
				numberList.add(number);
			}
		} else { // no duplicates allowed
			
			while(numberList.size()<size) {
				int number = generator.nextInt(maxNumber);
				if(!numberList.contains(number)) {
					numberList.add(number);
				}
			}	
		}
	
		return numberList;
	}
	

}
