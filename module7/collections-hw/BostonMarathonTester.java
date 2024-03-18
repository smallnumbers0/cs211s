//This is the driver program to read data from csv files.
//There are 2 files to read from: Type "mens", or "womens" to read either one!
//CS 211s Gevilee Mari, Jacky Choi


import java.io.*;
// import java.time.*;
import java.util.*;

public class BostonMarathonTester {

    public static void main(String[] args) {
        List<BostonMarathonWinner> winnerList = new ArrayList<BostonMarathonWinner>();
        // LocalDateTime start = LocalDateTime.now();
        fillList(winnerList);
        // LocalDateTime end = LocalDateTime.now();
        //System.out.println("Test");
        System.out.println("Hello World");

        //Who is the fastest runner from the United States in the Boston Marathon?
        BostonMarathonWinner fastestUSRunner = findFastestUSRunner(winnerList);
        System.out.println("Fastest US Runner for Bostom Marathon: " + fastestUSRunner.getWinner() + " with a time of " + fastestUSRunner.getTime());

        //Who are all the runners that won the Boston Marathon that are from Kenya?
        Map<String, List<BostonMarathonWinner>> WinnersByCountry = newWinnersByCountry(winnerList);
        String country = "Kenya";
        List<BostonMarathonWinner> kenyanWinners = WinnersByCountry.get(country);

        System.out.println("Marathon Winners from " + country + ":");
        for (BostonMarathonWinner winner : kenyanWinners) {
            System.out.println(winner.getWinner() + " " + winner.getTime());
        }
    }

    public static void fillList(List<BostonMarathonWinner> list) {
        String fileName;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Which file do you want to read? (Mens/Womens)");
        fileName = scnr.nextLine();
        scnr.close();
        if(fileName.equalsIgnoreCase("mens") || fileName.equalsIgnoreCase("mens_boston_marathon_winners.csv")) {
            fileName = "Mens_Boston_Marathon_Winners.csv";
        }
        else if(fileName.equalsIgnoreCase("womens") || fileName.equalsIgnoreCase("womens_boston_marathon_winners.csv")){
            fileName = "Womens_Boston_Marathon_Winners.csv";
        }
        else {
            System.out.println("Invalid file");
            return;
        }
        try (Scanner fileScan = new Scanner(new FileReader(new File(fileName)))) {
            String line = fileScan.nextLine();

            while(fileScan.hasNext()) {
                line = fileScan.nextLine();

                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                String year = lineScan.next();
                String winner = lineScan.next();
                String country = lineScan.next();
                String time = lineScan.next();
                String distance = lineScan.next();
            
                BostonMarathonWinner runner = new BostonMarathonWinner(year, winner, country, time, distance);
                list.add(runner);
                lineScan.close();
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Finding the fastest United States runner
    public static BostonMarathonWinner findFastestUSRunner(List<BostonMarathonWinner> runners) {
        BostonMarathonWinner fastestUSRunner = null;
        double fastestTime = 999999999;

        for (BostonMarathonWinner runner : runners) {
            if (runner.getCountry().equals("United States")) {
                String time = runner.getTime();
                String[] timeParts = time.split(":");
                int hours = Integer.parseInt(timeParts[0]);
                int minutes = Integer.parseInt(timeParts[1]);
                int seconds = Integer.parseInt(timeParts[2]);
                int totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
                if (totalTimeInSeconds < fastestTime) {
                    fastestTime = totalTimeInSeconds;
                    fastestUSRunner = runner;
                }
            }
        }

        return fastestUSRunner;
    }
    //Key: country of Kenya Value: From list of Runners
    public static Map<String, List<BostonMarathonWinner>> newWinnersByCountry(List<BostonMarathonWinner> winners) {
        Map<String, List<BostonMarathonWinner>> newWinnersByCountry = new HashMap<>();
        
        for (BostonMarathonWinner winner : winners) {
            String country = winner.getCountry();
            List<BostonMarathonWinner> countryWinners = newWinnersByCountry.get(country);
            if (countryWinners == null) {
                countryWinners = new ArrayList<>();
                newWinnersByCountry.put(country, countryWinners);
            }
            countryWinners.add(winner);
        }
        return newWinnersByCountry;
    }
}
