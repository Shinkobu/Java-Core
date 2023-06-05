/*
1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков)
и фиксированной оплатой (второй потомок).
а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
в) ** Реализовать интерфейсы для возможности сортировки массива (обратите ваше внимание на интерфейсы Comparator, Comparable)
г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        BaseWorker[] workers = {
                new FixedWorker("Pavel", 30000),
                new FixedWorker("Igor", 50000),
                new FixedWorker("Nikolay", 150000),
                new TimeBasedWorker("Sasha", 500),
                new TimeBasedWorker("Peter", 700),
                new TimeBasedWorker("Yuriy", 850)};

        BaseWorker[] workers1 = workers.clone();
        System.out.println("Unsorted array:");
        for (BaseWorker value : workers) {
            System.out.println("Worker " + value.name + " has salary " + value.getAverageSalary(value.rate));
        }
        System.out.println();
        System.out.println("Sorted array (via Comparable):");
        Arrays.sort(workers);
        for (BaseWorker value : workers) {
            System.out.println("Worker " + value.name + " has salary " + value.getAverageSalary(value.rate));

        }

        Comparator <BaseWorker> myComparator = new WorkerComparator();
        System.out.println();
        System.out.println("Sorted array (via Comparator):");
        Arrays.sort(workers1, myComparator);
        for (BaseWorker value : workers1) {
            System.out.println("Worker " + value.name + " has salary " + value.getAverageSalary(value.rate));

        }
        System.out.println();
        System.out.println("Array from class WorkersArray using foreach");
        for (BaseWorker value: WorkersArray.workers){
            System.out.println("Worker " + value.name + " has salary " + value.getAverageSalary(value.rate));

        }



    }
}

