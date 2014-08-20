package org.baracus.application;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import net.mantucon.baracus.annotations.Bean;
import net.mantucon.baracus.context.ManagedActivity;
import org.baracus.application.dao.CustomerDao;
import org.baracus.application.model.Customer;

import java.util.List;

@Bean
public class HelloAndroidActivity extends ManagedActivity {

    @Bean
    CustomerDao customerDao;

    CustomerListItemAdapter customerListItemAdapter;

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.customerTable);
        listView.setAdapter(null);

        customerListItemAdapter = new CustomerListItemAdapter(this,R.layout.customer_list_row);
        listView.setAdapter(customerListItemAdapter);

        List<Customer> allCustomers = customerDao.loadAll();
        for (Customer customer : allCustomers) {
            customerListItemAdapter.add(customer);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(org.baracus.application.R.menu.main, menu);
	return true;
    }

}

