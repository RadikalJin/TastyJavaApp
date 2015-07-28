package com.joe.menuItem.service;

import com.joe.menuItem.dto.MenuItemDto;

import java.util.List;

/**
 * Created by J on 27/07/2015.
 */
public interface MenuItemService {

    public List<MenuItemDto> getAllMenuItems() throws Exception;
    public void persistMenuItem(MenuItemDto menuItemDto) throws Exception;
    public MenuItemDto getMenuItemById(Integer menuItemId) throws Exception;
    public void deleteMenuItemById(Integer menuItemId) throws Exception;
    public List<MenuItemDto> getMenuItemsByDescription(String description);
    public void updateMenuItem(final MenuItemDto menuItemDto);

}
