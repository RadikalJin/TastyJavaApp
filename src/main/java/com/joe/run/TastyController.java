package com.joe.run;


import com.joe.menuItem.dto.MenuItemDto;
import com.joe.menuItem.service.MenuItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TastyController {

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    MenuItemService menuService = (MenuItemService) context.getBean("menuItemService");

    @RequestMapping("/getMenu")
    public List<MenuItemDto> getAllMenuItems() throws Exception {
        List<MenuItemDto> persistedMenuItems = menuService.getAllMenuItems();
        return persistedMenuItems;
    }

}
