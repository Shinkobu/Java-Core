package ru.geekbrains.lesson3.sample01;

public class Human extends BaseHuman implements Runner {



    private  int maxRun;

    private  int maxJump;

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    {
        System.out.println("Initializer.");
        name = "noname";
        this.maxJump = 100;
        this.maxRun = 1000;
    }

    public Human() {
        this("noname");
        /*this.name = "noname";
        this.maxJump = 100;
        this.maxRun = 1000;*/
    }

    public Human(String name) {
        this(name, 1000);
        /*this.name = name;
        this.maxJump = 100;
        this.maxRun = 1000;*/
    }

    public Human(String name, int maxRun) {
        this(name, maxRun, 100);
        /*this.name = "noname";
        this.maxRun = maxRun;
        this.maxJump = maxJump;*/
    }

    public Human(String name, int maxRun, int maxJump) {
        super(name);
        System.out.println("Constructor.");
        if (name == null || name.length() < 3){
            this.name = "noname";
        }
        else{
            this.name = name;
        }
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    String displayInfo() {
        return String.format("Name: %s", name);
    }

    @Override
    public String toString() {

        return "Human{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }


}
