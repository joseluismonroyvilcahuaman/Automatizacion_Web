package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginTiendaSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static org.junit.Assert.assertTrue;

public class LoginTiendaStepsDef {

    private WebDriver driver;
    private LoginTiendaSteps loginTiendaSteps;

    // Constructor
    public LoginTiendaStepsDef() {
        this.driver = getDriver();
        this.loginTiendaSteps = new LoginTiendaSteps(driver); // Inicializamos una vez la clase de pasos
    }

    // Escenario 1: Flujo de login correcto
    @Dado("estoy en la página de login de la tienda")
    public void estoy_en_la_página_de_login() {
        loginTiendaSteps.abrirPaginaLogin();  // Llama al método que ya existe
        loginTiendaSteps.esperarYHacerClickEnIniciarSesion();  // Llama al método que ya existe
    }

    @Cuando("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        loginTiendaSteps.loginConCredenciales(usuario, clave);  // Llama al método que ya existe
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        loginTiendaSteps.navegarACategoriaYSubcategoria();  // Llama al método que ya existe
    }

    @Cuando("agrego 2 unidades del primer producto al carrito")
    public void agrego_2_unidades_del_primer_producto_al_carrito() {
        loginTiendaSteps.agregarProductoAlCarrito();  // Llama al método que ya existe
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        loginTiendaSteps.validarPopupConfirmacionProducto();  // Llama al método que ya existe
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        loginTiendaSteps.validarTotalEnPopup();  // Llama al método que ya existe
    }

    @Cuando("finalizo la compra")
    public void finalizo_la_compra() {
        loginTiendaSteps.finalizarCompra();  // Llama al método que ya existe
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        loginTiendaSteps.validarTituloCarrito();  // Llama al método que ya existe
    }

    @Entonces("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        loginTiendaSteps.validarCalculoPreciosCarrito();  // Llama al método que ya existe
    }

    // Escenario 2: Login con error
    @Dado("estoy en la página de login de la tienda esperando")
    public void estoy_en_la_página_de_login_esperando() {
        loginTiendaSteps.abrirPaginaLogin();  // Llama al método que ya existe
        loginTiendaSteps.esperarYHacerClickEnIniciarSesion();  // Llama al método que ya existe
    }

    @Cuando("intento logueo con mi usuario {string} y clave {string}")
    public void intento_de_login(String usuario, String clave) {
        loginTiendaSteps.loginConCredenciales(usuario, clave);  // Llama al método que ya existe
    }

    @Entonces("debería ver un mensaje de error de autenticación")
    public void debería_ver_un_mensaje_de_error_de_autenticación() {
        loginTiendaSteps.verificarMensajeErrorAutenticacion();  // Llama al método que ya existe
    }

    @Y("no debería ser redirigido a la página principal")
    public void no_debería_ser_redirigido_a_la_página_principal() {
        loginTiendaSteps.verificarNoRedireccionadoPaginaPrincipal();  // Llama al método que ya existe
    }
    //3er escenario
    @Dado("que ingreso a mi cuenta {string} y clave {string} para buscar catalogo")
    public void login_catalogo(String usuario, String clave) {
        loginTiendaSteps.abrirPaginaLogin();  // Llama al método que ya existe
        loginTiendaSteps.esperarYHacerClickEnIniciarSesion();  // Llama al método que ya existe
        loginTiendaSteps.loginConCredenciales(usuario, clave);  // Llama al método que ya existe
    }

    @Cuando("busco el producto {string}")
    public void busco_el_producto(String producto) {
        LoginTiendaSteps loginTiendaSteps = new LoginTiendaSteps(driver);
        loginTiendaSteps.buscarProducto(producto);  // Llama al método que realiza la búsqueda del producto
    }

    @Entonces("debería ver el mensaje de sin resultados")
    public void debería_ver_el_mensaje_de_sin_resultados() {
        LoginTiendaSteps loginTiendaSteps = new LoginTiendaSteps(driver);
        boolean mensajeVisible = loginTiendaSteps.validarMensajeSinResultados();  // Verifica si el mensaje está visible
        assert mensajeVisible : "El mensaje de 'sin resultados' no está visible";
    }



}
