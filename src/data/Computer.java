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
            if (c1.getName() == null || c2.getName() == null) return compareNulls(c1.name, c2.name);
            return c1.getName().compareTo(c2.getName());
        }
    }

    public static class ComputerCpuComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer c1, Computer c2) {
            if (c1.getCpu() == null || c2.getCpu() == null) return compareNulls(c1.cpu, c2.cpu);
            return c1.getCpu().compareTo(c2.getCpu());
        }
    }

    public static class ComputerMemoryComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer c1, Computer c2) {
            if (c1.getMemory() == null || c2.getMemory() == null) return compareNulls(c1.memory, c2.memory);
            return c1.getMemory().compareTo(c2.getMemory());
        }
    }

    private static int compareNulls(Object o1, Object o2) {
        if (o1 != null && o2 == null) return -1;
        if (o1 == null && o2 == null) return 0;
        if (o1 == null && o2 != null) return 1;
        return 0;
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