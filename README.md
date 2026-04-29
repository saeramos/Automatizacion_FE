# Automatizacion Frontend - SauceDemo

Proyecto de automatizacion UI para el reto tecnico QA Frontend, implementado con **Gradle + Serenity BDD + Selenium WebDriver + Cucumber (Gherkin) + Screenplay Pattern**.

## Cobertura implementada

- Autenticacion exitosa (usuario valido)
- Autenticacion fallida (usuario bloqueado) - escenario negativo
- Gestion de productos (agregar productos)
- Filtrado / ordenamiento de productos
- Carrito de compras (validacion de cantidad y pagina de carrito)

## Estructura

- `build.gradle`, `settings.gradle`, `gradlew`, `gradlew.bat`
- `serenity.conf`
- `src/main/java/com/saucedemo/screenplay/`
  - `ui`: localizadores de pagina
  - `tasks`: acciones de negocio
  - `questions`: validaciones Screenplay
  - `models`: modelos de datos
  - `utils`: datos de prueba
- `src/test/java/com/saucedemo/screenplay/`
  - `stepdefinitions`: definiciones de pasos
  - `runners`: runner de Cucumber + Serenity
- `src/test/resources/features`
  - `saucedemo_flujo.feature`

## Pre-requisitos

- Java 17 o superior instalado
- Google Chrome instalado
- Conexion a internet (para descargar dependencias y WebDriver)

## Ejecucion

### Windows (PowerShell)

```powershell
.\gradlew.bat clean test aggregate
```

### Linux / macOS

```bash
./gradlew clean test aggregate
```

## Reportes

Al finalizar la ejecucion, abre:

- `target/site/serenity/index.html`

## Escenarios incluidos

1. **Login exitoso y compra basica con filtro**
   - Login con credenciales validas
   - Ordenamiento de productos por precio ascendente
   - Agregar dos productos al carrito
   - Validacion de titulo del carrito y cantidad de items

2. **Login fallido por usuario bloqueado**
   - Login con `locked_out_user`
   - Validacion del mensaje de error mostrado en UI
