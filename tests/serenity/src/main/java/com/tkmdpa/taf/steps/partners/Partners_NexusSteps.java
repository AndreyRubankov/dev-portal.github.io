package com.tkmdpa.taf.steps.partners;

import com.tkmdpa.taf.pages.site.partners.Partners_NexusPage;
import net.thucydides.core.annotations.Step;

public class Partners_NexusSteps {

    Partners_NexusPage nexusPage;

    @Step
    public void openPage() {
        nexusPage.open();
    }

    @Step
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        nexusPage.checkGeneralPageElements(disqus, leftMenu);
    }
}
