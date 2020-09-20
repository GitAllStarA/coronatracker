package coronavirus.updates.corona.virus.update.controller;

import coronavirus.updates.corona.virus.update.models.LocationStats;
import coronavirus.updates.corona.virus.update.services.CoronaDataStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("testName","Test");
        return "home";
    }

    @Autowired
    CoronaDataStats coronaDataStats;

    @GetMapping("/Cases")
    public String cases(Model model){

        List<LocationStats> allStats = coronaDataStats.getAllStats();



        int totalReportedCases = allStats.stream().mapToInt(stats -> stats.getLatestTotalCases()).sum();

        model.addAttribute("caseUpdates",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);

        return "Cases";
    }
}
