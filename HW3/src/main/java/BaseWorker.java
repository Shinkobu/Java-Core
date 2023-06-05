import java.util.Comparator;

public abstract class BaseWorker implements Comparable<BaseWorker> {
    String name;

    public BaseWorker(String name, Integer rate) {
        this.name = name;
        this.rate = rate;
    }

    Integer rate;

    protected abstract Double getAverageSalary (Integer rate);

    public int compareTo(BaseWorker o) {
        int a = (int) (this.getAverageSalary(this.rate) - o.getAverageSalary(o.rate));
        return a;
    }
}
