package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.searchPage;
import stepDefinitions.searchStepDefs;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-report/"},
        features = "src/test/resources/scenarios/ProductSearch/Home_Page.feature"
        ,glue={"searchStepDefs"},
        monochrome = true
)

public class LocalRunner {
    @AfterClass
    public static void cleanUp() throws Exception {
        System.out.println("Performing tear down tests....\n");
        try {
            searchStepDefs.cleanUp();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
