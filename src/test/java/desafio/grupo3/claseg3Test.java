package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class claseg3Test {
    WebDriver driver; // es la instancia a crear del navegador - firefox, chrome, safari

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();; //vamos a crear una instancia de Google Chrome
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
    }



    @Test
    public void test() {
        // Your test code here
        System.out.println("Driver Chrome Configurado!");
    }

        @After
        public void close(){
            System.out.println("After");
            if(driver != null){
                driver.close();
            }

    }
}
