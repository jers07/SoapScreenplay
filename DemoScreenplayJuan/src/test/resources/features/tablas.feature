Feature: Manejo de fechas
  yo como usuario de la pagina demoqa
  quiero manipular el calanedario
  para poder seleccionar fechas

  Scenario: Seleccionar Fechas
    Given el usuario esta en la pagina inicial de demoQA
    When navega hasta la opcion date picker
    And selecciona las fechas de los dos campos
      | date | month   | year | hour    |
      | 10   | October | 2022 | 5:00 PM |
      | 10   | Febrero | 2022 | 5:00 PM |
      | 10   | October | 2022 | 7:00 AM |
    Then la pagina debera mostrar las fechas seleccionadas