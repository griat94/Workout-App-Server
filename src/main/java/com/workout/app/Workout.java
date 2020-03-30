package com.workout.app;

import javax.persistence.Id;
import lombok.Data;

@Data
public class Workout {

    @Id String id;
    String workoutType;
    String exerciseName;
    int sets;
    int repsPerSet;
    int weight;
    String userId;
    
    Workout() {}
    
    Workout(String workoutType, String exerciseName, int sets, int repsPerSet, String id, int weight, String userId) {
        this.workoutType = workoutType;
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.repsPerSet = repsPerSet;
        this.id = id;
        this.weight = weight;
        this.userId = userId; 
    }
}
