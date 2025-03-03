package org.example;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GeneticAlgorithm {
    private Data data;

    public GeneticAlgorithm (Data data){
        this.data = data;
    }
    public Population evolve(Population population){
        return mutatePopulation(crossoverPopulation(population));
    }
    public Population crossoverPopulation(Population population){
        Population crossOverPopulation = new Population(population.getSchedule().size(), data);
        // Index out of bounds
        IntStream.range(0, Driver.NUMBER_OF_SCHEDULE).forEach(x -> crossOverPopulation.getSchedule().set(x, population.getSchedule().get(x)));
        IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES, population.getSchedule().size()).forEach(x -> {
            if (Driver.CROSSOVER_RATE > Math.random()){
                Schedule schedule1 = selectTournamentPopulation(population).sortByFitness().getSchedule().get(0);
                Schedule schedule2 = selectTournamentPopulation(population).sortByFitness().getSchedule().get(0);
                // Apply crossover, the one that is better?
                crossOverPopulation.getSchedule().set(x, crossOverSchedules(schedule1,schedule2));
            }
            else{
                crossOverPopulation.getSchedule().set(x, population.getSchedule().get(x));
            }
        });

        return crossOverPopulation;
    }
    public Schedule crossOverSchedules(Schedule schedule1, Schedule schedule2){

        Schedule crossOverSchedule = new Schedule(data).initialize();
        IntStream.range(0, crossOverSchedule.getClasses().size()).forEach(x -> {
            if (Math.random() > Driver.CROSSOVER_SCHEDULE_RATE) {
                crossOverSchedule.getClasses().set(x, schedule1.getClasses().get(x));
            }
            else{
                crossOverSchedule.getClasses().set(x, schedule2.getClasses().get(x));
            }
        });
        return null;
    }
    public Population mutatePopulation(Population population){
        Population mutatedPopulation = new Population(population.getSchedule().size(), data);
        ArrayList<Schedule> schedules = mutatedPopulation.getSchedule();

        IntStream.range(0, Driver.NUMB_OF_ELITE_SCHEDULES).forEach(x -> {
            schedules.set(x, population.getSchedule().get(x));
        });
        IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES, population.getSchedule().size()).forEach(x -> {
            schedules.set(x, mutateSchedule(population.getSchedule().get(x)));
        });

        return mutatedPopulation;
    }
    public Schedule mutateSchedule(Schedule mutateSchedule){
        Schedule schedule = new Schedule(data).initialize();
        IntStream.range(0, mutateSchedule.getClasses().size()).forEach(x ->{
            if (Driver.MUTATION_RATE > Math.random()){
                mutateSchedule.getClasses().set(x, schedule.getClasses().get(x));
            }
        });

        return mutateSchedule;
    }
    public Population selectTournamentPopulation(Population population){
        Population tournamentPopulation = new Population(Driver.TOURNAMENT_SELECTION_SIZE, data);
        IntStream.range(0, Driver.TOURNAMENT_SELECTION_SIZE).forEach(x -> {
            tournamentPopulation.getSchedule().set(x, population.getSchedule().get((int) (Math.random() * population.getSchedule().size())));
        });

        return tournamentPopulation;
    }
}
