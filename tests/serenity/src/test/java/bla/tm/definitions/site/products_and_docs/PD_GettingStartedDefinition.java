package bla.tm.definitions.site.products_and_docs;

import bla.tm.definitions.site.pantheon.UserData;
import bla.tm.steps.pantheon.UserAccountSteps;
import bla.tm.steps.pantheon.UserLogInSteps;
import bla.tm.steps.products_and_docs.PD_GettingStartedSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PD_GettingStartedDefinition {

    private UserData admin = new UserData("UserData", "1234567");
    private String apiKey = "{apikey}";

    @Steps
    PD_GettingStartedSteps gettingStartedPage;

    @Steps
    UserLogInSteps userLogInPage;

    @Steps
    UserAccountSteps userAccountSteps;

    @Given("open Getting Started page")
    @When("open Getting Started page")
    public void openGettingStartedPage() {
        gettingStartedPage.openPage();
    }

    @When("User is not logged to site (Getting Started)")
    public void openLogInPageAndCheckUserIsNotLoggedIn() {
        gettingStartedPage.clickLogIn();
        userLogInPage.isPageOpened();
        gettingStartedPage.openPage();
    }

    @When("User is logged to site (Getting Started)")
    public void openLogInPageAndLogIn() {
        gettingStartedPage.clickLogIn();
        userLogInPage.logInToApp(admin.username, admin.password);
        apiKey = userAccountSteps.getAPIKeyOfUser();
        gettingStartedPage.openPage();
    }

    @Then("check general page elements for Getting Started Page, where DISQUS = $disqus and LeftMenu = $leftMenu")
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        gettingStartedPage.checkIfTitleIsCorrect();
        gettingStartedPage.checkGeneralPageElements(disqus, leftMenu);
    }

    @Then("all the Commerce API methods are shown on Getting Started page")
    public void compareCommerceAPIMethodsToSameGettingStartedMethodsList(){
        gettingStartedPage.compareCommerceAPIMethodsToSameGettingStartedMethodsList();
    }

    @Then("Summary widget is shown for Getting Started page")
    public void checkSummaryWidgetVisible(){
        gettingStartedPage.checkSummaryWidgetVisible();
    }

    @Then("check that API key is provided for all placeholders on Getting Started page")
    public void checkAPIKeyPlaceholders(){
        gettingStartedPage.checkAPIKeyPlaceholders(apiKey);
    }

}
