/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assign2.business;

<<<<<<< HEAD
import com.assign2.data.CustomerAccess;
import com.assign2.data.ItemAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import com.assign2.Utils;
import com.assign2.data.ItemAccess;
import com.assign2.data.OrderAccess;
import com.assign2.data.OrderLineAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

>>>>>>> upstream/master
/**
 *
 * @author Jason Recillo
 */
public class OrderHandler {
    private OrderHandler() {
    }

    public void processNewOrder() {
    }

<<<<<<< HEAD
    public void addItemsToOrder(int itemId, int qty) {
        Item item= null;
        try {
            item = ItemAccess.findItem( ItemAccess.ITEM_ID, String.valueOf( itemId ) );
        } catch (SQLException ex) {
            Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        addItemsToOrder( item, qty );
=======
    public void addItemsToOrder(Order order, int itemId, int qty) throws SQLException {
        addItemsToOrder(order, ItemAccess.findItem(ItemAccess.ITEM_ID, String.valueOf(itemId)), qty);
>>>>>>> upstream/master
    }

    public void addItemsToOrder(Order order, Item item, int qty) {
        // checkIfOrderLineExists(order, item, qty)
        // check database for current order and item
        // if SQLException is thrown in function, return false
        // if query executes without error, return true
        // it's 12:31AM, no time to implement >:
    }
    
//    private boolean orderLineExists(Order order, Item item, int qty){
//        try {
//            OrderLine line = OrderLineAccess.findOrderLine(OrderAccess.ORDER_ID, String.valueOf(order.getOrderId()));
//            
//        } catch (Exception ex) {
//            if (ex.getClass() == SQLException.class) {
//                Utils.log_error(ex.getMessage());
//            } else if (ex.getClass() == IllegalArgumentException.class) {
//                Utils.log_error(ex.getMessage());
//            } else {
//                ex.printStackTrace();
//            }
//        }
//    }
}
