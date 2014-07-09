package by.mvas.sprgr.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;

/**
 * Filter, used to avoid @ResponseBody's <i>produce</i> attribute
 *
 * @author mvas
 */
public class UTF8ResponseFilter implements Filter{

    Logger l = Logger.getLogger(UTF8ResponseFilter.class);
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        sr1.setContentType("text/html; charset=UTF-8");
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }
    
}
