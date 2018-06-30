package fiona.wibb;

import javax.servlet.http.HttpServletResponse;

public class Response {
    private Object data;
    private int status;

    public Response(Object data, int status) {
        this.data = data;
        this.status = status;
    }

    public static Response ok(Object data) {
        return new Response(data,HttpServletResponse.SC_OK);
    }

    public static Response notFound(Object data){
        return new Response(data,HttpServletResponse.SC_NOT_FOUND);
    }

    public static Response response(Object data,int status){
        return new Response(data,status);
    }

    public Object getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}
