package design.intercept;
public class SensitiveFilter implements Filter {

    @Override
    public void process(Request request, Response response, FilterChain chain) {
        request.setReqMessage(request.getReqMessage() + "->SensitiveFilter");
        chain.doFilter(request, response, chain);
        response.setResponseMessage(response.getResponseMessage() + "<-SensitiveFilter");
    }
}
