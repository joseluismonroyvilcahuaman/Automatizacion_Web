package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginTiendaPage {

    // Localizadores para la autenticación
    public static By loginButton = By.xpath("//span[normalize-space()='Iniciar sesión']");
    public static By emailInput = By.xpath("//input[@id='field-email']");
    public static By passwordInput = By.xpath("//input[@id='field-password']");
    public static By submitButton = By.xpath("//button[@id='submit-login']");
    public static By userProfile = By.xpath("//span[normalize-space()='jose luis cuenta bot']");

    // Localizadores para la categoría y subcategoría
    public static By clothesCategory = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    public static By menSubCategory = By.xpath("//ul[@class='category-sub-menu']//a[contains(text(),'Men')]");

    // Localizadores para el producto
    public static By productImage = By.xpath("//img[@alt='Hummingbird printed t-shirt']");
    public static By quantityInput = By.xpath("//input[@id='quantity_wanted']");
    public static By addToCartButton = By.xpath("//button[@class='btn btn-primary add-to-cart']");

    // Localizadores para el popup
    public static By popupTitle = By.xpath("//h4[@id='myModalLabel']");
    public static By subtotalValue = By.xpath("//span[@class='subtotal value']");
    public static By totalValue = By.cssSelector("p[class='product-total'] span[class='value']");

    // Localizadores para el carrito
    public static By checkoutButton = By.xpath("//div[@class='cart-content-btn']//a[@class='btn btn-primary']");
    public static By carritoTitle = By.xpath("//h1[normalize-space()='Carrito']");
    public static By cartSubtotal = By.xpath("//div[@id='cart-subtotal-products']//span[@class='value']");
    public static By cartTotal = By.xpath("//div[@class='cart-summary-line cart-total']//span[@class='value']");

    // Localizadores para el mensaje de error de autenticación
    public static By mensajeErrorAutenticacion = By.xpath("//li[@class='alert alert-danger']");

    // Agregamos los nuevos localizadores
    // Localizadores para el catálogo de búsqueda
    public static By inputBusqueda = By.xpath("//input[@placeholder='Búsqueda en catálogo']");
    public static By btnBuscar = By.xpath("//i[normalize-space()='search']");

    // Localizador para el mensaje sin resultados
    public static By mensajeSinResultados = By.xpath("//h4[@id='product-search-no-matches']");

}
