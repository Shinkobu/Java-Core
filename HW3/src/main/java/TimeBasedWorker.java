public class TimeBasedWorker extends BaseWorker{

    public TimeBasedWorker(String name, Integer rate) {
        super(name, rate);
    }

    @Override
    protected Double getAverageSalary(Integer rate) {
        return 20.8 * 8 * rate;
    }

}
