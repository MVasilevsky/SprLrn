package by.mvas.sprgr.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * WTF Exception with registered listener
 * java.lang.IllegalArgumentException:
 * Inappropriate listener type by.mvas.sprgr.listener.RequestListener
 *
 * @author mvas
 */
public class RequestListener implements ApplicationListener<RequestHandledEvent> {

    @Override
    public void onApplicationEvent(RequestHandledEvent e) {
        Logger.getLogger(RequestListener.class).info(e.getDescription());
    }

}
