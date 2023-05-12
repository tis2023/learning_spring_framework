package jp.co.sss.shop.filter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Message03Filter extends HttpFilter {
    @Override
    public void doFilter(
        HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        System.out.println("Done Message03Filter");
        chain.doFilter(request, response);
    }
}
