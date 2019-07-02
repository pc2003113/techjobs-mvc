package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.models.JobData.findByValue;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value="results", method=RequestMethod.POST)
    public String processSearch(@RequestParam String searchType,@RequestParam String searchTerm, Model model ) {
        if (searchType.equals("all")){

            ArrayList<HashMap<String, String>> resultfindByValue=JobData.findByValue(searchTerm );
            model.addAttribute("jobs",resultfindByValue);
            return "search";
        }
        else {

            ArrayList<HashMap<String, String>> findByColumnAndValue=JobData.findByColumnAndValue(searchType,searchTerm);
            model.addAttribute("jobs",findByColumnAndValue);
            return "search";
            //logic
        }

    }


}
