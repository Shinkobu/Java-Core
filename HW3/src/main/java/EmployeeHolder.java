import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

class EmployeeHolder implements Iterable<BaseWorker>{

    private final List<BaseWorker> employees;

    public EmployeeHolder(List<BaseWorker> employees){
        this.employees = employees;
    }

    @NotNull
    @Override
    public Iterator<BaseWorker> iterator() {
        return employees.iterator();
    }

}