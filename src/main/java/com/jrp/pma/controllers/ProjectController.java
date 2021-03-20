package com.jrp.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dto.TimeChartData;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService proService;
    //ProjectRepository proRepo;

    @Autowired
    EmployeeService empService;
    //EmployeeRepository empRepo;

    @GetMapping
    public String displayProject(Model model) {
        List<Project> projects = proService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/form")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List<Employee> employees = empService.getAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(@Valid Project project,
                                BindingResult errors, Model model) {
        if (errors.hasErrors()){
            List<Employee> employees = empService.getAll();
            model.addAttribute("allEmployees", employees);

            return "projects/new-project";
        }

        // this should handle saving to the database...
        proService.save(project);

        // use a redirect to prevent duplicate submission
        return "redirect:/project";
    }

    @GetMapping("/update")
    public String updateProject(@RequestParam("id") Long id, Model model){

        List<Employee> employees = empService.getAll();
        Project thePro = proService.findByProjectId(id);

        model.addAttribute("project", thePro);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") Long id){
        Project theProject = proService.findByProjectId(id);

        proService.delete(theProject);

        return "redirect:/project";
    }

    @GetMapping("/timelines")
    public String displayProjectTimelines(Model model) throws JsonProcessingException {
        List<TimeChartData> timelineData = proService.getTimeData();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTimelineString = objectMapper.writeValueAsString(timelineData);

        System.out.println("-------- project timelines --------");
        System.out.println(jsonTimelineString);

        model.addAttribute("projectTimeList", jsonTimelineString);

        return "projects/project-timelines";
    }
}
