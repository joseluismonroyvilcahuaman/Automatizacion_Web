#language: es
@validacion_precio_producto
Característica: Product - Store

  Escenario: Validación del precio de un producto
    Dado estoy en la página de login de la tienda
    Y me logueo con mi usuario "cuentabotcamelot2@gmail.com" y clave "cuentabotcamelot2@gmail.com"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

  Escenario: Intento de inicio de sesión con usuario y clave inválidos
    Dado estoy en la página de login de la tienda
    Y me logueo con mi usuario "usuario_invalido@gmail.com" y clave "clave_incorrecta"
    Entonces debería ver un mensaje de error de autenticación
    Y no debería ser redirigido a la página principal

  Escenario: Ingreso exitoso con correo y contraseña y no encuentro el catálogo
    Dado que ingreso a mi cuenta "cuentabotcamelot2@gmail.com" y clave "cuentabotcamelot2@gmail.com" para buscar catalogo
    Cuando busco el producto "Auto"
    Entonces debería ver el mensaje de sin resultados

