public class WorkersArray {

    static BaseWorker[] workers = {
            new FixedWorker("Pavel", 30000),
            new FixedWorker("Igor", 50000),
            new FixedWorker("Nikolay", 150000),
            new TimeBasedWorker("Sasha", 500),
            new TimeBasedWorker("Peter", 700),
            new TimeBasedWorker("Yuriy", 850)};


}
