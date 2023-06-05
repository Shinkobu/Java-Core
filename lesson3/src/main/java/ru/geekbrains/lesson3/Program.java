package ru.geekbrains.lesson3;

import ru.geekbrains.lesson3.sample01.*;

public class Program {

    public static void main(String[] args) {
        Human human = new Human("Станислав", 100, 10);
        System.out.println(human);
        BaseHuman human2 = new Human("Станислав", 100, 10);
        System.out.println(human2);
        Object human3 =  new Human("Станислав", 100, 10);
        System.out.println(human3);

        Runner[] runners = {
                new Cat("Барсик", 1500, 300),
                new Cat("Персик", 1700, 220),
                new Robot("R2D2", 99999, 0),
                new Robot("C3PO", 5000, 30),
                new Human("Петр", 3000, 350),
                new Human("Василий", 2500, 250),
        };

        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(30),
                new Track(1500),
                new Wall(140),
                new Track(3000),
                new Wall(300)
        };

        for (Runner runner : runners) {
            for (Obstacle obstacle : obstacles){
                if (obstacle instanceof Track){
                    if (!runner.run(obstacle.getLength()))
                        break;
                }
                else if (obstacle instanceof Wall){
                    if (!runner.jump(obstacle.getHeight()))
                        break;
                }
            }
        }


    }

}
