package design.intercept;
public class Test {
    public static void main(String[] args){
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter());
        chain.addFilter(new SensitiveFilter());
        Request request = new Request();
        request.setReqMessage("request");
        Response response = new Response();
        response.setResponseMessage("response");
        chain.doFilter(request, response, chain);
        System.out.println(request.getReqMessage());
        System.out.println(response.getResponseMessage());
    }
}
