package jp.co.sss.shop.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class LoginCheckFilter extends HttpFilter {

@Override
public void doFilter(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain) throws IOException, ServletException {
    // リクエスト URL を取得
    String requestURL = request.getRequestURI();
    if (requestURL.endsWith("/loginWithValidation")) {
      //リクエスト URL が「ログイン画面への遷移処理」、
      //「ログイン処理」宛ての場合、ログインチェックを実施せず、
      //リクエスト対象のコントローラの処理に移る
        chain.doFilter(request, response);
    } else {
      //セッション情報を取得
        HttpSession session = request.getSession();
      //セッション情報からユーザのログイン情報（ユーザ ID）を取得
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
        //ログイン情報が存在しない場合（ログイン ID が null の場合）、
        //ログイン画面にリダイレクトする
        response.sendRedirect("/shop/loginWithValidation");
        return;
        } else {
        chain.doFilter(request, response);
        }
    }
}
}
