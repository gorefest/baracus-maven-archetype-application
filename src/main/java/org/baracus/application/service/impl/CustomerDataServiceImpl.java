package org.baracus.application.service.impl;

import net.mantucon.baracus.annotations.Bean;
import net.mantucon.baracus.util.Logger;
import org.baracus.application.dao.CustomerDao;
import org.baracus.application.model.Customer;
import org.baracus.application.service.CustomerDataService;

/**
 * Created by marcus on 16.07.14.
 */
@Bean
public class CustomerDataServiceImpl implements CustomerDataService {

    final static Logger logger = new Logger(CustomerDataService.class); // create a logger

    @Bean
    CustomerDao customerDao; // Inject bean by type

    @Override
    public void initializeApplicationData() {

        logger.info("Begin initializing the data.");

        customerDao.save(new Customer("Meyer","John"));
        customerDao.save(new Customer("Harris","Frank"));
        customerDao.save(new Customer("Wu", "Elias"));
        customerDao.save(new Customer("Hattar","Muhammad"));
        customerDao.save(new Customer("Froehlich","Heinz"));
        customerDao.save(new Customer("Frosteau","Jaques"));
        customerDao.save(new Customer("Mugambe","Joseph"));
        customerDao.save(new Customer("Richter", "Franz"));
        customerDao.save(new Customer("Johnson","Jessica"));
        customerDao.save(new Customer("Pot","Fullerton"));

        logger.info("Done initializing the data. $1 customers written to database.", customerDao.loadAll().size());

    }
}
