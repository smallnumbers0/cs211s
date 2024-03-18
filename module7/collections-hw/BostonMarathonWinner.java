//Boston Marathon Winner class
//CS211s Gevilee Mari,  Jacky Choi

public class BostonMarathonWinner implements Comparable<BostonMarathonWinner> {
    private String year;
    private String winner;
    private String country;
    private String time;
    private String distance;

    // public static final Comparator MARATHON_FINISH_TIME = new MarathonFinishTime();

    // private static class MarathonFinishTime implements Comparator<BostonMarathonWinner> {
    //     public int compare(BostonMarathonWinner a, BostonMarathonWinner b) {
    //         return a.getTime().compareTo(b.getTime());
    //     }
    // }

    // public static final Comparator MARATHON_YEAR = new MarathonYear();

    // private static class MarathonYear implements Comparator<BostonMarathonWinner> {
    //     public int compare(BostonMarathonWinner a, BostonMarathonWinner b) {
    //         return a.getYear().compareTo(b.getYear());
    //     }
    // }


    public BostonMarathonWinner(String year, String winner, String country, String time, String distance) {
        this.year = year;
        this.winner = winner;
        this.country = country;
        this.time = time;
        this.distance = distance;
    }

    public String getYear() {
        return year;
    }

    public String getWinner() {
        return winner;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public String getDistance() {
        return distance;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString() {
        return "Boston Marathon Winner in " + year + ", " + winner + " " + country + " " + time; 
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BostonMarathonWinner) {
            BostonMarathonWinner other = (BostonMarathonWinner) obj;
            return year.equals(other.year) && winner.equals(other.winner) && country.equals(other.country) && time.equals(other.time) && distance.equals(other.distance);
        }
        else {
            return false;
        }
    }

    @Override
    public int compareTo(BostonMarathonWinner other) {
        return time.compareTo(other.time);
    }
}

