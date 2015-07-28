package com.joe.menuItem.service;

import com.joe.menuItem.dao.jpa.MenuItemDao;
import com.joe.menuItem.dao.jpa.MenuItemDaoImpl;
import com.joe.menuItem.domain.MenuItem;
import com.joe.menuItem.dto.MenuItemDto;
import com.joe.menuItem.util.MenuItemUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component(MenuItemServiceImpl.BEAN_NAME)
public class MenuItemServiceImpl implements MenuItemService {

    public static final String BEAN_NAME = "menuItemService";

    @Resource(name = MenuItemDaoImpl.BEAN_NAME)
    private MenuItemDao menuItemDao;


    @Transactional
    public List<MenuItemDto> getAllMenuItems() throws Exception {
        return MenuItemUtil.convertMenuItemDomainsToDtos(menuItemDao.getAllMenuItems());
    }

    @Transactional
    public void persistMenuItem(MenuItemDto menuItemDto) throws Exception {
        MenuItem menuItem = MenuItemUtil.convertMenuItemDtoToDomain(menuItemDto);
        if (! menuItemIsAlreadyPersisted(menuItem)) {
            menuItemDao.persistMenuItem(menuItem);
        }
    }

    @Transactional
    public MenuItemDto getMenuItemById(Integer menuItemId) throws Exception {
        MenuItem menuItemById = menuItemDao.getMenuItemById(menuItemId);
        if (menuItemById == null) {
            return null;
        } else {
            return MenuItemUtil.convertMenuItemDomainToDto(menuItemById);
        }
    }

    @Transactional
    public void deleteMenuItemById(Integer menuItemId) throws Exception {
        menuItemDao.deleteMenuItemById(menuItemId);
    }

    @Transactional
    public List<MenuItemDto> getMenuItemsByDescription(String description) {
        return MenuItemUtil.convertMenuItemDomainsToDtos(menuItemDao.getMenuItemsByDescription(description));
    }

    @Transactional
    public void updateMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = MenuItemUtil.convertMenuItemDtoToDomain(menuItemDto);
        menuItemDao.updateMenuItem(menuItem);
    }


    public Boolean menuItemIsAlreadyPersisted(MenuItem menuItem) throws Exception {
        List<MenuItem> allMenuItems = menuItemDao.getAllMenuItems();
        for (MenuItem item : allMenuItems) {
            if (menuItem.equals(item)) {
                return true;
            }
        }
        return false;
    }

}
