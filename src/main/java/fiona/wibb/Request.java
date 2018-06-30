package fiona.wibb;

import java.util.Map;

public class Request {
    private Map<String,String> queryParameters;

    public Request(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }
}
