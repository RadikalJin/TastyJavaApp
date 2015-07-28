package com.test.joe;

import com.joe.menuItem.dto.MenuItemDto;
import com.joe.menuItem.service.MenuItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuItemTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    MenuItemService menuService = (MenuItemService) context.getBean("menuItemService");
    List<MenuItemDto> testMenuItems;
    Boolean keepData = false;

    @Before
    public void setUp() throws Exception {
        testMenuItems = new ArrayList<>();
        MenuItemDto testItem1 = new MenuItemDto();
        testItem1.setDescription("TEST_1");
        testItem1.setPrice("1.00");
        MenuItemDto testItem2 = new MenuItemDto();
        testItem2.setDescription("TEST_2");
        testItem2.setPrice("2.00");
        MenuItemDto testItem3 = new MenuItemDto();
        testItem3.setDescription("TEST_3");
        testItem3.setPrice("3.00");
        testMenuItems.add(testItem1);
        testMenuItems.add(testItem2);
        testMenuItems.add(testItem3);
    }

    @Test
    public void testPersistingMenuItem() throws Exception {
        MenuItemDto testItem = testMenuItems.get(0);
        try {
            menuService.getMenuItemsByDescription(testItem.getDescription());
        } catch (NoResultException e) {
            System.out.println("Caught as expected");
        }
        menuService.persistMenuItem(testItem);
        assertNotNull(menuService.getMenuItemsByDescription(testItem.getDescription()));
    }

}
