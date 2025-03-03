package org.example;

import java.util.stream.IntStream;

public class Driver {
    public static final int NUMBER_OF_SCHEDULE = 3;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    public static final double CROSSOVER_SCHEDULE_RATE = 0.5;
    private Data data;
    public static void main(String[] args){
        Driver driver = new Driver();
        driver.data = new Data();
//        driver.printDataCurrent();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
        Population population = new Population(Driver.TOURNAMENT_SELECTION_SIZE, driver.data).sortByFitness();

        while(population.getSchedule().get(0).getFitness() <  0.8) {
            population = geneticAlgorithm.evolve(population).sortByFitness();
        }
    }
    private void printDataCurrent(){
        data.getCourses().forEach(x -> {
            System.out.print(x + " | ");
        });
    }
}
