package org.baracus.application.dao;

import android.content.ContentValues;
import android.database.Cursor;
import net.mantucon.baracus.annotations.Bean;
import net.mantucon.baracus.dao.BaseDao;
import net.mantucon.baracus.orm.Field;
import net.mantucon.baracus.orm.FieldList;
import org.baracus.application.model.Customer;

import java.util.Date;

import static net.mantucon.baracus.orm.ModelBase.idCol;
import static org.baracus.application.model.Customer.*;

/**
 * Implementation of a sample DAO
 */
@Bean
public class CustomerDao extends BaseDao<Customer> {

    /**
     *
     */
    public CustomerDao() {
        super(Customer.class);
    }

    private final RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
        @Override
        public Customer from(Cursor c) {
            Customer result = new Customer();

            final Long id = c.getLong(idCol.fieldIndex);
            result.setId(id);
            result.setLastName(c.getString(lastNameCol.fieldIndex));
            result.setFirstName(c.getString(firstNameCol.fieldIndex));
            result.setCreationDate(new Date(c.getLong(createDateCol.fieldIndex)));
            result.setLastModificationDate(new Date(c.getLong(lastModifiedCol.fieldIndex)));
            result.setTransient(false);

            return result;
        }

        @Override
        public String getAffectedTable() {
            return Customer.TABLE_CUSTOMER;
        }

        @Override
        public FieldList getFieldList() {
            return Customer.fieldList;
        }

        @Override
        public Field getNameField() {
            return Customer.lastNameCol;
        }

        @Override
        public ContentValues getContentValues(Customer customer) {
            ContentValues result = new ContentValues();
            if (customer.getId() != null) { result.put(idCol.fieldName, customer.getId()); }
            if (customer.getLastName() != null) { result.put(lastNameCol.fieldName, customer.getLastName()); }
            if (customer.getFirstName() != null) { result.put(firstNameCol.fieldName, customer.getFirstName()); }
            if (customer.getLastModificationDate() != null) { result.put(lastModifiedCol.fieldName, customer.getLastModificationDate().getTime());}
            if (customer.getCreationDate() != null) { result.put(createDateCol.fieldName, customer.getCreationDate().getTime());}
            return result;
        }
    };

    @Override
    public RowMapper<Customer> getRowMapper() {
        return rowMapper;
    }
}
