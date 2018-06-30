package fiona.wibb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WibbServlet extends HttpServlet {
    Map<String,Endpoint> endpoints;

    @Override
    public void init(){
        endpoints = Wibb.getEndpoints();
    }
        
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String queryString = req.getQueryString();
        Map<String,String> queries = parseQuery(queryString);
        Endpoint endpoint = endpoints.get(pathInfo);

        
        
        resp.setContentType("text/plain");


        Object output="";

        if(Objects.isNull(endpoint)){
            output = "yow gekke drol";
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        else{
            Response response = endpoint.handle(new Request(queries));
            output = response.getData();
            resp.setStatus(response.getStatus());
        }

        resp.getWriter().println(output);
    }

    private Map<String,String> parseQuery(String query){
        if(query==null){
            return new HashMap<>();
        }
        String[] queries = query.split("&");
        return Arrays.stream(queries)
                .map(q -> q.split("="))
                .collect(Collectors.toMap(x -> x[0],x -> x.length<2 ? "" : x[1]));

    }
}
