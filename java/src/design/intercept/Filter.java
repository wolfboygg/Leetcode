package design.intercept;
public interface Filter {
    void process(Request request, Response response, FilterChain chain);
}
