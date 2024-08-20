#
#Feature: Búsqueda de Tiempos
#
#Scenario Outline: El usuario busca datos de tiempos y verifica resultados
#Given el usuario está en la página de búsqueda de tiempos
#When el usuario ingresa "<searchQuery>" en el campo de búsqueda
#Then el sistema debe mostrar "<expectedResult>"
#
#Examples:
#| searchQuery        | expectedResult                                         |
#| 1                  | Se deben mostrar resultados correspondientes al tiempo 1 |
#| NoExist            | Fallida           |
#| TP 10                 | Se deben mostrar resultados para el tiempo con código TP 10|
#|                   |      Fallida campos faltantes      |
