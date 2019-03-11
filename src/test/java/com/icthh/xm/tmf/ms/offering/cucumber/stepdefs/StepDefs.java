package com.icthh.xm.tmf.ms.offering.cucumber.stepdefs;

import com.icthh.xm.tmf.ms.offering.OfferingApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = OfferingApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
