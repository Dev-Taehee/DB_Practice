package mongo.mongopractice.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mongo.mongopractice.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/mongo")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/find")
    public String findUserData(@RequestParam String name) {
        return userService.selectUser(name);
    }

    @GetMapping(value = "/save")
    public String saveUserData(@RequestParam String name, @RequestParam int age) {
        log.info("[Controller][Recv] name: {}, age: {}", name, age);
        userService.saveUser(name, age);

        return userService.selectUser(name);
    }

}
