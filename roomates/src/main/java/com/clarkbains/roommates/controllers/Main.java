package com.clarkbains.roommates.controllers;


import com.clarkbains.roommates.models.Database.Repositories.*;
import com.clarkbains.roommates.models.Database.Session;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Request.AuthenticatedRequest;
import com.clarkbains.roommates.models.Exceptions.NotAuthenticatedException;
import com.clarkbains.roommates.models.Response.Errors.Generic.AuthError;
import com.clarkbains.roommates.models.Response.Errors.Generic.BodyFieldMissingError;
import com.clarkbains.roommates.models.Response.Errors.Generic.JsonError;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Timestamp;

@RestController // This means that this class is a Controller
public class Main{
    ObjectMapper objectMapper;
    @Autowired
    protected GroupsRepository groupsRepository;
    @Autowired
    protected SessionsRepository sessionsRepository;
    @Autowired
    protected UserGroupMembersRepository userGroupMembersRepository;
    @Autowired
    protected UsersRepository usersRepository;

    public  Main(){
         objectMapper = new ObjectMapper();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BodyFieldMissingError handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        BodyFieldMissingError err = new BodyFieldMissingError();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            err.getMissingFields().add(((FieldError) error).getField());
        });
        return err;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonProcessingException.class)
    public JsonError handleJSONException(
            JsonParseException ex)  {
        return new JsonError(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotAuthenticatedException.class)
    public AuthError handleNotAuthed(
            NotAuthenticatedException ex)  {
        return new AuthError();
    }
    public User getRequestor(@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
        sessionsRepository.removeAllByExpiryDateIsBefore(new Timestamp(System.currentTimeMillis()));
        Session s = sessionsRepository.findBySessionToken(req.getxAuth()).stream().findFirst().orElse(null);
        if (s == null){
            throw new NotAuthenticatedException();
        }
        User u = usersRepository.findFirstById(s.getUserId());
        if (u == null){
            throw new NotAuthenticatedException();
        }
        return u;

    }


}