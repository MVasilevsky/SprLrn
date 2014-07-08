package by.mvas.sprgr.preprocessing;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor for instantiaton loggers, marked with @SLLog annotation
 *
 * @author mvas
 */
@Component
public class SprLrnBeanPostProcessor implements BeanPostProcessor {

    Logger log = Logger.getLogger(SprLrnBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.getAnnotation(SLLog.class) != null) {
                try {
                    boolean access = f.isAccessible();
                    f.setAccessible(true);
                    f.set(bean, Logger.getLogger(bean.getClass()));
                    f.setAccessible(access);
                    log.info("Setting logger to bean " + beanName);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    log.error("Can't instantiate logger to bean " + beanName + ". Exception: " + ex.getLocalizedMessage());
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
