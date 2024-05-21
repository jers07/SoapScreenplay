Feature: pruebas del servicio GET
  yo como
  quiero
  para

  @RutaFeliz
  Scenario: Solicitud de usuarios
    Given que el usuario esta en la pagina de "https://reqres.in/"
    When envia una peticion de tipo get al recurso "api/users?page=2"
    Then deberia obtener un codigo de respuesta 200
    And deberia obtener una lista con la información de los usuarios