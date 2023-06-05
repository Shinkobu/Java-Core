import java.util.Comparator;

public class WorkerComparator implements Comparator<BaseWorker> {
    @Override
    public int compare(BaseWorker o1, BaseWorker o2) {
        return (int) (o1.getAverageSalary(o1.rate) - o2.getAverageSalary(o2.rate));
    }
}
