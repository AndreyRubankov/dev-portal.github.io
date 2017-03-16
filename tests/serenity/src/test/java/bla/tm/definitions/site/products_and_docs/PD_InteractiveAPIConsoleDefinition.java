package bla.tm.definitions.site.products_and_docs;

import bla.tm.definitions.site.pantheon.UserData;
import bla.tm.steps.pantheon.UserAccountSteps;
import bla.tm.steps.pantheon.UserLogInSteps;
import bla.tm.steps.products_and_docs.PD_InteractiveAPIConsoleSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PD_InteractiveAPIConsoleDefinition {

    private UserData admin = new UserData("UserData", "1234567");
    private String apiKey = "{apikey}";

    @Steps
    PD_InteractiveAPIConsoleSteps interactiveAPIConsolePage;

    @Steps
    UserLogInSteps userLogInPage;

    @Steps
    UserAccountSteps userAccountSteps;

    @Given("open Interactive API Console page")
    public void openInteractiveAPIConsolePage() {
        interactiveAPIConsolePage.openPage();
    }

    @When("User is not logged to site (Interactive API Console)")
    public void openLogInPageAndCheckUserIsNotLoggedIn() {
        interactiveAPIConsolePage.clickLogIn();
        userLogInPage.isPageOpened();
        interactiveAPIConsolePage.openPage();
    }

    @When("User is logged to site (Interactive API Console)")
    public void openLogInPageAndLogIn() {
        interactiveAPIConsolePage.clickLogIn();
        userLogInPage.logInToApp(admin.username, admin.password);
        apiKey = userAccountSteps.getAPIKeyOfUser();
        interactiveAPIConsolePage.openPage();
    }

    @Then("check general page elements for Interactive API Console Page, where DISQUS = $disqus and LeftMenu = $leftMenu")
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        interactiveAPIConsolePage.checkIfTitleIsCorrect();
        interactiveAPIConsolePage.checkGeneralPageElements(disqus, leftMenu);
    }

    @Then("check that API key is provided for all placeholders on Interactive API Console page")
    public void checkAPIKeyPlaceholders(){
        interactiveAPIConsolePage.checkAPIKeyPlaceholders(apiKey);
    }

}
