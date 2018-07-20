package fiona;

import fiona.wibb.Response;
import fiona.wibb.Users;
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

        Users users = new Users();


        addGet("/", req -> ok("met je heuf!"));
        addGet("/hello",req -> ok("hoi " + req.getQueryParameters().get("name")));

        addGet("/user", req -> {
            String id = req.getQueryParameters().get("id");
            if (users.getUsers().containsKey(id)) {
                return ok("User: " + users.getUsers().get(id).getName());
            } else {
                return notFound("No user found for id: "+ id);
            }
        });

        Wibb.start(8080);




    }
}
