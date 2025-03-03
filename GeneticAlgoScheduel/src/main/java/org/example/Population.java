package org.example;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {
    private ArrayList<Schedule> schedules;
    public ArrayList<Schedule> getSchedule() { return this.schedules; }

    // Another way
    // IntStream.range(0, size).forEach(x -> schedules.add(new Schedule(data).initialize()));
    public Population(Integer size, Data data){
        this.schedules = new ArrayList<Schedule>(size);
        for (int i = 0; i < size; i++){
            schedules.add(new Schedule(data).initialize());
        }
    }
    public Population sortByFitness() {
        schedules.sort((s1, s2) -> {
            if (s1.getFitness() > s2.getFitness()) {
                return -1;
            } else if (s1.getFitness() < s2.getFitness()) {
                return 1;
            } else {
                return 0;
            }
        });
        return this;
    }
}
