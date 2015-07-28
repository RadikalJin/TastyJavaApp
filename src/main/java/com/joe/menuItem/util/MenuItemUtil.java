package com.joe.menuItem.util;

import com.joe.menuItem.domain.MenuItem;
import com.joe.menuItem.dto.MenuItemDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 27/07/2015.
 */
public class MenuItemUtil {

    public static MenuItem updateMenuItemDomainProperties(MenuItem oldItem, MenuItem newItem) {
        oldItem.setDescription(newItem.getDescription());
        oldItem.setPrice(newItem.getPrice());
        return oldItem;
    }

    public static List<MenuItemDto> convertMenuItemDomainsToDtos(List<MenuItem> menuItems) {
        List<MenuItemDto> menuItemDtos = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            menuItemDtos.add(convertMenuItemDomainToDto(menuItem));
        }
        return menuItemDtos;
    }

    public static MenuItemDto convertMenuItemDomainToDto(MenuItem menuItem) {
        MenuItemDto menuItemDto = new MenuItemDto();
        if (menuItem.getId() != null) {
            menuItemDto.setId(String.valueOf(menuItem.getId()));
        }
        menuItemDto.setDescription(menuItem.getDescription());
        menuItemDto.setPrice(menuItem.getPrice());
        return menuItemDto;
    }

    public static MenuItem convertMenuItemDtoToDomain(MenuItemDto menuItemDto) {
        MenuItem menuItem = new MenuItem();
        if (menuItemDto.getId() != null) {
            menuItem.setId(Integer.parseInt(menuItemDto.getId()));
        }
        menuItem.setDescription(menuItemDto.getDescription());
        menuItem.setPrice(menuItemDto.getPrice());
        return menuItem;
    }

}
