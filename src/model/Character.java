package model;

public class Character {
    public static final String ANSI_CYAN = "\u001B[36m";
    private String name;
    private int age;
    private String devilFruit;
    private String gangs;
    private int moneyRetrieval;

    public Character() {
    }

    public Character(String name, int age, String devilFruit, String gangs, int moneyRetrieval) {
        this.name = name;
        this.age = age;
        this.devilFruit = devilFruit;
        this.gangs = gangs;
        this.moneyRetrieval = moneyRetrieval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDevilFruit() {
        return devilFruit;
    }

    public void setDevilFruit(String devilFruit) {
        this.devilFruit = devilFruit;
    }

    public String getGangs() {
        return gangs;
    }

    public void setGangs(String gangs) {
        this.gangs = gangs;
    }

    public int getMoneyRetrieval() {
        return moneyRetrieval;
    }

    public void setMoneyRetrieval(int moneyRetrieval) {
        this.moneyRetrieval = moneyRetrieval;
    }

    @Override
    public String toString() {
        return String.format(ANSI_CYAN + "%-22s %-8d %-20s %-20s %-20d", name, age, devilFruit, gangs, moneyRetrieval);
    }
}
