package com.tkmdpa.taf.definitions.products_and_docs;

import com.tkmdpa.taf.steps.AnyPageSteps;
import com.tkmdpa.taf.steps.products_and_docs.PD_Tutorials_WidgetsSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.tkmdpa.taf.AcceptanceTestSuite.baseTestedUrl;
import static com.tkmdpa.taf.staticmethods.StaticMethods.waitForSomeActionHappened;

public class PD_Tutorials_WidgetsDefinition {

    @Steps
    PD_Tutorials_WidgetsSteps tutorialsWidgetsPage;

    @Steps
    AnyPageSteps anyPageSteps;

    @Given("open Tutorials Widgets page")
    public void openTutorialsWidgetsPage() {
        tutorialsWidgetsPage.openPage();
    }

    @Given("Feedback mapWidget elements are not shown")
    public void checkFeedbackElementsAreNotShown() {
        tutorialsWidgetsPage.checkFeedbackElementsAreNtShown();
    }

    @Given("Feedback mapWidget is not shown")
    @Then("Feedback mapWidget is not shown")
    public void checkIfWidgetIsNotShown() {
        tutorialsWidgetsPage.checkIfWidgetIsNotShown();
    }

    @When("check visibility and click $key element of Tutorials Widgets page")
    public void checkIfElementVisibleAndClickIt(String key) {
        tutorialsWidgetsPage.validateAndClickElement(key);
    }

    @Given("click Feedback button of Tutorials Widgets page")
    @When("click Feedback button of Tutorials Widgets page")
    public void clickFeedbackButton() {
        tutorialsWidgetsPage.clickFeedbackButton();
    }

    @When("click send button of Feedback mapWidget")
    public void clickSendButton() {
        tutorialsWidgetsPage.clickSendFeedbackWidgetButton();
    }

    @When("all fields except Name are populated")
    public void populateAllFieldsExceptName() {
        tutorialsWidgetsPage.populateAllFieldsExceptName();
    }

    @When("all fields except Email are populated")
    public void populateAllFieldsExceptEmail() {
        tutorialsWidgetsPage.populateAllFieldsExceptEmail();
    }

    @When("Name field is populated with bigger than 255 symbols text")
    public void populateNameFieldWithMoreThanAccepted() {
        waitForSomeActionHappened(500);
        tutorialsWidgetsPage.populateNameFieldWithMoreThanAccepted();
    }

    @When("click OK Feedback Widget button")
    @Then("click OK Feedback Widget button")
    public void clickOkFeedbackWidgetButton() {
        tutorialsWidgetsPage.clickOkFeedbackWidgetButton();
    }

    @Then("check general page elements for Tutorials Widgets Page, where DISQUS = $disqus and LeftMenu = $leftMenu")
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        tutorialsWidgetsPage.checkIfTitleIsCorrect();
        tutorialsWidgetsPage.checkGeneralPageElements(disqus, leftMenu);
    }

    @Then("check that new page opened from Tutorials Widgets page has $url and $title")
    public void checkIfPageIsOpened(String url, String title){
        anyPageSteps.checkIfPageIsOpened(url,title,baseTestedUrl);
    }

    @Then("Feedback mapWidget is shown")
    public void checkIfWidgetIsShown() {
        tutorialsWidgetsPage.checkIfWidgetIsShown();
    }

    @Then("Feedback mapWidget elements are shown")
    public void checkFeedbackElementsAreShown() {
        tutorialsWidgetsPage.checkFeedbackElementsAreShown();
    }

    @Then("click close button of Feedback mapWidget")
    public void clickCloseFeedbackWidgetButton() {
        tutorialsWidgetsPage.clickCloseFeedbackWidgetButton();
    }

    @Then("error notification is shown for Feedback mapWidget")
    public void checkErrorNotificationForTextField() {
        tutorialsWidgetsPage.checkErrorNotificationForTextField();
    }

    @Then("description error notification is shown for Feedback mapWidget")
    public void checkErrorNotificationForTextArea() {
        tutorialsWidgetsPage.checkErrorNotificationForTextArea();
    }

    @Then("check that error message is shown for Description for Feedback mapWidget")
    public void checkDescriptionErrorMessageIsShown() {
        tutorialsWidgetsPage.checkDescriptionErrorMessageIsShown();
    }

    @Then("check that email sent notification is shown")
    public void checkEmailSentNotificationIsShown() {
        tutorialsWidgetsPage.checkEmailSentNotificationIsShown();
    }

    @Then("check that email sent notification is not shown")
    public void checkEmailSentNotificationIsNotShown() {
        tutorialsWidgetsPage.checkEmailSentNotificationIsNotShown();
    }

}
