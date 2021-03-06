package com.academy.automationpractice.kdt;

import com.academy.automationpractice.ddt.tests.BaseTest;
import com.academy.automationpractice.kdt.engine.KeywordStep;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTests extends BaseTest {
    private BaseKDTTest baseKDT;

    @BeforeClass
    public void setUpMethod() {
        baseKDT = new BaseKDTTest(manager.getDriver());
    }

    @Test(groups={"kdt"}, dataProvider = "kdtProvider")
    public void testIncorrectLogin(List<KeywordStep> steps) {
        baseKDT.kdtTest(steps);
    }

    @DataProvider(name="kdtProvider")
    public Object[][] loginTestProvider() {

        List<KeywordStep> steps = new ArrayList<>();

        // TODO read from excel
        steps.add(new KeywordStep()
                .withPage("")
                .withAction("GOTOURL")
                .withObject("")
                .withValue("http://automationpractice.com/index.php"));

        steps.add(new KeywordStep()
                .withPage("Home")
                .withAction("CLICK")
                .withObject("signInLink")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("login")
                .withValue("oleg.kh81@gmail.com"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("password")
                .withValue("123qwerty"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("CLICK")
                .withObject("signInButton")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("account")
                .withAction("ASSERT")
                .withObject("usernameLinkText")
                .withValue("OLEG AFANASIEV"));

        steps.add(new KeywordStep()
                .withPage("account")
                .withAction("CLICK")
                .withObject("signOutButton")
                .withValue(""));

        return new Object[][] {
                {steps},
        };
    }
}
