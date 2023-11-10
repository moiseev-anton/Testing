package homework03.task3;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if (user.isAuthenticate){
           data.add(user);
       }
    }

    public void logoutAllExceptAdmins(){
        for (User user : data){
            if (!user.isAdmin) {
                user.isAuthenticate = false;
            }
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}