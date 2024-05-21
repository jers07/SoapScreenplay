Feature:  pruebas de calculadora
  yo como
  quiero
  para
  @suma
  Scenario: pruebas de suma
    Given que el es usuario quiere sumar 20 con el numero 15
    When hace la peticion de suma
    Then deberia obtener el resultado de 35

  @resta
  Scenario: prueba de resta
    Given que el usuario quiere restar 30 con el numero 20
    When hace la peticion de resta
    Then deberia obtener el resultado de 10

  @multiplicacion
  Scenario: prueba de multiplicacion
    Given que el usuario quiere multiplicar 10 con el numero 2
    When hace la peticion de multiplicar
    Then deberia obtener el resultado de 20

  @division
  Scenario: prueba de division
    Given que el usuario quiere dividir 50 con el numero 25
    When hace la peticion de divicion
    Then deberia obtener el resultado de 2
