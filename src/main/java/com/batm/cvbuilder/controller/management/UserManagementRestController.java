package com.batm.cvbuilder.controller.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batm.cvbuilder.config.JWTService;
import com.batm.cvbuilder.model.dto.RequestLogin;
import com.batm.cvbuilder.model.dto.ResponseLogin;
import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.service.master.EmployeeService;
import com.batm.cvbuilder.service.master.UserService;
import com.batm.cvbuilder.service.transaction.CertificationService;
import com.batm.cvbuilder.service.transaction.EducationService;
import com.batm.cvbuilder.service.transaction.ExperienceService;
import com.batm.cvbuilder.service.transaction.SkillsService;
import com.batm.cvbuilder.service.transaction.ToolsService;
import com.batm.cvbuilder.service.transaction.TrainingService;
import com.batm.cvbuilder.handler.Response;

@RestController
@RequestMapping("api")
public class UserManagementRestController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillsService skillService;

    @Autowired
    private ToolsService toolService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private CertificationService certificationService;

    @Autowired
    private EducationService educationService;

    @PostMapping("login")
    public String Login(@RequestBody RequestLogin login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),
                        login.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(login.getEmail(), login.getPassword());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @GetMapping("coba")
    public ResponseEntity<Object> Coba(@RequestBody RequestLogin login) {
        User user = userService.getUser(login.getEmail());
        ResponseLogin responseLogin = new ResponseLogin();
        responseLogin.setEmployee(employeeService.Get(user.getId()));
        responseLogin.setSkill(skillService.getMySkills(user.getId()));
        responseLogin.setTool(toolService.getMyTools(user.getId()));
        responseLogin.setExperience(experienceService.getMyExperiences(user.getId()));
        responseLogin.setTraining(trainingService.getMyTrainings(user.getId()));
        responseLogin.setCertificate(certificationService.getMyCertification(user.getId()));
        responseLogin.setEducation(educationService.getMyEducations(user.getId()));
        return Response.generate("data ditemukan", HttpStatus.OK, responseLogin);
    }

}
