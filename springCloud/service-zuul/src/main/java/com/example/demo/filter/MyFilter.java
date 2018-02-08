package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log  = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
     Spring Cloud Config provides server and client-side support for externalized(外化,客观化，具体化) configuration in a distributed(分布式的) system.
     With the Config Server you have a central place to manage external properties for applications across(穿过) all environments.
     The concepts(概念) on both client and server map identically(相同地) to the Spring Environment and PropertySource abstractions(抽象),
     so they fit(合适) very well with Spring applications, but can be used with any application running in any language.
     As an application moves through the deployment(部署，调用) pipeline(管道) from dev to test and into production you can manage the configuration
     between those environments and be certain that applications have everything they need to run when they migrate(迁移).
     The default implementation of the server storage backend(后台) uses git so it easily supports labelled versions of configuration environments,
     as well as being accessible to a wide range(范围) of tooling(加工) for managing the content.
     It is easy to add alternative implementations(实现) and plug(填入) them in with Spring configuration.
     */

    /**
     *Spring cloud Config提供服务和客户端提供了在分布式系统中配置外化的支持,
     *伴随Config服务你有一个中心去管理所有环境的应用的配置文件，
     *原理是在客户端和服务端映射相同抽象配置源到spring环境上,
     *这样它可以非常完美的适配任何Spring的应用，甚至能在任何的语言的应用上运行
     *当一个应用通过部署管道从开发环境到测试环境再到生产环境迁移你可以管理这些配置，
     *默认实现使用Git的后台存储因此它标记配置的环境和版本标的更加容易,并且这些配置的内容可以被更广泛的访问加工和管理。
     *
     */
    @Override
    public Object run() {
       RequestContext ctx = RequestContext.getCurrentContext();
       HttpServletRequest request = ctx.getRequest();
       log.info(String.format("%s>>>%s",request.getMethod(),request.getRequestURL().toString()));
       Object accessToken =request.getParameter("token");
       if(accessToken == null){
           log.warn("token is empty");
           ctx.setSendZuulResponse(false);
           ctx.setResponseStatusCode(401);
           try{
               ctx.getResponse().getWriter().write("token is empty");
           }catch (Exception e){}
           return null;
       }
       log.info("ok");
       return null;
    }
}