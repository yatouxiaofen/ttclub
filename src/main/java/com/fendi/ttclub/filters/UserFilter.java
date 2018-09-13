package com.fendi.ttclub.filters;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public class UserFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserFilter.class);

    /**
     * 要检查的 session 的名称
     */
    private String sessionKey;
    /**
     * 需要排除（不拦截）的URL的正则表达式
     */
    private Pattern excepUrlPattern;
    /**
     * 检查不通过时，转发的URL
     */
    private String forwardUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sessionKey = filterConfig.getInitParameter("sessionKey");

        String excepUrlRegex = filterConfig.getInitParameter("excepUrlRegex");
        if (!StringUtils.isBlank(excepUrlRegex)) {
            excepUrlPattern = Pattern.compile(excepUrlRegex);
        }

        forwardUrl = filterConfig.getInitParameter("forwardUrl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 如果 sessionKey 为空，则直接放行
        if (StringUtils.isBlank(sessionKey)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        /* 请求 http://127.0.0.1:8080/webApp/home.jsp?&a=1&b=2 时
         * request.getRequestURL()： http://127.0.0.1:8080/webApp/home.jsp
         * request.getContextPath()： /webApp
         * request.getServletPath()：/home.jsp
         * request.getRequestURI()： /webApp/home.jsp
         * request.getQueryString()：a=1&b=2
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        LOGGER.info("UserFilter doFilter servletPath:" + servletPath);
        // 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
        LOGGER.info("equals:" + servletPath.equals(forwardUrl) + ",matcher:" + excepUrlPattern.matcher(servletPath).matches());
        if (servletPath.endsWith(".css")
                ||servletPath.endsWith(".js")
                ||servletPath.endsWith(".jpg")
                ||servletPath.endsWith(".gif")
                ||servletPath.endsWith(".png")
                ||servletPath.equals(forwardUrl) || excepUrlPattern.matcher(servletPath).matches()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Object sessionObj = request.getSession().getAttribute(sessionKey);
        // 如果Session为空，则跳转到指定页面
        if (sessionObj == null) {
            String contextPath = request.getContextPath();
            String redirect = servletPath + "?" + StringUtils.defaultString(request.getQueryString());
            /*
             * login.jsp 的 <form> 表单中新增一个隐藏表单域：
             * <input type="hidden" name="redirect" value="${param.redirect }">
             *
             *  LoginServlet.java 的 service 的方法中新增如下代码：
             *  String redirect = request.getParamter("redirect");
             *  if(loginSuccess){
             *      if(redirect == null || redirect.length() == 0){
             *          // 跳转到项目主页（home.jsp）
             *      }else{
             *          // 跳转到登录前访问的页面（java.net.URLDecoder.decode(s, "UTF-8")）
             *      }
             *  }
             */
            response.sendRedirect(contextPath + StringUtils.defaultIfEmpty(forwardUrl, "/")
                    + "?redirect=" + URLEncoder.encode(redirect, "UTF-8"));
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
