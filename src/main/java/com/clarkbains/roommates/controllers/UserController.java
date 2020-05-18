package com.clarkbains.roommates.controllers;
import com.clarkbains.roommates.models.Database.Session;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Exceptions.NotFoundException;
import com.clarkbains.roommates.models.Request.AuthenticatedRequest;
import com.clarkbains.roommates.models.Exceptions.NotAuthenticatedException;
import com.clarkbains.roommates.models.Request.User.AddUserRequest;
import com.clarkbains.roommates.models.Request.User.Public.GetPublicUserRequest;
import com.clarkbains.roommates.models.Request.User.login.LoginRequest;
import com.clarkbains.roommates.models.Response.Response;
import com.clarkbains.roommates.models.Response.Successes.Generic.ResourceResponse;
import com.clarkbains.roommates.models.Response.Successes.User.Public.PublicUserResponse;
import com.clarkbains.roommates.models.Response.Successes.User.UserResponse;
import com.clarkbains.roommates.models.Response.Successes.User.login.AuthenticatedLoginResponse;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Timestamp;

@RestController // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController extends Main{

    @PostMapping(path="") // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@Valid @RequestBody AddUserRequest req){
        if (usersRepository.findFirstByEmailEquals(req.getEmail())!=null){
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
    Response loginUser (@Valid @RequestBody LoginRequest req) throws NotAuthenticatedException {
        User u = usersRepository.findFirstByEmailEqualsAndPasswordHashEquals(req.getEmail(), User.hashPassword(req.getPassword()));
        if (u!=null)
            if (u.isVerified()){
                    Session s = new Session();
                    s.setUserId(u.getId());
                    //Avoid Session token overlaps
                    do {
                       s.setSessionToken(Session.generateToken());
                    }while (sessionsRepository.findFirstBySessionToken(s.getSessionToken())!=null);
                    s.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    s.setExpiryDate(new Timestamp(System.currentTimeMillis()+3600000));
                    sessionsRepository.save(s);
                    AuthenticatedLoginResponse response = new AuthenticatedLoginResponse(s.getSessionToken(), s.getExpiryDate());
                    return response;
            }
        throw new NotAuthenticatedException();
    }

    @GetMapping(path = "")
    public @ResponseBody
    UserResponse getUser (@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
        UserResponse u = (UserResponse) getRequestor(req);
        return u;
    }

    @GetMapping(path = "/public")
    public @ResponseBody
    ResourceResponse<PublicUserResponse> getPublicUser (@Valid @RequestBody GetPublicUserRequest req) throws NotFoundException {
        PublicUserResponse u = (PublicUserResponse) usersRepository.findFirstByIdEquals(req.getId());
        if (u == null){
            throw new NotFoundException();
        }
        return new ResourceResponse<>(u);

    }

}