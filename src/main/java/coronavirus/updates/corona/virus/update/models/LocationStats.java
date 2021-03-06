package coronavirus.updates.corona.virus.update.models;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;

    public float getMortality() {
        return diffFromPrevDay;
    }

    public void setMortality(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }

    private float diffFromPrevDay;
//
//    public LocationStats(String state, String coutry, String latestTotalCases) {
//        this.state = state;
//        this.country = coutry;
//        this.latestTotalCases = latestTotalCases;
//    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {

         return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {

        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases='" + latestTotalCases + '\'' +
                '}';
    }
}
