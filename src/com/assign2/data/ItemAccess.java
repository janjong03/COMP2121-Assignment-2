/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assign2.data;

import com.assign2.Utils;
import com.assign2.business.Category;
import com.assign2.business.Item;
import java.awt.Image;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jason Recillo
 */
public class ItemAccess extends CommonAccess {
    public static final String ITEM_ID = "item_id";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "price";
    public static final String IMAGE = "image";
    public static final String QUANTITY_IN_STOCK = "quantity_in_stock";
    
    private ItemAccess() {
        super();
    }
    
    public static Item findItem(String column, String value) throws SQLException {
        Connection conn = dbConnect();
        Statement sqlStatement = conn.createStatement();
        
        String query = String.format("SELECT * FROM item WHERE %s='%s';", column, value);
        Utils.log_debug("Executing SQL query: %s", query);
        ResultSet resultSet = sqlStatement.executeQuery(query);
        
        if (!(resultSet.first())) {
            throw new SQLException("Result set returned no data.");
        }
        
        Item item = new Item();
        item.setItemId(resultSet.getInt(ITEM_ID));
        item.setName(resultSet.getString(NAME));
        item.setCategory(CategoryAccess.findCategory(CategoryAccess.CATEGORY_ID, resultSet.getString(CATEGORY)));
        item.setPrice(resultSet.getDouble(PRICE));
        item.setDescription(resultSet.getString(DESCRIPTION));
        // TODO: retrieve image from database and set it in code

        return item;
    }
    
    public void addNewItem(Item item) throws SQLException {
        addNewItem(item.getItemId(), item.getName(), item.getCategory(), item.getPrice(), item.getDescription(), item.getImage(), item.getQtyInStock());
    }
    
    public void addNewItem(int itemId, String name, Category category, double price, String description, Image image, int qtyInStock) throws SQLException {
        Connection conn = dbConnect();
        Statement sqlStatement = conn.createStatement();
        
        String query = "INSERT INTO item ";
        query += "(item_id, name, category, price, description, image, quantity_in_stock) ";
        query += String.format("VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                               itemId, name, category.getCategoryId(), price, description, null, qtyInStock);
        Utils.log_debug("Executing SQL query: %s", query);
        
        sqlStatement.executeUpdate(query);
    }
    
    public void deleteItem(Item item) throws SQLException {
        deleteItem(item.getItemId());
    }
    
    public void deleteItem(int itemId) throws SQLException {
        Connection conn = dbConnect();
        Statement sqlStatement = conn.createStatement();
        
        String query = String.format("DELETE FROM item WHERE item_id='%s';", itemId);
        Utils.log_debug("Executing SQL query: %s", query);
        
        sqlStatement.executeUpdate(query);
    }
    
    public void updateItem(Item item, String column, String newValue) throws SQLException {
        updateItem(item.getItemId(), column, newValue);
    }
    
    public void updateItem(int itemId, String column, String newValue) throws SQLException {
        Connection conn = dbConnect();
        Statement sqlStatement = conn.createStatement();
        
        String query = String.format("UPDATE item SET %s='%s' WHERE item_id=%s", column, newValue, itemId);
        Utils.log_debug("Executing SQL query: %s", query);
        
        sqlStatement.executeUpdate(query);
    }
    
    /**
     * Downloads the image for the specified item from the database and saves it to the user's temporary directory.
     * @param itemId
     * @return
     * @throws SQLException 
     */
    public static String getItemImage(int itemId) throws SQLException {
        Utils.log_info("Retrieving image for item %s from database...", itemId);
        Connection conn = dbConnect();
        Statement sqlStatement = conn.createStatement();
        
        String query = String.format("Select image from item WHERE item_id=%s", itemId);
        ResultSet result = sqlStatement.executeQuery(query);
        
        String imgData = "";
        int lengthOfFile = 0;
        if (result.next()) {
            try {
                imgData = result.getString(IMAGE);
                lengthOfFile = imgData.length();
            } catch (Exception ex) {
                if (ex.getClass() == SQLException.class || ex.getClass() == NullPointerException.class) {
                    throw new SQLException(String.format("Image was not found for item with item id=%s.", itemId));
                } else {
                    ex.printStackTrace();
                }
            }
        }
        byte[] img = new byte[lengthOfFile];
        
        InputStream readImg = result.getBinaryStream(IMAGE);
        try {
            int index = readImg.read(img, 0, lengthOfFile);
            
            File imageFile = File.createTempFile(String.format("item%s",itemId), ".jpg");
            DataOutputStream os = new DataOutputStream(new FileOutputStream(String.format(imageFile.getAbsolutePath(), itemId, index)));
            Utils.log_debug("Saved image in %s", imageFile.getAbsoluteFile());
            os.write(img);
            os.close();
        } catch (IOException ex) {
            Utils.log_error(ex.getMessage());
        }
        
        
        return null;
    }
}
