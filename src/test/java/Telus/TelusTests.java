package Telus;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TelusTests extends BaseTest {


    TelusBasePage telusBasePage = new TelusBasePage();


    @Test
        public void Test01() throws InterruptedException {
            telusBasePage.closeModal();
            telusBasePage.clickOnDemand();
            telusBasePage.scrollToMoviesTag();
            telusBasePage.clickFilterButton();
            telusBasePage.clickApplyButton();
            telusBasePage.selectAnimatedSection();
            telusBasePage.select18TagAsset();
            Assert.assertTrue(telusBasePage.getAssetDetails().contains("18+"));
        }

}
