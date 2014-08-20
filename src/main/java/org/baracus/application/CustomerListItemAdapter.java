package org.baracus.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import net.mantucon.baracus.util.DateUtil;
import org.baracus.application.model.Customer;

/**
 * Created by marcus on 24.06.14.
 *
 * A custom ListItemAdapter to handle Customer entities
 *
 */
public class CustomerListItemAdapter extends ArrayAdapter<Customer> {

    private View view;

    public CustomerListItemAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    /**
     * inflate another table row and fill it with the customer data at the passed position
     *
     * @param position - the position
     * @param convertView - the view which is used to inflate
     * @param parent - the parent view group
     * @return a row instance
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;

        if (view == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.customer_list_row, null);
        }

        Customer item = getItem(position);
        addItem(item);

        return view;
    }


    /**
     * add customer to table view
     *
     * @param object
     */
    private void addItem(Customer object) {
        LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = vi.inflate(R.layout.customer_list_row, null);

        TextView id = (TextView) view.findViewById(R.id.customerId);
        TextView lastName = (TextView) view.findViewById(R.id.customerLastName);
        TextView firstName = (TextView) view.findViewById(R.id.customerFirstName);
        TextView created = (TextView) view.findViewById(R.id.customerCreated);
        TextView modified = (TextView) view.findViewById(R.id.customerLastModified);

        id.setText(object.getId().toString());
        lastName.setText(object.getLastName());
        firstName.setText(object.getFirstName());
        created.setText(DateUtil.toEuropeanDate(object.getCreationDate()));
        modified.setText(DateUtil.toEuropeanDate(object.getLastModificationDate()));

    }

}
