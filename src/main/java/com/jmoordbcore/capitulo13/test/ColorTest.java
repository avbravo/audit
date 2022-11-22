/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo13.test;

import com.avbravo.jmoordbaudit.anotation.Test;
import com.avbravo.jmoordbaudit.datatable.ColView;
import com.avbravo.jmoordbaudit.datatable.RowView;
import com.avbravo.jmoordbaudit.htmlcomponents.Checkbox;
import com.avbravo.jmoordbaudit.htmlcomponents.InputText;
import com.avbravo.jmoordbaudit.htmlcomponents.Item;
import com.avbravo.jmoordbaudit.htmlcomponents.Radio;
import com.avbravo.jmoordbaudit.htmlcomponents.SelectOneMenu;
import com.avbravo.jmoordbaudit.test.UnitTest;
import com.jmoordbcore.capitulo13.repository.PaisRepository;
import com.sun.jna.platform.win32.Netapi32Util.UserInfo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.DependsOn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author avbravo
 */
@DependsOn("TestEnvironment")
@Test(name = "OceanoTest")
@ApplicationScoped
public class ColorTest {

//    @Inject
//    UnitTest unitTest;
//   
//   
//    @Inject
//    PaisRepository paisRepository;
//
//    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
//        System.out.println("OceanoTest.onStart() ");
//      //  init();
//    }
//    
//    @PostConstruct
//    void init() {
//        unitTest.start(ColorTest.class);
//       unitTest.start(ColorTest.class);
//        save();
//        panelSelectOneMenu();
//        panelDataTable();
//        findAll();
//      failure();
//        selectOneMenu();
//        radio();
//        checkbox();
//        unitTest.skipper("delete()");
//        unitTest.end(ColorTest.class);
//    }
//
//    @Test
//    public String save() {
//        try {
////           unitTest.message("Testeando save()");
////Mock
//            Color color = new Color();
//            color.setActivo("si");
//            color.setAutoincrementable(15);
//            color.setIdcolor("rojo");
//            List<UserInfo> list = new ArrayList<>();
//            color.setUserInfo(list);
//            Boolean expResult = true;
//            Boolean save = unitTest.assertEquals("save", true, colorRepository.save(color));
//
//            /*
//            Dibuja la interfaz
//             */
//           unitTest.form();
//           unitTest.formTitle("Registros de colores");
//           unitTest.panel();
//
//           unitTest.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
//                    new InputText("activo", color.getActivo())));
//
//           unitTest.panelClose();
//           unitTest.buttonGreen("Save");
//           unitTest.formClose();
//            if (save) {
//               unitTest.message("se guardo exitosamente");
//            } else {
//               unitTest.errorMessage("No se pudo guardar");
//            }
//
//        } catch (Exception e) {
//            System.out.println("save() " + e.getLocalizedMessage());
//        }
//
//        return "";
//    }
//
//    @Test
//    public String panelSelectOneMenu() {
//        try {
////           unitTest.message("Testeando save()");
////Mock
//            Color color = new Color();
//            color.setActivo("si");
//            color.setAutoincrementable(15);
//            color.setIdcolor("rojo");
//            List<UserInfo> list = new ArrayList<>();
//            color.setUserInfo(list);
//            Boolean expResult = true;
//            Boolean save = unitTest.assertEquals("panelSelectOneMenu", true, colorRepository.save(color));
//
//            /*
//            Dibuja la interfaz
//             */
//           unitTest.form();
//           unitTest.formTitle("panelSelectOneMenu()");
//           unitTest.panel();
//
//           unitTest.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
//                    new InputText("activo", color.getActivo())));
//
//            //-----------------------------
//            List<Color> colorList = colorRepository.findAll();
//            List<Item> itemList = new ArrayList<>();
//            for (Color c : colorList) {
//                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
//                itemList.add(item);
//            }
//           unitTest.panelAddSelectOneMenu(
//                    Arrays.asList(new SelectOneMenu("color", itemList)));
//
//            //------------------
//           unitTest.panelClose();
//            
//           unitTest.buttonGreen("Save");
//           unitTest.formClose();
//            if (save) {
//               unitTest.message("se guardo exitosamente");
//            } else {
//               unitTest.errorMessage("No se pudo guardar");
//            }
//
//        } catch (Exception e) {
//            System.out.println("save() " + e.getLocalizedMessage());
//        }
//
//        return "";
//    }
//
//    @Test
//    public String panelDataTable() {
//        try {
////           unitTest.message("Testeando save()");
////Mock
//            Color color = new Color();
//            color.setActivo("si");
//            color.setAutoincrementable(15);
//            color.setIdcolor("rojo");
//            List<UserInfo> list = new ArrayList<>();
//            color.setUserInfo(list);
//            Boolean expResult = true;
//            Boolean save = unitTest.assertEquals("panelDataTable", true, colorRepository.save(color));
//
//            /*
//            Dibuja la interfaz
//             */
//           unitTest.form();
//           unitTest.formTitle("panelDataTable()");
//           unitTest.panel();
//
//           unitTest.panelAddInputText(Arrays.asList(new InputText("idcolor", color.getIdcolor()),
//                    new InputText("activo", color.getActivo())));
//
//            //-----------------------------
//            List<Color> colorList = colorRepository.findAll();
//            List<Item> itemList = new ArrayList<>();
//            for (Color c : colorList) {
//                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
//                itemList.add(item);
//            }
//           unitTest.panelAddSelectOneMenu(
//                    Arrays.asList(new SelectOneMenu("color", itemList)));
//
//            //------------------
//           unitTest.panelAddTableHeader("colores", Arrays.asList(new RowView("idcolor"), new RowView("activo")));
//            colorRepository.findAll().forEach((c) -> {
//               unitTest.panelAddTableCol(Arrays.asList(new ColView(c.getIdcolor()), new ColView(c.getActivo())));
//            });
//           unitTest.panelAddTableClose();
//
//           unitTest.panelClose();
//           unitTest.buttonGreen("Save");
//           unitTest.formClose();
//            if (save) {
//               unitTest.message("se guardo exitosamente");
//            } else {
//               unitTest.errorMessage("No se pudo guardar");
//            }
//
//        } catch (Exception e) {
//            System.out.println("save() " + e.getLocalizedMessage());
//        }
//
//        return "";
//    }
//
//    @Test
//    public String findAll() {
//        try {
//            //titulo de la tabla
//            List<Color> colorList = colorRepository.findAll();
//            if (colorList.isEmpty()) {
//               unitTest.message("no hay colores en en findAll()");
//            } else {
//               unitTest.formTitle("findAll()");
//               unitTest.tableHeader(Arrays.asList(new RowView("idcolor"), new RowView("activo")));
//                colorRepository.findAll().forEach((c) -> {
//                   unitTest.tableCol(Arrays.asList(new ColView(c.getIdcolor()), new ColView(c.getActivo())));
//                    //  System.out.println("color: " + c.getIdcolor());
//                });
//               unitTest.tableClose();
//            }
//
//            unitTest.assertEquals("findAll", 1, colorList.size());
//        } catch (Exception e) {
//            System.out.println("findAll() " + e.getLocalizedMessage());
//        }
//        return "";
//    }
//
//    @Test
//    public String radio() {
//        try {
//            //titulo de la tabla
//            List<Color> colorList = colorRepository.findAll();
//            if (colorList.isEmpty()) {
//               unitTest.message("no hay colores en en findAll()");
//            } else {
//
//               unitTest.form();
//               unitTest.formTitle("Radio");
//               unitTest.panel();
//
//               unitTest.panelAddRadio(Arrays.asList(new Radio("sexo",
//                        Arrays.asList(new Item("sexo", "Masculino", "Masculino"),
//                                new Item("sexo", "Femenino", "Femenino")))));
//
//               unitTest.panelClose();
//               unitTest.formClose();
//
//            }
//
//            unitTest.assertEquals("radio", 1, colorList.size());
//        } catch (Exception e) {
//            System.out.println("findAll() " + e.getLocalizedMessage());
//        }
//        return "";
//    }
//
//    @Test
//    public String checkbox() {
//        try {
//            //titulo de la tabla
//            List<Color> colorList = colorRepository.findAll();
//            if (colorList.isEmpty()) {
//               unitTest.message("no hay colores en en findAll()");
//            } else {
//
//               unitTest.form();
//               unitTest.formTitle("Checkbox");
//               unitTest.panel();
//
//               unitTest.panelAddCheckbox("sexo", Arrays.asList(new Checkbox("masculino", "Masculino", "Masculino"),
//                        new Checkbox("femenino", "Femenino", "Femenino")));
//
//               unitTest.panelClose();
//               unitTest.formClose();
//
//            }
//
//            unitTest.assertEquals("findAll", 1, colorList.size());
//        } catch (Exception e) {
//            System.out.println("findAll() " + e.getLocalizedMessage());
//        }
//        return "";
//    }
//
//    @Test
//    public String selectOneMenu() {
//        try {
//            List<Color> colorList = colorRepository.findAll();
//            if (colorList.isEmpty()) {
//               unitTest.message("no hay colores en en findAll()");
//            } else {
//            }
//
//            //titulo de la tabla
//            /*
//            Dibuja la interfaz
//             */
//           unitTest.form();
//           unitTest.formTitle("SelectOneMenu");
//           unitTest.panel();
//            List<Item> itemList = new ArrayList<>();
//            for (Color c : colorList) {
//                Item item = new Item(c.getIdcolor(), c.getIdcolor(), c.getIdcolor());
//                itemList.add(item);
//            }
//           unitTest.panelAddSelectOneMenu(
//                    Arrays.asList(new SelectOneMenu("color", itemList)));
//           unitTest.panelClose();
//
//           unitTest.formClose();
//
//        } catch (Exception e) {
//            System.out.println("findAll() " + e.getLocalizedMessage());
//        }
//        return "";
//    }
//
//    @PreDestroy
//    public void destroy() {
//
//    }
//
//    @Test
//    public void failure() {
//        unitTest.fail("failure", "Fallo intencional");
//    }
}
