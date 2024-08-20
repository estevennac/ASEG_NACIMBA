#Feature: Búsqueda de Cargos
#
#Scenario Outline: El usuario busca datos de cargos y verifica los resultados
#Given el usuario está en la página de búsqueda de cargos
#When el usuario ingresa "<searchQuery>" en el campo de búsqueda
#Then el sistema debe mostrar "<expectedResult>"
#
#Examples:
#| searchQuery        | expectedResult                                             |
#| PERSONAL ACADEMICO DE GRADO                | Se deben mostrar resultados correspondientes al cargo PERSONAL ACADEMICO DE GRADO    |
#| NoExist            | No existe                |
#| S                 | Se deben mostrar resultados para el cargo con letra Ss   |
#|                   | No se ingreso criterio de busqueda              |
