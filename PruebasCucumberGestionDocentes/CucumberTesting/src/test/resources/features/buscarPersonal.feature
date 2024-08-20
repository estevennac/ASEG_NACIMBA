#Feature: Búsqueda de Personal
#
#  Scenario Outline: El usuario busca datos de personal y verifica resultados
#    Given el usuario está en la página de búsqueda de personal
#    When el usuario ingresa "<searchQuery>" en el campo de búsqueda
#    Then el sistema debe mostrar "<expectedResult>"
#
#    Examples:
#      | searchQuery        | expectedResult                                |
#      | r                  | Se deben mostrar resultados correspondientes a r   |
#      |                 | Debe mostrar "No se encontraron resultados"            |
#      | NoExist           | Debe mostrar "No se encontraron resultados"            |
#      | S                 | Se deben mostrar resultados correspondientes a nombres que contienen S |
