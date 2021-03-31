package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CBA_Task {

    WebDriver driver;

    By inputSearchField = By.id("search-input");
    By btnSearch = By.id("search-button");
    By listSearchResults =By.id("search-results");
    By divErrorText = By.id("error-empty-query");
    By divNoResult = By.id("error-no-results");

    public CBA_Task(WebDriver driver){

        this.driver = driver;

    }

    public void enterSearchQuery(String sSearchKeyWord){

        driver.findElement(inputSearchField).sendKeys(sSearchKeyWord);

    }

    public void clickSearch(){

        driver.findElement(btnSearch).click();

    }

    public String getSearchResultsList(){

         return driver.findElement(listSearchResults);

    }
    
     public String getErrorText(){

         return driver.findElement(divErrorText);

    }
    
     public String getNoResultText(){

         return driver.findElement(divNoResult);

    }

    public void TC_01_Objects_Exist(){

        boolean result = false;
        
        if ( !driver.findElements(inputSearchField).isEmpty() && !driver.findElements(btnSearch).isEmpty() ) {
            result = true;
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        return result;
        
    }
    
    public void TC_02_Empty_Query(){

        boolean result = false;
        string expectedErrorText = "Provide some query";
        
        if ( !driver.findElements(inputSearchField).isEmpty() && !driver.findElements(btnSearch).isEmpty() ) {
            enterSearchQuery("");
            clickSearch();
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        if ( getErrorText() == expectedErrorText )
        {
            result = true;
            
        }
        
        return result;
        
    }
    
    public void TC_03_Search_Results(){

        boolean result = false;
        
        if ( !driver.findElements(inputSearchField).isEmpty() && !driver.findElements(btnSearch).isEmpty() ) {
            enterSearchQuery("isla");
            clickSearch();
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        if ( driver.findElement(listSearchResults).find_elements_by_tag_name("li").size() > 0 )
        {
            result = true;
            
        }
        
        return result;
        
    }
    
    public void TC_04_Search_No_Result(){

        boolean result = false;
         string expectedErrorText = "No Results";
        
        if ( !driver.findElements(inputSearchField).isEmpty() && !driver.findElements(btnSearch).isEmpty() ) {
            enterSearchQuery("Castle");
            clickSearch();
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        if ( getNoResultText() == expectedErrorText )
        {
            result = true;
            
        }
        
        return result;
        
    }
    
     public void TC_05_Search_1_Record(){

        boolean result = false;
        
        if ( !driver.findElements(inputSearchField).isEmpty() && !driver.findElements(btnSearch).isEmpty() ) {
            enterSearchQuery("Port Royal");
            clickSearch();
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        if ( driver.findElement(listSearchResults).find_elements_by_tag_name("li").size() == 1 )
        {
            if (driver.findElement(listSearchResults).getText() == Port Royal")
            result = true;
            
        }
        
        return result;
        
    }

}

