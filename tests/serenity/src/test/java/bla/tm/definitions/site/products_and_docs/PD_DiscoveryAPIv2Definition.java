package bla.tm.definitions.site.products_and_docs;

import bla.tm.definitions.site.pantheon.UserData;
import bla.tm.steps.pantheon.UserAccountSteps;
import bla.tm.steps.pantheon.UserLogInSteps;
import bla.tm.steps.products_and_docs.PD_DiscoveryAPIv2Steps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PD_DiscoveryAPIv2Definition {

    private UserData admin = new UserData("UserData", "1234567");
    private String apiKey = "{apikey}";

    @Steps
    PD_DiscoveryAPIv2Steps discoveryAPIv2Page;

    @Steps
    UserLogInSteps userLogInPage;

    @Steps
    UserAccountSteps userAccountSteps;

    @Given("open Discovery API v2 page")
    public void openDiscoveryAPIv2Page() {
        discoveryAPIv2Page.openPage();
    }

    @When("User is not logged to site (Discovery API v2)")
    public void openLogInPageAndCheckUserIsNotLoggedIn() {
        discoveryAPIv2Page.clickLogIn();
        userLogInPage.isPageOpened();
        discoveryAPIv2Page.openPage();
    }

    @When("User is logged to site (Discovery API v2)")
    public void openLogInPageAndLogIn() {
        discoveryAPIv2Page.clickLogIn();
        userLogInPage.logInToApp(admin.username, admin.password);
        apiKey = userAccountSteps.getAPIKeyOfUser();
        discoveryAPIv2Page.openPage();
    }

    @Then("check general page elements for Discovery API v2 Page, where DISQUS = $disqus and LeftMenu = $leftMenu")
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        discoveryAPIv2Page.checkIfTitleIsCorrect();
        discoveryAPIv2Page.checkGeneralPageElements(disqus, leftMenu);
    }

    @Then("check that API key is provided for all placeholders on Discovery API v2 page")
    public void checkAPIKeyPlaceholders(){
        discoveryAPIv2Page.checkAPIKeyPlaceholders(apiKey);
    }

}
