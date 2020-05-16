package com.clarkbains.roommates.controllers;

import com.clarkbains.roommates.models.Database.Session;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Request.AuthenticatedRequest;
import com.clarkbains.roommates.models.Exceptions.NotAuthenticatedException;
import com.clarkbains.roommates.models.Request.User.login.Public.getUser;
import com.clarkbains.roommates.models.Response.Errors.Generic.AuthError;
import com.clarkbains.roommates.models.Response.Response;
import com.clarkbains.roommates.models.Response.Successes.User.Public.PublicName;
import com.clarkbains.roommates.models.Response.Successes.User.login.Post;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

@RestController // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController extends Main{

    @PostMapping(path="") // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@Valid @RequestBody com.clarkbains.roommates.models.Request.User.Post req){
        if (usersRepository.getUser(req.getEmail()).size()>0){
            return null;
        }
        User n = new User();
        n.setName(req.getName());
        n.setEmail(req.getEmail());
        n.setVerified(true);
        n.setPasswordHash(User.hashPassword(req.getPassword()));
        usersRepository.save(n);
        return n;
    }
    @GetMapping(path = "/login")
    public @ResponseBody
    Response loginUser (@Valid @RequestBody com.clarkbains.roommates.models.Request.User.login.Post req){
        User u = usersRepository.getUser(req.getEmail(), User.hashPassword(req.getPassword())).stream().findFirst().orElse(null);
        if (u!=null)
            if (u.isVerified()){
                    Session s = new Session();
                    s.setUserId(u.getId());
                    //Avoid Session token overlaps
                    do {
                       s.setSessionToken(Session.generateToken());
                    }while (sessionsRepository.findBySessionToken(s.getSessionToken()).size()!=0);
                    s.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    s.setExpiryDate(new Timestamp(System.currentTimeMillis()+3600000));
                    sessionsRepository.save(s);
                    Post response = new Post(s.getSessionToken(), s.getExpiryDate());
                    return response;

            }
        return new AuthError();

    }
    @GetMapping(path = "")
    public @ResponseBody
    User getUser (@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        return u;
    }
    @GetMapping(path = "/public")
    public @ResponseBody
    User getUser (@Valid @RequestBody getUser req) {
        usersRepository.findFirstById(req.getId());
        PublicName resp = new PublicName();

    }



}