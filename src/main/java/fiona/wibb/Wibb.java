package fiona.wibb;

import fiona.wibb.WibbServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.HashMap;
import java.util.Map;

public class Wibb {

    private static Server server;
    private static Map<String,Endpoint> endpoints;

    static{
        endpoints = new HashMap<>();
    }

    static public void start(int port) throws Exception {
        server = new Server(port);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        ServletHolder servletHolder = handler.addServletWithMapping(WibbServlet.class, "/*");
        server.start();
        server.join();
    }

    static public void addGet(String path, Endpoint func) {
        endpoints.put(path,func);
    }

    static public Map<String,Endpoint> getEndpoints(){
        return endpoints;
    }


}
