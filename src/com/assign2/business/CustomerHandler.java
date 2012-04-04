<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> upstream/master
package com.assign2.business;

import com.assign2.Utils;
import com.assign2.data.CustomerAccess;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
>>>>>>> upstream/master

/**
 *
 * @author janjong
 */
public class CustomerHandler {
<<<<<<< HEAD

    public void saveNewCustomer(Customer customer) {

        Utils.log_info("Sending new customer information to database");

        try {
            CustomerAccess.addNewCustomer(customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNumber());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

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

    public void removeCustomer(int CId) {
        try {
            CustomerAccess.deleteCustomer(CId);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
=======
    public static void saveNewCustomer(Customer customer) {
        Utils.log_info("Saving %s's information to database...", customer.getFirstName());

        try {
            CustomerAccess.addNewCustomer(customer);
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
        }
    }

    public static void updateExistingCustomer() {
        Utils.log_info("Updating existing customer information");
        throw new NotImplementedException();
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
>>>>>>> upstream/master
