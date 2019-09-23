package com.liyang.interceptor;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.liyang.common.RedisUtils;
import com.liyang.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisUtils redisUtils;

    private long start =0L;
    private long end = 0L;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception{
        /**
         * 预处理回调方法，实现处理器的预处理
         * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
         */

        start = System.currentTimeMillis();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        Map<String, String[]> map = request.getParameterMap();
        String token = null;
        for (Map.Entry<String, String[]> param : map.entrySet()) {
            String key = param.getKey();  // 参数名
            token = StringUtils.join(param.getValue());  // 参数值
        }

        if("".equals(token) || token == null){
            pw.print("token不能未空");
            return false;
        }
        User user = (User)redisUtils.get(token);
        if(user == null){
            pw.print("未获取到用户信息");
            return false;
        }
        response.reset();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /**
         * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
         * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
         */
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        /**
         * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
         * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
         * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
         * 但仅调用处理器执行链中
         */
        end = System.currentTimeMillis();
        long diff = end -start;
        logger.info(httpServletRequest.getRequestURL()+"耗时:"+diff);
    }
}
