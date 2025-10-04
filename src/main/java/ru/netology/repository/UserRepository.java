package ru.netology.repository;

import org.springframework.stereotype.Component;
import ru.netology.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("existing_user") && password.equals("right_password")) {
            var res =  new ArrayList<Authorities>();

            res.add(Authorities.READ);
            res.add(Authorities.WRITE);
            res.add(Authorities.DELETE);

            return res;
        }

        return new ArrayList<>();
    }
}
