import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Alltests extends BaseClass{

    private void loginProcess(String username, String password){

        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/center[2]/a")));
        login.click();

        WebElement usernamefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/form/input[1]")));
        usernamefield.sendKeys(username);

        WebElement passwordfield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/form/input[2]")));
        passwordfield.sendKeys(password);

        WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/form/button")));
        submit.click();

    }

    @Test
    public void shouldfail(){

        loginProcess("danny12@gmail.com", "doughnuts");


        boolean isErrorMessagePresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div"))).isDisplayed();

        boolean isAnnouncementAbsent = driver.findElements(By.xpath("/html/body/div/div[3]/div")).isEmpty();

        Assert.assertTrue(isErrorMessagePresent, "Error message should be present");

        Assert.assertTrue(isAnnouncementAbsent, "Announcement button should be absent");

        if (isErrorMessagePresent && isAnnouncementAbsent){

            System.out.print("Test case passed access denied");
        }

    }



    @Test
    public void shouldAlsoFail(){

        loginProcess("danny12@gmail.com", "danny1234");


        boolean isErrorMessagePresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div"))).isDisplayed();

        boolean isAnnouncementAbsent = driver.findElements(By.xpath("/html/body/div/div[3]/div")).isEmpty();

        Assert.assertTrue(isErrorMessagePresent, "Error message should be present");

        Assert.assertTrue(isAnnouncementAbsent, "Logout button should be absent");

        if (isErrorMessagePresent && isAnnouncementAbsent){

            System.out.print("Test case passed, access denied");
        }
    }



    @Test
    public void willFail(){

        loginProcess("danny@gmail.com", "danny128934");


        boolean isErrorMessagePresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div"))).isDisplayed();

        boolean isAnnouncementAbsent = driver.findElements(By.xpath("/html/body/div/div[3]/div")).isEmpty();

        Assert.assertTrue(isErrorMessagePresent, "Error message should be present");

        Assert.assertTrue(isAnnouncementAbsent, "Announcement button should be absent");

        if (isErrorMessagePresent && isAnnouncementAbsent){

            System.out.print("Test case passed access denied");
        }

    }



    @Test
    public void accessAllowed(){

        loginProcess("danny@gmail.com", "danny1234");


        boolean isAnnouncementPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/div"))).isDisplayed();

        Assert.assertTrue(isAnnouncementPresent, "Announcements should be present");

        if (isAnnouncementPresent){

            System.out.print("Test case passed access is granted");
        }


    }
}
