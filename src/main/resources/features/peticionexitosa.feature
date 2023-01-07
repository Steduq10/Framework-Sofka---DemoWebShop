# language: es
@FeatureName:enviarPeticion
Característica: Enviar una peticion
  Como cliente del sitio web Demo Web Shop
  necesito poder enviar peticiones
  para resolver P.Q.R.S

  @ScenarioName:enviarPeticion
  Escenario: Enviar una peticion exitosa
    Dado que el cliente ingresa al landing page y luego se loguea con sus credenciales de usuario
    Cuando el cliente ingresa a la zona de contact Us
    Y realiza la peticion de forma correcta
    Entonces como resultado el usuario recibira una confirmacion de que la peticion fue enviada