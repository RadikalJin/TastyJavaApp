package com.joe.menuItem.dao.jpa;

import com.joe.menuItem.domain.MenuItem;
import com.joe.menuItem.util.MenuItemUtil;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component(MenuItemDaoImpl.BEAN_NAME)
public class MenuItemDaoImpl implements MenuItemDao {

    public static final String BEAN_NAME = "menuItemDao";

    @PersistenceContext
    private EntityManager em;


    @Override
    public void persistMenuItem(MenuItem menuItem) {
        em.persist(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() throws Exception {
        return em.createQuery("SELECT a FROM MenuItem a", MenuItem.class).getResultList();
    }

    @Override
    public MenuItem getMenuItemById(Integer menuItemId) throws Exception {
        return em.find(MenuItem.class, menuItemId);
    }

    @Override
    public void deleteMenuItemById(Integer menuItemId) {
        MenuItem menuItem = em.find(MenuItem.class, menuItemId);
        if (menuItem != null) {
            em.remove(menuItem);
        }
    }

    @Override
    public void updateMenuItem(MenuItem menuItem) {
        MenuItem existingMenuItem = em.find(MenuItem.class, menuItem.getId());
        existingMenuItem = MenuItemUtil.updateMenuItemDomainProperties(existingMenuItem, menuItem);
        em.persist(existingMenuItem);
    }

    @Override
    public List<MenuItem> getMenuItemsByDescription(String description) {
        return em.createQuery(
                "SELECT a FROM MenuItem a" +
                "WHERE description = '" + description
                 + "'", MenuItem.class).getResultList();
    }
}
