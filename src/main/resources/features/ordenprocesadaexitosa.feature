# language: es
@FeatureName:crearOrdenNueva
Característica: Crear una orden nueva
  Como cliente del sitio web Demo Web Shop
  necesito agregar productos al carrito como usuario registrado
  para realizar ordenes de compra en línea

  @ScenarioName:crearUnaCuenta
  Escenario: Crear una orden de compra exitosa
    Dado que el cliente ingresa al landingpage y luego se loguea con sus credenciales de usuario
    Cuando el cliente agrega productos al carrito
    Y agrega la informacion de envio y pago
    Entonces como resultado el usuario recibira una confirmacion de orden exitosa