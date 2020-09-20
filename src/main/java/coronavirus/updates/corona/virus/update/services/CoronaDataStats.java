package coronavirus.updates.corona.virus.update.services;

import coronavirus.updates.corona.virus.update.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaDataStats {



    public static String Corona_Virus_Data = "https://raw.githubusercontent" +
            ".com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports_us/09-17-2020.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *") // executing below method once a day
    public void coronaStatsFetch () throws IOException, InterruptedException {

        List<LocationStats> newStats = new ArrayList<>();
        // http calls using below
        HttpClient client = HttpClient.newHttpClient();

        // http requst helps us to use builder pattern
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Corona_Virus_Data)).build();

        //response by synchronus http response as a string
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);


        for (CSVRecord record : records) {
          LocationStats locationStats = new LocationStats();
          locationStats.setState(record.get("Province_State"));
          locationStats.setCountry(record.get("Country_Region"));
          int Confirmed =  Integer.parseInt(record.get("Confirmed"));

          locationStats.setLatestTotalCases(Confirmed);



            newStats.add(locationStats);
        }
        this.allStats=newStats;
    }
}
