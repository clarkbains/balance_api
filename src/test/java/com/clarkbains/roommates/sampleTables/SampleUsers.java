package com.clarkbains.roommates.sampleTables;

import com.clarkbains.roommates.models.Database.User;

import java.util.ArrayList;
import java.util.Collection;

public class SampleUsers {
    public static ArrayList<User> getSampleUsers (){
        ArrayList<User> ret = new ArrayList<>();
        ret.add(new User("Fred","fred@gmail.com",User.hashPassword("passw0rd")));
        //Password: hash
        ret.add(new User("Clark","me@clarkbains.com",User.hashPassword("null")));
        //Password: dogs
        ret.add(new User("Izzy","isabella@gmail.com",User.hashPassword("no0dlesAndM0jo")));
        //Password: dogs
        ret.add(new User("Ryan","elvispresgoat@hotmain.com",User.hashPassword("yamcine_l0ver")));
        ret.add(new User("Aver","elvispresgoat@hotmain.com",User.hashPassword("i_am_speed")));
        return ret;

    }
}
