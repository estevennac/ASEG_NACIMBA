#
#Feature: Búsqueda de Contratos
#Scenario Outline: El usuario busca datos de contratos y verifica resultados
#Given el usuario está en la página de búsqueda de contratos
#When el usuario ingresa "<searchQuery>" en el campo de búsqueda
#Then el sistema debe mostrar "<expectedResult>"
#
#Examples:
##| searchQuery        | expectedResult                                             |
##| 1                  | Se deben mostrar resultados correspondientes al contrato 1 |
##| NoExist            | No se encontraron resultados               |
##| 123        | Se deben mostrar resultados correspondientes al contrato 123     |
##|                   | No se encontraron resultados               |
#  | searchQuery        | expectedResult                                             |
#  | 1                  | Se deben mostrar resultados correspondientes al contrato 1 |
#  | NoExist            | No existe               |
#  | 123        | Se deben mostrar resultados correspondientes al contrato 123     |
#  |                   | No existe               |