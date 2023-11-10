package seminar03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminar03.coverage.SomeService;
import seminar03.tdd.*;



import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestSeminar03 {
    private User user;
    private SomeService someService;

    @BeforeEach
    public void setUpSomeService() {
        someService = new SomeService();
    }



    @ParameterizedTest
    @ValueSource(ints = {5,10,25})
    void testSomeServiceGetBuzz(int i) {
        assertThat(someService.fizzBuzz(i)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {3,9,18})
    void testSomeServiceGetFizz(int i) {
        assertThat(someService.fizzBuzz(i)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15,45,90})
    void testSomeServiceGetFizzBuzz(int i) {
        assertThat(someService.fizzBuzz(i)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,11,23})
    void testSomeServiceGetNoFizzBuzz(int i) {
        assertThat(someService.fizzBuzz(i)).isEqualTo(Integer.toString(i));
    }

    @Test
    void testLast6True() {
        int[] nums = {1, 2, 6};
        assertTrue(someService.firstLast6(nums));
    }

    @Test
    void testFirst6True() {
        int[] nums = {6, 2, 7};
        assertTrue(someService.firstLast6(nums));
    }

    @Test
    void testFirstLast6False() {
        int[] nums = {1, 2, 3};
        assertFalse(someService.firstLast6(nums));
    }

    @Test
    void testFirstLast6ForEmpty() {
        int[] nums = {};
        assertFalse(someService.firstLast6(nums));
    }


    @Test
    void testUserAuthTrue(){
        user = new User("admin","admin",true);
        assertTrue(user.authenticate("admin","admin"));
    }

    @Test
    void testUserAuthFalse(){
        user = new User("user1","password",false);
        assertFalse(user.authenticate("admin","admin"));
    }

    @Test
    void testUserAuth(){
        User user = new User("user", "pass", false);
        user.authenticate("user", "pass");
        UserRepository repository = new UserRepository();
        repository.addUser(user);
        assertThat(repository.data).contains(user);
    }

    @Test
    void testUserNotAuth(){
        User user = new User("user", "pass", false);
        user.authenticate("user", "pass1");
        UserRepository repository = new UserRepository();
        repository.addUser(user);
        assertThat(repository.data).doesNotContain(user);
    }

}
