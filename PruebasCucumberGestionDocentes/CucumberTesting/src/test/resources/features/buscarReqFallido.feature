Feature: Búsqueda de Requerimientos Fallido
Scenario Outline: El usuario busca datos de requerimientos y no encuentra resultados
Given el usuario está en la página de búsqueda de requerimientos
When el usuario ingresa "<searchQuery>" en el campo de búsqueda
  Then el sistema debe mostrar "<expectedResult>"
Examples:
| searchQuery | expectedResult                      |
|             | Error       |
| NoExist     | Error       |
