package design.intercept;
public class HtmlFilter implements Filter {
    @Override
    public void process(Request request, Response response, FilterChain chain) {
        String reqMessage = request.getReqMessage();
        request.setReqMessage(reqMessage + "->HtmlFilter");
        chain.doFilter(request, response, chain);
        response.setResponseMessage(response.getResponseMessage() + "<-HtmlFilter");
    }
}
