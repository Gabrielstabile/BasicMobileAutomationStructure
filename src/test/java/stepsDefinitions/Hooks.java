package stepsDefinitions;

import core.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks extends DriverFactory {

    @Before
    public void setUp(){
        DriverFactory.createDriver();
    }

    @After
    public void tearDown(){
        getDRIVER().quit();
    }
}
