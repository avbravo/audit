/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo13.test;

import com.avbravo.jmoordbaudit.anotation.Test;
import com.avbravo.jmoordbaudit.test.UnitTest;
import com.jmoordbcore.capitulo13.model.Oceano;
import com.jmoordbcore.capitulo13.repository.OceanoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.DependsOn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

/**
 *
 * @author avbravo
 */

@DependsOn("TestEnvironment")
@Test(name = "OceanoTest")
@ApplicationScoped

public class OceanoTest{
@Inject 
UnitTest unitTest;
     @Inject
   OceanoRepository oceanoRepository;
     
     public void onStart(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
        System.out.println("OceanoTest.onStart() ");
      //  init();
    }

    @PostConstruct
    public void init() {
       unitTest.start(OceanoTest.class);
       findAll();
      unitTest.skipper("delete");
      unitTest.skipper("save");
   unitTest.end(OceanoTest.class);
     
        
    }

    @Test
    public void findAll(){
        for(Oceano o:oceanoRepository.findAll()){
            System.out.println("idoceano: "+o.getIdoceano());
        }
        unitTest.assertEquals("findAll",5,oceanoRepository.findAll().size());

    }
    /**
     *
     */
    @PreDestroy
    public void destroy() {
              unitTest.end(OceanoTest.class);
       //  unitTest.terminate();
   
       
    }
}
