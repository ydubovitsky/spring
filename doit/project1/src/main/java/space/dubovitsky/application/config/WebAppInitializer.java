package space.dubovitsky.application.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                AopConfig.class,
                PersistenceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //! Описывает Диспетчер Сервлет
        return new Class[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
