package Dev;

import java.util.ArrayList;
import java.util.List;

public class BatchOperations {
    public static <T> List<List<T>> getBatches(List<T> list, int batchSize) {
        int i = 0;
        List<List<T>> batches = new ArrayList<List<T>>();
        while (i < list.size()) {
            int nextInc = Math.min(list.size() - i, batchSize);
            List<T> batch = list.subList(i, i + nextInc);
            batches.add(batch);
            i = i + nextInc;
        }
        return batches;
    }
}
