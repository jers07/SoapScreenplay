Feature: pruebas del servicio Post
  yo como
  quiero
  para
  Scenario: Creacion
    Given que el usuario esta en la pagina de "https://reqres.in/"
    When envia una peticion de tipo Post al recurso "api/users"
    Then deberia obtener un codigo de respuesta 201
    And deberia mostrar la información ingresada