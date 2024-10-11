package ca.sheridancollege.garzonba.assignment2.controllers;

import ca.sheridancollege.garzonba.assignment2.beans.DatabaseAccess;
import ca.sheridancollege.garzonba.assignment2.beans.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private DatabaseAccess db;

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("missionList", db.getMissionList());
        model.addAttribute("mission", new Mission());

        return "landing";
    }

    @GetMapping("/createMission")
    public String getCreateMissionPage(Model model) {
        return "createMission";
    }

    @PostMapping("/createMission")
    public String createMission(@ModelAttribute Mission mission) {
        int row = db.createMission(mission);

        System.out.println("Record updated: " + row);

        return "redirect:/";
    }

    @GetMapping("/getMissions")
    public String missionsPage(Model model, @RequestParam("agent") String agent) {
        ArrayList<Mission> agentMissions = db.getMissionByName(agent);
        model.addAttribute("missionList", agentMissions);

        return "missions";
    }

    @GetMapping("/editMission/{id}")
    public String updateMission(Model model, @PathVariable("id") Long id) {
        Mission mission = db.getMissionById(id);

        if (mission == null) {
            System.out.println("No result for mission ID: " + id);
            return "redirect:/";
        }

        model.addAttribute("mission", mission);
        return "editMission";
    }

    @PostMapping("/updateMission")
    public String updateMission(@ModelAttribute Mission mission) {
        int row = db.updateMission(mission);

        if (row == 0) {
            System.out.println("No result for mission ID: " + mission.getId());
        }

        return "redirect:/";
    }

    @GetMapping("/deleteMission/{id}")
    public String deleteMission(Model model, @PathVariable("id") Long id) {
        db.deleteMissionById(id);

        return "redirect:/";
    }

    @PostMapping("/missions")
    public String missionsSubmit() {
        return "missions";
    }
}
