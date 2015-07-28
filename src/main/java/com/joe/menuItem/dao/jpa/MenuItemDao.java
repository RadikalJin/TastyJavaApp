package com.joe.menuItem.dao.jpa;

import com.joe.menuItem.domain.MenuItem;

import java.util.List;

/**
 * Created by J on 27/07/2015.
 */
public interface MenuItemDao {

    public void persistMenuItem(MenuItem menuItem);
    public List<MenuItem> getAllMenuItems() throws Exception;
    public MenuItem getMenuItemById(Integer menuItemId) throws Exception;
    public void deleteMenuItemById(Integer menuItemId);
    public void updateMenuItem(MenuItem menuItem);
    public List<MenuItem> getMenuItemsByDescription(String description);

}
