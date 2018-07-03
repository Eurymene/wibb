package fiona;

import fiona.wibb.Response;
import fiona.wibb.Wibb;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.http.HttpServletResponse;

import static fiona.wibb.Response.notFound;
import static fiona.wibb.Response.ok;
import static fiona.wibb.Users.*;
import static fiona.wibb.Wibb.addGet;


public class Main {
    public static void main(String[] args) throws Exception {

        addUser("arne","Arne de Both");
        addUser("fiona","Fiona de Both");
        addUser("henry","Henry Wilcox");
        addUser("lizzy","Elizabeth Bennet");


        addGet("/", req -> ok("met je heuf!"));
        addGet("/hello",req -> ok("hoi " + req.getQueryParameters().get("name")));

        addGet("/user", req -> {
            String id = req.getQueryParameters().get("id");
            if (getUsers().containsKey(id)) {
                return ok("User: " + getUsers().get(id).getName());
            } else {
                return notFound("No user found for id: "+ id);
            }
        });

        Wibb.start(8080);




    }
}
