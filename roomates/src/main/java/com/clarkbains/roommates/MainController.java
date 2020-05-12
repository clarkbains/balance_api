package com.clarkbains.roommates;

import com.clarkbains.roommates.DatabaseModels.Session;
import com.clarkbains.roommates.DatabaseModels.User;
import com.clarkbains.roommates.DatabaseRepositories.SessionsRepository;
import com.clarkbains.roommates.DatabaseRepositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Collection;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    private UsersRepository usersRepository;
    @Autowired
    private SessionsRepository sessionsRepository;

    @PostMapping(path="/user/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        usersRepository.save(n);
        Session f = new Session();
        f.setSessionToken("asffdfsd");
        f.setCreateDate(new Timestamp(System.currentTimeMillis()));
        sessionsRepository.save(f);
        Collection<Session> yeet = sessionsRepository.getSessions(2);
        for (Session a:yeet){
            System.out.print("is: ");
            System.out.println(a.getSessionToken());
        }
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return usersRepository.findAll();
    }
    @GetMapping(path="/sessions")
    public @ResponseBody Iterable<Session> getAllSessions() {
        // This returns a JSON or XML with the users
        return sessionsRepository.findAll();
    }
}