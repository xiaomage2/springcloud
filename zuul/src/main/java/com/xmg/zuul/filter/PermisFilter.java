package com.xmg.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限过滤器
 */
public class PermisFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /**
         * 过滤规则
         * pre 路由之前
         * post
         * error
         * routr
         * static
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        //优先级
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行本次过滤
        return true;
    }

    @Override
    public Object run() {
        //执行过滤的逻辑
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String login = request.getParameter("login");
        if(login==null)
        {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type","text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }
        return null;
    }
}
