package ru.geekbrains.lesson3.sample01;

public class Robot extends BaseRobot implements Runner {
    private  int maxRun;

    private  int maxJump;
    private String name;


    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    public Robot(String name, int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
    }


}
