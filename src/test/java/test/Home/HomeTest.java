package test.Home;

import org.testng.annotations.Test;

import base.BaseTest;
import page.Home.HomePage;

public class HomeTest extends BaseTest {

    HomePage home;

    @Test(groups = { "validateMountQuote" })
    public void validateMountQuote() {

        home = new HomePage(driver);

        System.out.println("prueba0");

    }

    @Test(groups = { "validateFaceBookLink" })
    public void validateFaceBookLink() {

        home = new HomePage(driver);

        System.out.println("prueba1");

    }

}
