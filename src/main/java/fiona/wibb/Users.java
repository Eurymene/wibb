package fiona.wibb;

import java.util.HashMap;

public class Users {
    private static HashMap<String,User> users = new HashMap<>();

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void addUser(String id,String name){
        users.put(id,new User(id,name));
    }
}
