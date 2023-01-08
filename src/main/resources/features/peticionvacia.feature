# language: es
@FeatureName:enviarPeticion
Característica: Enviar una peticion vacia
  Como cliente del sitio web Demo Web Shop
  necesito poder enviar peticiones
  para resolver P.Q.R.S

  @ScenarioName:enviarPeticion
  Escenario: Enviar una peticion vacia
    Dado que el cliente ingresa al landing page y luego se loguea con  credenciales de usuario
    Cuando el cliente se dirige a la zona de contact Us
    Y realiza la peticion con el campo de enquiry vacio
    Entonces como resultado el usuario recibira un mensaje de alerta solicitando que ingrese el enquiry