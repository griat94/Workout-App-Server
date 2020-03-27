package com.workout.app;
import com.workout.app.WorkoutService;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.MediaType;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app")
public class WorkoutController {
    
    WorkoutService workoutService = new WorkoutService(); 
    
    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void registerUser(@RequestBody User user) {
        workoutService.registerNewUser(user);
    }
    
    @GetMapping("/getPersons")
    public ArrayList<User> getUsers() {
        return workoutService.getUsers();
    }
    
    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean attepmtLogin(@RequestBody LoginUser loginUser) {
        return workoutService.attemptLogin(loginUser);
    }
    
    @PostMapping(path = "/addWorkout", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void addWorkout(@RequestBody Workout workout) {
        workoutService.addWorkout(workout);
    }
    
    @GetMapping("/getWorkouts")
    public ArrayList<Workout> getWorkouts() {
        return workoutService.getWorkouts();
    }
    
    @DeleteMapping(value = "/deleteWorkout/{workoutId}")
    public void deleteWorkout(@PathVariable String workoutId) {
        workoutService.deleteWorkout(workoutId);
    }
    
    @PutMapping(value = "/editWorkout/{workoutId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void editWorkout(@RequestBody Workout workout ,@PathVariable  String workoutId) {
        workoutService.editWorkout(workout, workoutId);
    }
}
