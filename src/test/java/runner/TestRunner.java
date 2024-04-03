package runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
/**
 * Runner class to glue features and step definitions
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions, hooks")
@ExcludeTags("ignore")
public class TestRunner {

}
