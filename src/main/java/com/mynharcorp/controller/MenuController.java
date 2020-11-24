/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.MenuFacadeLocal;
import com.mynharcorp.model.Menu;
import com.mynharcorp.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author harold
 */
@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal menuFacadeLocal;

    private List<Menu> menuList;

    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenu();
        this.crearManu();
    }

    /**
     *
     */
    public void listarMenu() {
        try {

            this.menuList = this.menuFacadeLocal.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void crearManu() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario obj = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

        model = new DefaultMenuModel();

        for (Menu menu : menuList) {

            if (menu.getTipoUsuario().equalsIgnoreCase(obj.getTipo())) {//***********************************

                if (menu.getTipo().equalsIgnoreCase("S")) {
                    //First submenu
                    DefaultSubMenu firstSubmenu = new DefaultSubMenu(menu.getNombre());
                    for (Menu objMenu : menuList) {
                        Menu submenu = objMenu.getSubmenu();
                        if (submenu != null) {
                            if (submenu.getTipoUsuario().equalsIgnoreCase(obj.getTipo())) {//***************
                                if (submenu.getCodigo() == menu.getCodigo()) {
                                    DefaultMenuItem item = new DefaultMenuItem(objMenu.getNombre());
                                    item.setUrl(objMenu.getUrl());
                                    firstSubmenu.addElement(item);

                                }
                            }//*****************************************************************************
                        }
                    }
                    model.addElement(firstSubmenu);

                } else if (menu.getSubmenu() == null) {
                    DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());
                    item.setUrl(menu.getUrl());
                    model.addElement(item);
                }

            }//usuario**************************************************************************************
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
