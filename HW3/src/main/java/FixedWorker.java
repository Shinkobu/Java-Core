public class FixedWorker extends BaseWorker{

    public FixedWorker(String name, Integer rate) {
        super(name, rate);
    }

    @Override
    protected Double getAverageSalary(Integer rate) {
        return (double)rate;
    }


}
