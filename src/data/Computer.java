package data;

import java.util.Comparator;

public class Computer implements Comparable<Computer> {
    private String name;
    private Integer cpu;
    private Integer memory;

    public Computer(String name, int cpu, int memory) {
        this.name = name;
        this.cpu = cpu;
        this.memory = memory;
    }

    public static class ComputerNameComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer c1, Computer c2) {
            return c1.getName().compareTo(c2.getName());
        }
    }
    public static class ComputerCpuComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer c1, Computer c2) {
            return c1.getCpu().compareTo(c2.getCpu());
        }
    }
    public static class ComputerMemoryComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer c1, Computer c2) {
            return c1.getMemory().compareTo(c2.getMemory());
        }
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
        if(this.cpu > computer.cpu)
            return -1;
        else if(this.cpu < computer.cpu)
            return 1;
        else if(this.memory > computer.memory)
            return -1;
        else if(this.memory < computer.memory)
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