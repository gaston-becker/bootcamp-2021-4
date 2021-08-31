package selenium.gastonb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoDeObjetos {
    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']");

    @BeforeClass
    public static void init(){
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();


    }



    @Test
    public void dropdown(){
        System.out.println("sesieon 4");
        driver.get("https://the-internet.herokuapp.com/");
        //identificar el objeto dropdown - tog : select
        WebElement dropdown = driver.findElement(By.id("dropdown") );
                //libreria aux : Select --> dropdown
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");
        manejoDropdown.selectByValue("");
        //manejoDropdown.deselectAll(); este no es xq es para manejo de multiseleccion
        manejoDropdown.selectByVisibleText("Option 1");
    }

    @Test
    public void dropDownDinamico(){
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement btnEnabled = driver.findElement(By.id("ui-menu-item"));
        WebElement btnDownload = driver.findElement(By.id("ui-menu-icon ui-icon ui-icon-carat-1-e"));
        WebElement btnPDF = driver.findElement(By.id("ui-menu-item ui-state-active"));

        btnEnabled.click();
        btnDownload.click();
        Assert.assertEquals("PDF", btnPDF.getText());
    }

    @Test
    public  void checkboc(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox1.click();
        checkbox2.click();
        checkbox1.isSelected();
        checkbox2.isSelected();
    }

    @Test
    public void iframes(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));//se puede tmb con id, pero con el tag...
        // vamos a decirle q vamos acambiar de url, nos camos al ifram(otra direccion/o doc HTML)
        driver.switchTo().frame(iframes.get(0)); //iframes: size = 1;
        //seecciono objetos de iframa para comenzar a trabajar
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("Hola saludos desde el Bootcamp Tsoft");
    }

    @Test
    public void webTables(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //traemos lo lista de web
        List<WebElement> webtables = driver.findElements(By.tagName("table"));
        //1. cuantas filas y columnas tiene la tabla 1
        List<WebElement> columnas = webtables.get(0).findElements(By.tagName("thead")).findElements(By.tagName("th")); //thead: Table head
        int sizeColumnas = columnas.size();
        //2. presionar click 2 veces al elemento 3 de la lista
        if (columnas.get(3).getText()=="Due"){
            columnas.get(3).click();
            columnas.get(3).click();
        }
        //3. Obtener las filas de los datos
        List<WebElement>  filas = webtables.get(0).findElements(By.tagName("tbody")).findElements(By.tagName("tr"));

        //4. obtener data de la pirmera fila
        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();
        //5. imprimir datos en consola
        System.out.println("El ususario con mayor deuda es: "+ nombre);
        //ejercicio tabla 2: ordenar por nombre y entregar datos de deuda de todos los usuarios sin ocupar el xpath(por atributos)
    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
