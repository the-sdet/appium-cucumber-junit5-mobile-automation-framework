# Comprehensive Mobile Automation Framework

<a href="https://appium.io/"><img align="center" src="src/test/resources/logos/appium-logo.png" height="40" width="40" alt="Appium"/></a> &nbsp;
<a href="https://www.selenium.dev/"><img align="center" src="src/test/resources/logos/selenium-logo.png" height="40" width="40" alt="Selenium"/></a> &nbsp;
<a href="https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html"><img align="center" src="src/test/resources/logos/java-logo.svg" height="40" width="40" alt="Java"/></a> &nbsp;
<a href="https://cucumber.io/"><img align="center" src="src/test/resources/logos/cucumber-logo.svg" height="40" width="40" alt="Cucumber"/></a> &nbsp;
<a href="https://junit.org/junit5/"><img align="center" src="src/test/resources/logos/junit5-logo.png" height="40" width="40" alt="JUnit5"/></a> &nbsp;
<a href="https://www.makemytrip.com/"><img align="center" src="src/test/resources/logos/mmt-logo.svg" height="40" alt="MakeMyTrip"/></a>

This Mobile Automation Framework, A project ready Test Automation Framework, provides a robust solution for automating tests on both
Android and iOS devices. With
seamless integration for great reporting and logging features, it ensures efficient tracking and debugging of test
executions. The framework supports local execution as well as remote testing via platforms like Sauce Labs, offering
flexibility and scalability to your automation workflow.

For Instance, this framework contains the Home Page, Menu Drawer, Flight Page, Flight Search, Filter Validations for Search, etc. for **MakeMyTrip** Android App...

## Tech Stack & Libraries Used

* appium v9.1.0
* selenium v1.18.1
* java v11
* cucumber v7.15.0
* junit 5
* test-automation-toolkit v1.0.2
* maven v3.9.5
* surefire v3.1.2
* gherkin v26.0.1
* lombok v1.18.20
* log4j v2.20.0
* extent v1.14.0
* masterthought-reporting v5.8.0
* apache-poi v5.2.5
* common-io v2.7
* guava.version v33.0.0-jre

## Features:

1. [x] **Cross-Platform Support:** Seamlessly automate tests on both Android and iOS devices.
2. [x] **Rich Reporting:** Generate comprehensive reports to gain insights into test results and performance metrics.
3. [x] **Detailed Logging:** Capture detailed logs for each test run, aiding in debugging and troubleshooting.
4. [x] **Local and Remote Execution:** Execute tests locally for quick iterations or leverage remote execution
   capabilities
   with platforms like Sauce Labs for broader device coverage.
5. [x] **Scalable Architecture:** Built with scalability in mind to accommodate growing test suites and evolving project
   requirements.
6. [x] **Modular Design:** Modular components ensure easy maintenance and extensibility of the framework.
7. [x] **Integration-Friendly:** Easily integrate with Continuous Integration (CI) pipelines for seamless automation
   workflows.

## Setup:

### Install the below items for an easy setup

* [Java 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Any IDE (IntelliJ)](https://www.jetbrains.com/idea/download/)
* [Node.js (Needed to Manage Appium)](https://nodejs.org/en/download)
* Install Appium
  * ``` npm i --location=global appium ```
  * ``` appium --version ```
* Install Driver
  * Android Driver: ``` appium driver install uiautomator2 ```
  * iOS Driver: ``` appium driver install xcuitest ```

### Clone the repository:

```
git clone https://github.com/the-sdet/appium-cucumber-junit5-mobile-automation-framework.git
```

## Configuration:

All the configs can be found in test/resources. Those can be modified as per project requirement.

- config.properties
- android-config.properties
- ios-config.properties
- junit-platform.properties
- extent.properties

## Tagging The Features and Scenarios

When we talk in Cucumber context, tags are one of the most vital components. We need to tag our features and scenarios
well to group them and run them as we need.

Tags are mentioned with @ as prefix above the feature or scenario. A feature/scenario can have multiple tags as well. A
tag on feature level is auto inherited to the scenarios in that feature. So, no need to repeat same tag on each
scenario, it can be simply added to the feature.

```
@myFeature
Feature: Sample Feature

@Smoke @Regression
Scenario: Scenario One
Given I tag a scenario
When I select tests with that tag for execution
Then my tagged scenario is executed

@Sanity
Scenario: Scenario Two
Given I tag a scenario
When I select tests with that tag for execution
Then my tagged scenario is executed
```

## Execution:

There are multiple ways to execute the tests.

* Run feature/scenario directly from feature file.
* Run the TestRunner inside src/test/java/runner/TestRunner.java
* Run using Maven CLI

Executing tests using Maven CLI is the preferred option as it's configured in a such a way that, you can almost provide
most of the configs from maven command itself at the runtime rather than actually modifying them in code.

## Examples of some configs that can be altered from CMD for the specific run

All the below configs are optional. if NOT provided from CMD, already defined values will be picked.

* execution.type
* platform
* env
* sauce.url
* sauce.username
* sauce.password
* screenshot
* report.name

#### Executing on local or remote (sauce labs)
```
mvn clean install -Dexecution.type=local
```
```
mvn clean install -Dexecution.type=remote
```

#### Screenshot Options
```
mvn clean install -Dscreenshot=only.pass
```
```
mvn clean install -Dscreenshot=only.fail
```
```
mvn clean install -Dscreenshot=all
```
#### Platform Options
```
mvn clean install -Dplatform=android
```
```
mvn clean install -Dplatform=ios
```

#### Sauce Options
```
mvn clean install -Dsauce.url=sauce-url -Dsauce.username=username -Dsauce.password=pasword
```
#### Environment
```
mvn clean install -Denv=stg
```
#### Report Name
```
mvn clean install -Dreport.name="Automation Test Summary - The SDET"
```

### Executing all the tests

All the features & it's scenarios can be executed by using below command.

```
mvn clean install
```

### Executing selected tests

Cucumber tags are mapped to JUnit tags. Note that the @ symbol is not part of the JUnit tag.
When using Maven, tags can be provided from the CLI using the <code>groups</code> and <code>excludedGroups</code>
parameters.

Cucumber Tag Expression uses <code>cucumber.filter.tags</code> for filtering

```
mvn clean install -Dcucumber.filter.tags="@Regression"
```

JUnit Tag Expression <code>groups</code> and <code>excludedGroups</code> for filtering

```
mvn clean install -Dgroups="Regression"
```

_*** While using JUnit5, JUnit5 tag expressions are preferred over Cucumber Tag Expression and Cucumber Tag Expression
can be avoided for better results._

### JUnit5 Tag Expressions

Tag expressions are boolean expressions with the operators !, & and |. In addition, ( and ) can be used to adjust for
operator precedence.
<table>
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 33.3333%;">
<col style="width: 33.3334%;">
</colgroup>
<thead>
<tr>
<th align="left">Operator</th>
<th align="left">Meaning</th>
<th align="left">Associativity</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>!</code></td>
<td>not</td>
<td>right</td>
</tr>
<tr>
<td><code>&amp;</code></td>
<td>and</td>
<td>left</td>
</tr>
<tr>
<td><code>|</code></td>
<td>or</td>
<td>left</td>
</tr>
</tbody>
</table>

If you are tagging your tests across multiple dimensions, tag expressions help you to select which tests to execute.
When tagging by test type (e.g., micro, integration, end-to-end) and feature (e.g., product, catalog, shipping), the
following tag expressions can be useful.

<table>
<colgroup>
<col style="width: 40%;">
<col style="width: 60%;">
</colgroup>
<thead>
<tr>
<th align="left">Tag Expression</th>
<th align="left">Selection</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>product</code></td>
<td>all tests for <strong>product</strong></td>
</tr>
<tr>
<td><code>catalog | shipping</code></td>
<td>all tests for <strong>catalog</strong> plus all tests for <strong>shipping</strong></td>
</tr>
<tr>
<td><code>catalog &amp; shipping</code></td>
<td>all tests for the intersection between <strong>catalog</strong> and <strong>shipping</strong></td>
</tr>
<tr>
<td><code>product &amp; !end-to-end</code></td>
<td>all tests for <strong>product</strong>, but not the <em>end-to-end</em> tests</td>
</tr>
<tr>
<td><code>(micro | integration) &amp; (product | shipping)</code></td>
<td>all <em>micro</em> or <em>integration</em> tests for <strong>product</strong> or <strong>shipping</strong></td>
</tr>
</tbody>
</table>

### Executing selected tests (filter using tags/tag expression)

Run only Regression Tests

```
mvn clean install -Dgroups="Regression"
```

Run Regression Tests but exclude Profile Tests

```
mvn clean install -Dgroups="Regression" -DexcludedGroups="Profile"
```

or

```
mvn clean install -Dgroups="Regression & !Profile"
```

Run Home Page Tests but only Section One of Home Page not Section Two and Three

```
mvn clean install -Dgroups="HomePage & SectionOne"
```

By default, @ignore tag has been set to skip those tests. This can be changed by removing the below line from
TestRunner.

```
@ExcludeTags("ignore")
```

It's equivalent to

```
mvn clean install -DexcludedGroups="ignore"
```

## Reporting

Various Reports are generated in testReports directory after the execution

1. [x] **Cucumber HTML Report** -> testReports/CucumberReport.html
2. [x] **Extent HTML Report** -> testReports/ExtentReport.html
3. [x] **Extent PDF Report** -> testReports/ExtentReport.pdf
4. [x] **Master thought Cucumber Report** -> testReports/cucumber-html-reports/overview-features.html
5. [x] **Timeline Report** -> testReports/timelineReport/index.html

## Logs

Logs are written to console and as well as to log file. Log file can be found at <code>z_logs</code> directory

## Authors

<a href="https://github.com/the-sdet"><img align="center" src="https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png" alt="pabitra-qa" height="40" width="40" /></a>
[@the-sdet](https://github.com/the-sdet)

<a href="https://github.com/the-sdet"><img align="center" src="https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png" alt="pabitra-qa" height="40" width="40" /></a>
[@pabitra-qa](https://github.com/pabitra-qa)

## About Me

I'm a dedicated and passionate Software Development Engineer in Test (SDET) trying to help the community.

## Connect With Me

Connect with me over LinkedIn or visit my Website...

<a href="https://linkedin.com/in/pswain7"><img align="center" src="https://content.linkedin.com/content/dam/me/business/en-us/amp/brand-site/v2/bg/LI-Logo.svg.original.svg" alt="pabitra-qa" height="35"/></a>
&nbsp; <a href="https://pabitra-qa.github.io/"><img align="center" src="https://chromeenterprise.google/static/images/chrome-logo.svg" height="40" width="40"/></a>

## Feedback

If you have any feedback, please reach out to us at [contact.the.sdet@gmail.com](mailto:contact.the.sdet@gmail.com).
