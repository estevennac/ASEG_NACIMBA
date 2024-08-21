Feature: Búsqueda Exitosa de Contratos

  Scenario Outline: El usuario busca datos de contratos y verifica resultados exitosos
    Given el usuario está en la página de búsqueda de contratos
    When el usuario ingresa "<searchQuery>" en el campo de búsqueda
    Then el sistema debe mostrar "<expectedResult>"

    Examples:
      | searchQuery | expectedResult                                               |
      | 1           | Se deben mostrar resultados correspondientes al contrato 1   |
      | 123         | Se deben mostrar resultados correspondientes al contrato 123 |
