/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.test;

import com.avbravo.jmoordbaudit.anotation.Report;
import com.avbravo.jmoordbaudit.anotation.Test;
import com.avbravo.jmoordbaudit.htmlcomponents.Checkbox;
import com.avbravo.jmoordbaudit.htmlcomponents.InputText;
import com.avbravo.jmoordbaudit.test.UnitTest;
import com.jmoordbcore.capitulo13.model.Pais;
import com.jmoordbcore.capitulo13.repository.PaisRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.DependsOn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@DependsOn("TestEnvironment")
@Test
@Report(path = "/home/avbravo/Descargas/audit/src/main/webapp")
@ApplicationScoped
public class PaisTest {

    @Inject
    UnitTest unitTest;

    @Inject
    PaisRepository paisRepository;

    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
        System.out.println("PaisTest.onStart() ");
      //  init();
    }

    @PostConstruct
    void init() {
        System.out.println("------------> init----");
        unitTest.start(PaisTest.class);
      
       findAll();
        save();
checkbox();
destroy();
    }

    @Test
    private void save() {
        try {
            System.out.println("------------> save ----");
            //Mock
            Pais pais = new Pais(Long.MIN_VALUE, "Tst", new Date());
            Boolean save = unitTest.assertEquals("save", true, paisRepository.save(pais).isPresent());
             unitTest.form();
            unitTest.formTitle("Registros de paises");
            unitTest.panel();

            unitTest.panelAddInputText(Arrays.asList(new InputText("pais", pais.getPais()),
                    new InputText("fecha", pais.getFecha().toString())));

            unitTest.panelClose();
            unitTest.buttonGreen("Save");
            unitTest.formClose();
            if (save) {
                unitTest.message("se guardo exitosamente");
            } else {
                unitTest.errorMessage("No se pudo guardar");
            }
            

          // unitTest.assertEquals("save()", true, paisRepository.save(pais).isPresent());
        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

    }

    @Test
    private void findAll() {
//        System.out.println("------------> findall ----");
//        unitTest.assertNotEquals("findAll", 0, paisRepository.findAll().size());
        Boolean valid = unitTest.assertEquals("findAll", 10, paisRepository.findAll().size(), "No coinciden la cantidad de elementos");
        
            unitTest.form();
            unitTest.formTitle("s");
            unitTest.panel();

            unitTest.panelAddInputText(Arrays.asList(new InputText("Esperado", String.valueOf(10)),
                    new InputText("retornado", String.valueOf(paisRepository.findAll().size()))));

            unitTest.panelClose();
            unitTest.buttonGreen("findAll");
            unitTest.formClose();
            if (valid) {
                unitTest.message("No coinciden la cantidad de elementos");
            } else {
                unitTest.errorMessage("Elementos iguales");
            }

    }

    @PreDestroy
    public void destroy() {
        System.out.println("------------> destroyed ----");
         unitTest.end(PaisTest.class);
        // unitTest.terminate();
       

    }

    @Test
    public String checkbox() {
        try {
            //titulo de la tabla
//            List<Pais> colorList = paisRepository.findAll();
//            if (colorList.isEmpty()) {
//                unitTest.message("no hay colores en en findAll()");
//            } else {

                unitTest.form();
                unitTest.formTitle("Checkbox");
                unitTest.panel();

                unitTest.panelAddCheckbox("sexo", Arrays.asList(new Checkbox("masculino", "Masculino", "Masculino"),
                        new Checkbox("femenino", "Femenino", "Femenino")));

                unitTest.panelClose();
                unitTest.formClose();

         //   }

            unitTest.assertEquals("checbox()", 1, 1);
//            unitTest.assertEquals("findAll", 1, colorList.size());
        } catch (Exception e) {
            System.out.println("checbox() " + e.getLocalizedMessage());
        }
        return "";
    }

}
