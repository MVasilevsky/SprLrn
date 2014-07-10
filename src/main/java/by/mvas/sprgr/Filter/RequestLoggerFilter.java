package by.mvas.sprgr.Filter;

import by.mvas.sprgr.preprocessing.SLLog;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author mvas
 */
@Component
public class RequestLoggerFilter implements Filter{
    
    @SLLog
    private Logger log;

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("request received: " + request);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}
