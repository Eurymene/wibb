package fiona.users;

import java.util.HashMap;

public class Users {
    private HashMap<String,User> users = new HashMap<>();

    public Users() {
        addUser("arne", "Arne de Both");
        addUser("fiona", "Fiona de Both");
        addUser("henry", "Henry Wilcox");
        addUser("lizzy", "Elizabeth Bennet");
    }




    public HashMap<String, User> getUsers() {
        return users;
    }

    public void addUser(String id,String name){
        users.put(id,new User(id,name));
    }
}
