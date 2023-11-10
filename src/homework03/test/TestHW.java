//package homework03.test;

import homework03.task1_2.*;
import homework03.task3.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestHW {
    private NumberChecker checker;

    @BeforeEach
    public void setUp(){
        checker = new NumberChecker();
    }

    @ParameterizedTest
    @ValueSource(ints = {-6, 0, 8})
    void testEvenNumber(int n){
        assertTrue(checker.evenOddNumer(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, 1, 9})
    void testOddNumber(int n){
        assertFalse(checker.evenOddNumer(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    void testNumberInInterval(int n){
        assertTrue(checker.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-50, 0, 25, 100, 150})
    void testNumberNotInInterval(int n){
        assertFalse(checker.numberInInterval(n));
    }


    @Test
    void testLogoutAllExceptAdmins() {
        UserRepository userRepository = new UserRepository();

        User admin = new User("admin1", "pass", true);
        User regularUser = new User("user1", "pass", false);

        admin.authenticate("admin1", "pass");
        regularUser.authenticate("user1", "pass");

        userRepository.addUser(admin);
        userRepository.addUser(regularUser);

        assertTrue(admin.getIsAuthenticate());
        assertTrue(regularUser.getIsAuthenticate());

        userRepository.logoutAllExceptAdmins();

        assertTrue(admin.getIsAuthenticate());
        assertFalse(regularUser.getIsAuthenticate());
    }
}
