package jp.co.sss.shop.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class Message01Filter extends HttpFilter {

    @Override
    public void doFilter(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain
        ) throws IOException, ServletException {
        System.out.println("Done Message01Filter");
        chain.doFilter(request, response);
    }
}
