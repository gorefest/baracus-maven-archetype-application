package org.baracus.application.context;

import net.mantucon.baracus.context.BaracusApplicationContext;
import org.baracus.application.dao.CustomerDao;
import org.baracus.application.service.ConfigurationService;
import org.baracus.application.service.CustomerDataService;
import org.baracus.application.service.impl.CustomerDataServiceImpl;

/**
 * The application context. Mostly used for initializing the bean context
 */
public class ApplicationContext extends BaracusApplicationContext {

    // Here the application configuration is constructed
    static {
        // This one is mandatory since the open helper carries the information for the app database
        registerBeanClass(OpenHelper.class);

        // These are simple bean registrations
        registerBeanClass(ConfigurationService.class);
        registerBeanClass(CustomerDao.class);

        // This is a Interface/Implmementation style registration
        registerBeanClass(CustomerDataService.class, CustomerDataServiceImpl.class);

        // finally, we set a Post-Appcontext-Init hook
        setApplicationContextInitializer(new ApplicationInitializerCallback());
    }

}
