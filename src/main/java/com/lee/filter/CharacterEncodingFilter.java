package com.lee.filter;

import com.lee.pojo.IPRecord;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter  implements Filter{
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 从配置中获取字符编码
        encoding = filterConfig.getInitParameter("encoding");
        if (encoding == null) {
            encoding = "UTF-8"; // 默认使用 UTF-8 编码
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 设置请求和响应的字符编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        // 继续处理请求
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 清理资源（如果有的话）
    }
}