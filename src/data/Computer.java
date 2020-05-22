package data;

import java.util.Comparator;

public class Computer implements Comparable<Computer> {
    private String name;
    private Integer cpu;
    private Integer memory;

    public Computer(String name, Integer cpu, Integer memory) {
        this.name = name;
        this.cpu = cpu;
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public int compareTo(Computer computer) {
        //w zależności od znaku czyli +1 albo -1 będzie sortowanie rosnąco lub malejąco
        if (this.cpu > computer.cpu)
            return -1;
        else if (this.cpu < computer.cpu)
            return 1;
        else if (this.memory > computer.memory)
            return -1;
        else if (this.memory < computer.memory)
            return 1;
        else
            return -this.name.compareTo(computer.name);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }
}