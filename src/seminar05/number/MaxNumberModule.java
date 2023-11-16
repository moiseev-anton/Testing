package seminar05.number;

import java.util.List;

public class MaxNumberModule {
    public int findMaxNum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
}
