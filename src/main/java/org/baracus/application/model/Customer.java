package org.baracus.application.model;

import net.mantucon.baracus.orm.Field;
import net.mantucon.baracus.orm.FieldList;
import net.mantucon.baracus.orm.ModelBase;
import net.mantucon.baracus.orm.Timestamped;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marcus
 */
public class Customer extends ModelBase implements Timestamped{

    public static final String TABLE_CUSTOMER = "customer";

    private static int columnIndex= ModelBase.fieldList.size();

    private String lastName;
    private String firstName;
    private Date creationDate;
    private Date lastModificationDate;


    public static final FieldList fieldList = new FieldList(Customer.class.getSimpleName());
    public static final Field lastNameCol = new Field("last_name", columnIndex++);
    public static final Field firstNameCol = new Field("first_name", columnIndex++);
    public static final Field createDateCol = new Field("created", columnIndex++);
    public static final Field lastModifiedCol = new Field("last_modified", columnIndex++);

    static {
        fieldList.add(ModelBase.fieldList);
        fieldList.add(lastNameCol);
        fieldList.add(firstNameCol);
        fieldList.add(createDateCol);
        fieldList.add(lastModifiedCol);
    }

    public Customer() {
        super(TABLE_CUSTOMER);
    }

    public Customer(String lastName, String firstName) {
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }


}
