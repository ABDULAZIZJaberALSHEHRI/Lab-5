package com.example.lab5q2.Controller;


import com.example.lab5q2.ApiResponse.ApiResponse;
import com.example.lab5q2.Model.TrackerSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/tracker-system")
@RestController
public class TrackerSystemController {
    ArrayList<TrackerSystem> projects = new ArrayList<TrackerSystem>();

    @PostMapping("/add-project")
    public ApiResponse addTracker(@RequestBody TrackerSystem trackerSystem) {
        projects.add(trackerSystem);
        return new ApiResponse("Successfully added project");
    }
    @GetMapping("/display-projects")
    public ArrayList<TrackerSystem> displayProjects() {
        return projects;
    }
    @PutMapping("/update-project/{index}")
    public ApiResponse updateTracker(@PathVariable int index, @RequestBody TrackerSystem trackerSystem) {
        projects.set(index, trackerSystem);
        return new ApiResponse("Successfully updated project");
    }
    @DeleteMapping("/delete-project/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Successfully deleted project");
    }
    @PutMapping("/update-status/{index}")
    public ApiResponse updateProjectStatus(@PathVariable int index) {
        if(projects.get(index).getStatus().equals("done")) {
            return new ApiResponse("Project is already done");
        }else if(projects.get(index).getStatus().equals("not done")) {
            projects.get(index).setStatus("done");
        }
        return new ApiResponse("Status updated successfully");
    }
    @GetMapping("/search-title")
    public ArrayList<TrackerSystem> searchTasks(@RequestBody TrackerSystem title) {
        ArrayList<TrackerSystem> titles = new ArrayList<>();
        for (TrackerSystem t : projects) {
            if(t.getTitle().toLowerCase().contains(title.getTitle().toLowerCase())) {
                titles.add(t);
            }
        }
        return titles;
    }
    @GetMapping("/project-by-companyname")
    public ArrayList<TrackerSystem> displayProjectByCompany(@RequestBody TrackerSystem companyName) {
        ArrayList<TrackerSystem> company = new ArrayList<>();
        for (TrackerSystem c : projects) {
            if(c.getCompanyName().toLowerCase().contains(companyName.getCompanyName().toLowerCase())) {
                company.add(c);
            }
        }
        return company;
    }

}
