package com.workout.app;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
public class Workout {

    @Id String id;
    String workoutType;
    String exerciseName;
    int sets;
    int repsPerSet;
    
    Workout() {}
    
    Workout(String workoutType, String exerciseName, int sets, int repsPerSet, String id) {
        this.workoutType = workoutType;
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.repsPerSet = repsPerSet;
        this.id = id;
    }
}
