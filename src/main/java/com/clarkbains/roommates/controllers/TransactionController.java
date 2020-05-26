package com.clarkbains.roommates.controllers;

import com.clarkbains.roommates.models.Database.Group;
import com.clarkbains.roommates.models.Database.IndividualTransactions;
import com.clarkbains.roommates.models.Database.Transactions;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Exceptions.NotAuthenticatedException;
import com.clarkbains.roommates.models.Request.AuthenticatedRequest;
import com.clarkbains.roommates.models.Request.Transaction.Single.AddTransaction;
import com.clarkbains.roommates.models.Response.Successes.Generic.ResourceResponse;
import com.clarkbains.roommates.models.Response.Successes.Group.GroupResponse;
import com.clarkbains.roommates.models.Response.Successes.Transactions.GetGroupTransaction;
import com.clarkbains.roommates.models.Response.Successes.Transactions.GetSingleTransaction;
import com.clarkbains.roommates.models.Response.Successes.User.UserResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/transaction")
public class TransactionController extends Main{
    @PostMapping(path="/single")
    public @ResponseBody  ResourceResponse<GetSingleTransaction> addTransaction(@Valid @RequestBody AddTransaction req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        Transactions r = transactionsRepository.save(Transactions.fromSingleTransactionReqAndUser(req,u));
        IndividualTransactions t = individualTransactionsRepository.save(new IndividualTransactions(r.getId(), req.getTargetUserId(), 1.0D));
        User owner = usersRepository.findFirstByIdEquals(req.getTargetUserId());
        UserResponse o = new UserResponse(owner);
        Boolean isOwedToSelf = req.getTargetUserId().equals(u.getId());
        return new ResourceResponse<>(new GetSingleTransaction(req.getAmount(),o,isOwedToSelf,req.getNote()));
    }
    @GetMapping(path="/single")
    public @ResponseBody  ResourceResponse<ArrayList<GetSingleTransaction> > getTransaction(@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        HashMap<Integer,Double> idToPercentage = new HashMap<>();
        for (IndividualTransactions t: individualTransactionsRepository.findAllByOwedByIdEquals(u.getId())){
            idToPercentage.put(t.transactionId, t.percentage);
        }
        Collection<Transactions> ct = (transactionsRepository.findAllByIdInAndGroupIdIsNull(List.copyOf(idToPercentage.keySet())));
        ArrayList<GetSingleTransaction> gst = new ArrayList<>();
        for (Transactions t: ct){
            Double amount = idToPercentage.get(t.getId())*t.getAmount();
            User owner = usersRepository.findFirstByIdEquals(t.getOwnerId());
            UserResponse o = new UserResponse(owner);
            Boolean isOwedToSelf = t.getOwnerId().equals(u.getId());
            GetSingleTransaction st = new GetSingleTransaction(amount, o,isOwedToSelf,t.getNote());
            gst.add(st);
        }
        return new ResourceResponse<>(gst);
    }
    @GetMapping(path="/group")
    public @ResponseBody  ResourceResponse<ArrayList<GetGroupTransaction> > getGroupTransactions(@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        HashMap<Integer,Double> idToPercentage = new HashMap<>();
        for (IndividualTransactions t: individualTransactionsRepository.findAllByOwedByIdEquals(u.getId())){
            idToPercentage.put(t.transactionId, t.percentage);
        }
        ArrayList<GetGroupTransaction> ggt = new ArrayList<>();
        for (Transactions t: transactionsRepository.findAllByIdInAndGroupIdIsNotNull(List.copyOf(idToPercentage.keySet()))){
            Double amount = idToPercentage.get(t.getId())*t.getAmount();
            User owner = usersRepository.findFirstByIdEquals(t.getOwnerId());
            UserResponse o = new UserResponse(owner);
            GroupResponse g  = new GroupResponse(groupsRepository.findFirstByIdEquals(t.getGroupId()), o);
            Boolean isOwedToSelf = t.getOwnerId().equals(u.getId());
            GetGroupTransaction st = new GetGroupTransaction(amount, o,isOwedToSelf,t.getNote(),g);
            ggt.add(st);
        }
        return new ResourceResponse<>(ggt);
    }
}
