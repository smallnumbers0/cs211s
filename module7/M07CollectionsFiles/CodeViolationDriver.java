import java.io.*;
import java.util.*;

public class CodeViolationDriver {
	
	public static enum Season { WINTER, SPRING, SUMMER, FALL;
		
		public static Season getSeason(int monthNumber) {
			switch(monthNumber) {
			case 12: case 1: case 2: return WINTER;
			case 3: case 4: case 5: return SPRING;
			case 6: case 7: case 8: return SUMMER;
			case 9: case 10: case 11: return FALL;
			default: throw new IllegalArgumentException(monthNumber + " is not a valid month number.");
			}
		}
	}
	
	public static void main(String[] args) {
			
		List<CodeViolation> codeViolationList = new ArrayList<CodeViolation>();
		// Map<String,CodeViolation> map; // key = id, value = CodeViolation; this would be good for lookup functionality
		Map<String, List<CodeViolation>> violationByCodeSectionMap = new HashMap<>(); 
		Map<CodeViolation.Status, List<CodeViolation>> codeViolationByStatusMap = new HashMap<>();// key=Status, value=List<CodeViolation>
		Map<CodeViolation.District, List<CodeViolation>> codeViolationByDistrictMap = new HashMap<>();

		fillListAndMaps(codeViolationList, violationByCodeSectionMap, codeViolationByStatusMap, codeViolationByDistrictMap);
		
		System.out.println("Total # of Code Violations: " + codeViolationList.size());
		
		System.out.println();
		System.out.println("Random selection of violations:");
		Random generator = new Random();
		for(int i=0; i<5; i++) {
			System.out.println(codeViolationList.get(generator.nextInt(codeViolationList.size())));
		}
		
		// Question 1: How many violations are there with each status?
		System.out.println();
		System.out.println("Total # of Code Violations for Each Status:");
		for(CodeViolation.Status status : codeViolationByStatusMap.keySet()) { // invoking keySet returns Set<CodeViolation.Status>
			System.out.println("Status " + status + ": " + codeViolationByStatusMap.get(status).size() + " violations.");
		}
		
		// Question 2: What are the top five most common code sections that are violated?
		System.out.println();
		System.out.println("Total # of Code Sections:\t\t" +  violationByCodeSectionMap.keySet().size());
		System.out.println("Code sections with the most violations:");
		List<Map.Entry<String, List<CodeViolation>>> listKeyValuePairs =
				new ArrayList<>(violationByCodeSectionMap.entrySet());
		Collections.sort(listKeyValuePairs, new KeyValueComparatorReverseOrderCodeSection());
		
		for(int i=0; i<5; i++) {
			Map.Entry<String, List<CodeViolation>> keyValuePair = listKeyValuePairs.get(i);
			System.out.println(keyValuePair.getKey() + " has " + keyValuePair.getValue().size() + " violations.");
		}
		
		// Question 3: What are the three districts with the fewest code violations?
		System.out.println();
		System.out.println("Districts with the fewest violations:");
		List<Map.Entry<CodeViolation.District, List<CodeViolation>>> districtListKeyValuePairs =
				new ArrayList<>(codeViolationByDistrictMap.entrySet());
		
		Collections.sort(districtListKeyValuePairs, new KeyValueComparatorDistrict());
		for(int i=0; i<3; i++) {
			Map.Entry<CodeViolation.District, List<CodeViolation>> keyValuePair = districtListKeyValuePairs.get(i);
			System.out.println(keyValuePair.getKey() + " has " + keyValuePair.getValue().size() + " violations.");
		}

		// Question 4: Does one season have more violations than others?
		System.out.println();
		Map<Season, List<CodeViolation>> codeViolationsBySeasonMap = new HashMap<>();
		for(Season season : Season.values()) {
			List<CodeViolation> emptyList = new ArrayList<>();
			codeViolationsBySeasonMap.put(season, emptyList);
		}
		for(CodeViolation violation : codeViolationList) {
			int monthNumber = violation.getDate().getMonthValue();
			Season season = Season.getSeason(monthNumber);
			List<CodeViolation> list = codeViolationsBySeasonMap.get(season);
			list.add(violation);
		}
		for(Map.Entry<Season, List<CodeViolation>> entry : codeViolationsBySeasonMap.entrySet()) {
			System.out.println(entry.getKey() + " has " + entry.getValue().size() + " violations.");
		}
		
		System.out.println("\nAnalysis complete.");
	}
	
	public static class KeyValueComparatorReverseOrderCodeSection implements Comparator<Map.Entry<String, List<CodeViolation>>> {
		
		@Override
		public int compare(Map.Entry<String, List<CodeViolation>> entry1, Map.Entry<String, List<CodeViolation>> entry2) {
			return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
			
		}
	}

	public static class KeyValueComparatorDistrict implements Comparator<Map.Entry<CodeViolation.District, List<CodeViolation>>> {
		
		@Override
		public int compare(Map.Entry<CodeViolation.District, List<CodeViolation>> entry1, Map.Entry<CodeViolation.District, List<CodeViolation>> entry2) {
			return Integer.compare(entry1.getValue().size(), entry2.getValue().size());
		}
		
	}

	
	
	
	private static void fillListAndMaps(
			List<CodeViolation> violationList,
			Map<String, List<CodeViolation>> violationsByCodeSectionMap,
			Map<CodeViolation.Status, List<CodeViolation>> violationsByStatusMap,
			Map<CodeViolation.District, List<CodeViolation>> violationsByDistrictMap) {
		
		Set<CodeViolation> violationSet = new HashSet<>();
		
		try (Scanner fileScan = new Scanner(new FileReader(new File("Code_Violations_Downloaded_Cleaned.csv")))) {
			String line = fileScan.nextLine(); // read the column headers

	            while (fileScan.hasNext()) {
	                line = fileScan.nextLine(); // one line of data
	                
	                // this code assumes perfectly formatted input data
	                Scanner lineScan = new Scanner(line);
	                lineScan.useDelimiter(",");
	                long id = Long.parseLong(lineScan.next());
	                String dateString = lineScan.next();
	                String statusString = lineScan.next();
	                CodeViolation.Status status = CodeViolation.Status.getStatus(statusString);
	                String code = lineScan.next();
	                String codeSection = lineScan.next();
	                String description = lineScan.next();
	                String comments = lineScan.next();
	                String districtString = lineScan.next();
	                CodeViolation.District district = CodeViolation.District.getDistrict(districtString);
	                
	                CodeViolation codeViolation = new CodeViolation.Builder()
	                		.id(id)
	                		.date(dateString)
	                		.status(status)
	                		.code(code)
	                		.codeSection(codeSection)
	                		.description(description)
	                		.comments(comments)
	                		.district(district)
	                		.build();
	                if(violationSet.add(codeViolation)) {
	                
		                // fill the status map
		                if(violationsByStatusMap.containsKey(status)) {
		                	violationsByStatusMap.get(status).add(codeViolation);
		                } else {
		                	List<CodeViolation> statusList = new ArrayList<CodeViolation>();
		                	statusList.add(codeViolation);
		                	violationsByStatusMap.put(status, statusList);
		                }
		                
		                // fill the district map
		                if(violationsByDistrictMap.containsKey(district)) {
		                	violationsByDistrictMap.get(district).add(codeViolation);
		                } else {
		                	List<CodeViolation> districtList = new ArrayList<CodeViolation>();
		                	districtList.add(codeViolation);
		                	violationsByDistrictMap.put(district, districtList);
		                }

		                
		                // fill the code section map
		                if(violationsByCodeSectionMap.containsKey(codeSection)) {
		                	violationsByCodeSectionMap.get(codeSection).add(codeViolation);
		                } else {
		                	List<CodeViolation> codeSectionList = new ArrayList<CodeViolation>();
		                	codeSectionList.add(codeViolation);
		                	violationsByCodeSectionMap.put(codeSection, codeSectionList);
		                }
	                }

	            }
	            violationList.addAll(violationSet);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
}
