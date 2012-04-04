

package com.assign2.business;

import com.assign2.Utils;
import com.assign2.data.CustomerAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 *
 * @author janjong
 */
public class CustomerHandler {


    public void UpdateExistingCustomer(Customer _customer, String column, String newValue) {
        Utils.log_info("Updating existing customer information");
        try {
            CustomerAccess.updateCustomer(_customer.getCustomerId(), column, newValue);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public Customer findCusomter(String column, String _value) {
        Customer _customer = new Customer();

        try {
            Utils.log_info("Searching for customer information");
            _customer = CustomerAccess.findCustomer(column, _value);


        } catch (SQLException ex) {

            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);

        }
        return _customer;
    }


    public static void saveNewCustomer(Customer customer) {
        Utils.log_info("Saving %s's information to database...", customer.getFirstName());

        try {
            CustomerAccess.addNewCustomer(customer);
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
        }
    }


    public Customer findCustomer(String column, String value) {
        try {
            Utils.log_info("Searching for customer information");
            Customer customer = CustomerAccess.findCustomer(column, value);
            return customer;
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
            return null;
        }
    }

    public static void removeCustomer(int customerId) {
        try {
            CustomerAccess.deleteCustomer(customerId);
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
        }
    }
}
