package org.baracus.application.service;

import net.mantucon.baracus.annotations.Bean;
import net.mantucon.baracus.dao.ConfigurationDao;
import net.mantucon.baracus.lifecycle.Destroyable;
import net.mantucon.baracus.lifecycle.Initializeable;
import net.mantucon.baracus.model.ConfigurationParameter;

/**
 * Created with IntelliJ IDEA.
 * User: marcus
 *
 * Example configuration service. Extend this one to make use of the application configuration
 * BARACUS is offering you. This is the only place where access on the ConfigurationDao should
 * happen, so you should encapsulate all configuration elements with methods
 *
 */

@Bean
public class ConfigurationService implements Initializeable, Destroyable {

    @Bean
    ConfigurationDao configurationDao;

    private static final String KEY_APP_INIT_DONE="APPL_INIT_DONE";

    private static enum YesNo {
        YES,
        NO
    }

    /**
     * @return true, if the application data has been initialized
     */
    public boolean isApplicationInitializationDone() {
        ConfigurationParameter parameter= configurationDao.getByName(KEY_APP_INIT_DONE);
        if (parameter != null) {
            return YesNo.YES.toString().equals(parameter.getConfigParameterValue());
        }
        return false;
    }

    /**
     * set the app data init flag
     * @param isEnabled  - true or false indicating state of initialization
     */
    public void setApplicationInitializationDone(boolean isEnabled) {
        ConfigurationParameter parameter= configurationDao.getByName(KEY_APP_INIT_DONE);

        if (parameter == null) {
            parameter = new ConfigurationParameter();
            parameter.setConfigParameter(KEY_APP_INIT_DONE);
        }

        parameter.setConfigParameterValue(isEnabled ? YesNo.YES.toString()
                                                    : YesNo.NO.toString());

        configurationDao.save(parameter);

    }


    @Override
    public void onDestroy() {
        // Insert some context shutdown stuff here
    }

    @Override
    public void postConstruct() {
        // Insert some bean-ready action here
    }

}
