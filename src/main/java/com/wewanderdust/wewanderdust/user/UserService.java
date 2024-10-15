package com.wewanderdust.wewanderdust.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @GetMapping
    public List<User> getUser() {
        return List.of(
                new User(1,
                        "furkan",
                        "XXXXXXXXXXXXXXXX",
                        "",
                        "",
                        "XXXXXXXXXXXXXXXX",
                        "XXXXXXXXXXXXXXXX",
                        "XXXXXXXXXXXXXXXX",
                        LocalDate.now(),
                        LocalDate.of(2000, 1, 1),
                        new String[1]));

    }
}
