Feature: Flujo principal de SauceDemo
  Como usuario de la tienda
  Quiero autenticarme y usar el carrito
  Para validar que el frontend responde correctamente

  Background:
    Given que el usuario abre la aplicacion

  Scenario: Login exitoso y compra basica con filtro
    When inicia sesion con credenciales validas
    And ordena los productos por "Price (low to high)"
    And agrega dos productos al carrito
    And abre el carrito
    Then deberia ver el titulo "Your Cart"

  Scenario: Login fallido por usuario bloqueado
    When inicia sesion con usuario bloqueado
    Then deberia ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."
