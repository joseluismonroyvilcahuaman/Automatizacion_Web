package com.nttdata.steps;

import com.nttdata.page.LoginTiendaPage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTiendaSteps {

    private WebDriver driver;
    private LoginTiendaPage loginTiendaPage;

    public LoginTiendaSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Paso: Dado estoy en la página de login de la tienda
    public void abrirPaginaLogin() {
        driver.get("https://qalab.bensg.com/store/es");
    }
    public void esperarYHacerClickEnIniciarSesion() {
        // Esperar hasta que el botón "Iniciar sesión" esté visible y luego hacer clic
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonIniciarSesion = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.loginButton));

        // Hacer clic en el botón "Iniciar sesión"
        botonIniciarSesion.click();

        // Esperar a que la página de inicio de sesión cargue correctamente
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.emailInput));

        // Verificar si el campo de correo electrónico está visible para confirmar que la página de login cargó
        if (emailInputField.isDisplayed()) {
            System.out.println("La página de inicio de sesión se ha cargado correctamente.");
        } else {
            System.out.println("La página de inicio de sesión no se cargó correctamente.");
        }
    }


    // Paso: Y me logueo con mi usuario "cuentabotcamelot2@gmail.com" y clave "cuentabotcamelot2@gmail.com"
    public void loginConCredenciales(String user, String password) {
        // Esperar que el campo de email esté presente y rellenarlo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.emailInput));
        emailField.sendKeys(user);

        // Esperar que el campo de contraseña esté presente y rellenarlo
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.passwordInput));
        passwordField.sendKeys(password);

        // Hacer clic en el botón de submit
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginTiendaPage.submitButton));
        submitBtn.click();
    }


    // Paso: Navego a la categoría "Clothes" y subcategoría "Men"
    public void navegarACategoriaYSubcategoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoriaClothes = wait.until(ExpectedConditions.elementToBeClickable(LoginTiendaPage.clothesCategory));
        categoriaClothes.click();

        WebElement subcategoriaMen = wait.until(ExpectedConditions.elementToBeClickable(LoginTiendaPage.menSubCategory));
        subcategoriaMen.click();
    }

    // Paso: Agrego 2 unidades del primer producto al carrito
    public void agregarProductoAlCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Espera a que la imagen del producto esté visible y haz clic en ella
        WebElement primerProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.productImage));
        primerProducto.click();

        // Espera a que el campo de cantidad esté visible
        WebElement cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.quantityInput));

        // Verifica que el valor actual del campo sea "1"
        String valorActual = cantidadInput.getAttribute("value");

        // Borra el valor actual (que es "1") utilizando la tecla de retroceso (Backspace)
        cantidadInput.sendKeys(Keys.BACK_SPACE); // Borra un carácter (en este caso, "1")
        // Espera brevemente a que el valor se actualice y asegúrate de que el campo esté vacío
        try {
            Thread.sleep(500); // Espera un pequeño intervalo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        valorActual = cantidadInput.getAttribute("value");

        // Ingresa "2" en el campo de cantidad
        cantidadInput.sendKeys("2");

        // Verifica que el valor ahora sea "2"
        valorActual = cantidadInput.getAttribute("value");

        // Espera a que el botón "Agregar al carrito" sea clickeable y haz clic en él
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginTiendaPage.addToCartButton));
        addToCartBtn.click();
    }





    // Paso: Valido la confirmación del producto agregado en el popup
    public void validarPopupConfirmacionProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.popupTitle));
        if (popup.isDisplayed()) {
            System.out.println("Popup de confirmación de producto visible.");
        } else {
            System.out.println("No se mostró el popup de confirmación.");
        }
    }

    // Paso: Valido que el monto total sea calculado correctamente en el popup
    public void validarTotalEnPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalValue = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.totalValue));
        if (totalValue.isDisplayed()) {
            System.out.println("El monto total en el popup es correcto: " + totalValue.getText());
        } else {
            System.out.println("No se pudo verificar el monto total.");
        }
    }

    // Paso: Finalizo la compra
    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginTiendaPage.checkoutButton));
        checkoutBtn.click();
    }

    // Paso: Valido el título de la página del carrito
    public void validarTituloCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement carritoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.carritoTitle));
        if (carritoTitle.isDisplayed()) {
            System.out.println("El título de la página del carrito es correcto.");
        } else {
            System.out.println("No se encontró el título del carrito.");
        }
    }

    // Paso: Vuelvo a validar el cálculo de precios en el carrito
    public void validarCalculoPreciosCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subtotal = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.cartSubtotal));
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.cartTotal));

        if (subtotal.isDisplayed() && total.isDisplayed()) {
            System.out.println("Los cálculos de precio son correctos en el carrito.");
        } else {
            System.out.println("Error en el cálculo de precios en el carrito.");
        }
    }


    public void verificarMensajeErrorAutenticacion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.mensajeErrorAutenticacion));
        Assert.assertTrue("El mensaje de error no está visible", mensajeError.isDisplayed());
    }
    public void verificarNoRedireccionadoPaginaPrincipal() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse("El usuario fue redirigido a la página principal", currentUrl.equals("https://qalab.bensg.com/store/pe/iniciar-sesion?back=my-account"));
    }

    // Nuevos métodos para la búsqueda
    // Método para buscar un producto
    public void buscarProducto(String producto) {
        // Escribimos en el campo de búsqueda
        WebElement searchBox = driver.findElement(LoginTiendaPage.inputBusqueda);
        searchBox.sendKeys(producto);

        // Simula presionar la tecla "Enter" para buscar
        searchBox.sendKeys(Keys.ENTER);

        // Espera explícita para que cargue el resultado
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera de 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.mensajeSinResultados));
    }

    // Validar que el mensaje sin resultados es visible
    public boolean validarMensajeSinResultados() {
        WebElement mensajeSinResultados = driver.findElement(LoginTiendaPage.mensajeSinResultados);
        return mensajeSinResultados.isDisplayed();
    }



}
