# language: es
@FeatureName:eliminarProductos
Característica: Eliminar productos
  Como cliente del sitio web Demo Web Shop
  necesito agregar productos al carrito como usuario registrado
  para luego verificar que se pueden remover del carrito

  @ScenarioName:eliminarProductos
  Escenario: Eliminar productos del carrito de compras
    Dado que el cliente ingresa al landingpage y luego ingresa con sus credenciales de usuario
    Cuando el cliente agrega productos al carrito de compras
    Y luego decide removerlos del carrito de compras
    Entonces como resultado el usuario ve que el producto ya no se encuentra en el carrito o el carrito se encuentra vacio