 Feature: Búsqueda de Requerimientos Exitoso

   Scenario Outline: El usuario busca datos de requerimientos y verifica resultados exitosos
     Given el usuario está en la página de búsqueda de requerimientos
     When el usuario ingresa "<searchQuery>" en el campo de búsqueda
     Then el sistema debe mostrar "<expectedResult>"

     Examples:
       | searchQuery | expectedResult                                           |
       | r           | Se deben mostrar resultados correspondientes a r         |
       | S           | Se deben mostrar resultados correspondientes a nombres que contienen S |
