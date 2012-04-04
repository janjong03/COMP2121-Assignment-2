
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assign2.business;

/**
 *
 * @author janjong
 */
public class OrderLine {
<<<<<<< HEAD

    private int orderId;
    private int itemId;
=======
    private Order order;
    private Item item;
>>>>>>> upstream/master
    private int quantity;
    private double total;

    public OrderLine() {
<<<<<<< HEAD
    }

    public OrderLine(int oId, int iID, int qty, double _total) {
        Order orderObj = new Order();
        Item itemObj = new Item();
        orderId = orderObj.getOrderId();
        itemId = itemObj.getItemId();
        quantity = qty;
        total = _total;
=======
>>>>>>> upstream/master
    }

    public OrderLine(Order order, Item item, int qty) {
        this.order = order;
        this.item = item;
        this.quantity = qty;
        this.total = item.getPrice() * qty;
    }

    public Order getOrder() {
        return order;
    }

    /**
     * @param order the orderId to set
     */
    public OrderLine setOrder(Order order) {
        this.order = order;
        return this;
    }

    /**
     * @return the itemId
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the itemId to set
     */
    public OrderLine setItem(Item item) {
        this.item = item;
        return this;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public OrderLine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public OrderLine setTotal(double total) {
        this.total = total;
        return this;
    }
}
