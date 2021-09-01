package junit.gastonb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class manejoDeWaits {

    // existen 3 tipos de esperas:
    //1- Implicita: donde noostros definimos un tiempo de espera pero para las instrucciones "findElement. Se define una sola vez, y sirve para toda la ejecucion. Se invoca a travez del manage(driver). En el ¿Before. Esta opcion de espera no es recomendable ya que podes hacer mal uso del tiempo. Puede llegar a ser mucho tiempo de espera mas cuando se usan varios botenes x ej.
    //2- Explicita:
    //3- Fluence : es mas configurable q la anterior
    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

        //espera implicita --> se define 1 sola vez y sirve para toda la ejecucion
        // findelement --> findelement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// no se encuentra el elemento Exceptcion: No
    }
    @Test
    public void explicita(){
        //espera explciita --> WebDriverWait   es decir si queremos usar un objeto de la clase espera tenemos q declararlo
        WebDriverWait exwait = new WebDriverWait(driver, 10); //primero siempre el driver, y luego la cantidad a esperar
        By localizadorAEsperar = By.xpath("//h4[contains(text(),'Hello World!')]");

        //flujo funcional
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement btnStart = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        //click
        btnStart.click();
        //esperar explicita --> Condicion Esperada
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));
        //capturar el elemento
        WebElement hello = driver.findElement(localizadorAEsperar); //hello-> hellow word
        Assert.assertEquals("Hello World!", hello.getText());
    }
    @Test
    public void fluentWait(){
        //fluent Wait :  mayor control de configuracion, se usa para llamadas asincronicas
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) //set timeout
                .pollingEvery(Duration.ofMillis(100)) //set query/ check/control interval
                .withMessage("Error de Timeout!") //set timeout message
                .ignoring(NoSuchElementException.class);//Ignore nosuchelementexception
    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
