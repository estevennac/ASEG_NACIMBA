Feature: Búsqueda de Personal Fallido
Scenario Outline: El usuario busca datos de personal y no encuentra resultados
Given el usuario está en la página de búsqueda de personal
When el usuario ingresa "<searchQuery>" en el campo de búsqueda
Then el sistema debe mostrar "<expectedResult>"

Examples:
| searchQuery | expectedResult                      |
| NoExist     | Debe mostrar "No se encontraron resultados" |
|             | Debe mostrar "No se encontraron resultados" |
