package chernikova.s.a.TDD.models;

import chernikova.s.a.TDD.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getCompanyName() {
        User user = new User();
        user.setCompanyName("Company");

        assertEquals("Company", user.getCompanyName());
    }

    @Test
    void getINN() {
        User user = new User();

        user.setINN("1234");
        assertEquals("1234", user.getINN());
    }

    @Test
    void getOGRN() {
        User user = new User();

        user.setOGRN("1234");
        assertEquals("1234", user.getOGRN());
    }

    @Test
    void getName() {
        User user = new User();

        user.setName("1234");
        assertEquals("1234", user.getName());
    }

    @Test
    void getSurname() {
        User user = new User();

        user.setSurname("1234");
        assertEquals("1234", user.getSurname());
    }

    @Test
    void getLastname() {
        User user = new User();

        user.setLastname("1234");
        assertEquals("1234", user.getLastname());
    }

    @Test
    void getEmail() {
        User user = new User();

        user.setEmail("1234");
        assertEquals("1234", user.getEmail());
    }

    @Test
    void getPassword() {
        User user = new User();

        user.setPassword("1234");
        assertEquals("1234", user.getPassword());
    }

    @Test
    void isVerified() {
        User user = new User();

        user.setVerified(false);
        assertEquals(false, user.isVerified());
    }

}