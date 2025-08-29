package UITests;

import com.fasterxml.jackson.databind.JsonNode;
import net.bytebuddy.asm.Advice;
import org.example.base.BaseTest;
import org.example.pages.AppleHomePage;
import org.example.pages.SearchWorkFlow;
import org.example.utils.JsonDataReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppleSearchTest extends BaseTest {

    @Test
    public  void verifySearchResults() {
        driver.get("https://www.apple.com");
        AppleHomePage home = new AppleHomePage(driver);

        JsonNode testCases = JsonDataReader.getTestCases("data", "searchTests");

        for (JsonNode test : testCases) {
            String searchTerm = test.get("searchTerm").asText();
            String expectedTitle = test.get("expectedTitle").asText();

            home.clickSearchButton();
            home.enterSearchTerm(searchTerm);


            try { Thread.sleep(8000); } catch (InterruptedException e) {}

            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(expectedTitle),
                    "Title mismatch for search: " + searchTerm);
        }
    }


}
