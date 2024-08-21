Feature: Búsqueda Fallida de Contratos

  Scenario Outline: El usuario busca datos de contratos y no encuentra resultados
    Given el usuario está en la página de búsqueda de contratos
    When el usuario ingresa "<searchQuery>" en el campo de búsqueda
    Then el sistema debe mostrar "<expectedResult>"

    Examples:
      | searchQuery | expectedResult |
      | NoExist     | Error     |
      |             | Error     |
