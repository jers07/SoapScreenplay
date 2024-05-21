#language:es
#encoding:UTF-8
#Author: Juan Esteban Pineda Angel

Característica: realizar adiciones al carrito
  yo como usuario de la pagina https://automationexercise.com/
  quiero agregar productos al carrito de compras
  para poder realizar mi pedido

  Regla: reglauno
    @test1
    Esquema del escenario:  Realizar compra de prendas con usuario registrado
      Dado que el usuario <usuario> se encuentra en el sitio web
      Cuando se registra e inicia sesion en la plataforma con el usuario <usuario> y el correo <correo>
      Y selecciona los productos finalizando su compra
      Entonces debería visualizar un mensaje con la informacion de su orden
      Ejemplos:
        | usuario               | correo                          |
        | "Juanes pineda angel" | "juan.pineda35519149@gmail.com" |


  Regla: reglados
    @test2
    Escenario: prueba de escenario
      Dado que estoy tal
      Cuando  hagp tal
      Entonces  deberia tal