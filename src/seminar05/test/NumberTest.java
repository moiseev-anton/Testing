package seminar05.test;

import org.junit.jupiter.api.Test;
import seminar05.number.MaxNumberModule;
import seminar05.number.RandomNumberModule;
//import

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class NumberTest {
    //5.1.
    @Test
    void testGeneratorRandNums(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        int [] array = randomNumberModule.generatorRandNums(3);
        assertThat(array).hasSize(3);
    }

    @Test
    void testFindMax(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int[] array = new int[]{2, 5, 9, 3, 8};
        assertThat(maxNumberModule.findMaxNum(array)).isEqualTo(9);
    }

    @Test
    void testIntegrate() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int [] array = randomNumberModule.generatorRandNums(3);
        int max = maxNumberModule.findMaxNum(array);
        Arrays.sort(array);
        assertThat(max).isEqualTo(array[array.length - 1]);
    }



    //5.2.

    //5.3.
}