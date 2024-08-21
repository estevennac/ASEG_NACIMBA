 Feature: Búsqueda de Personal Exitosa

   Scenario Outline: El usuario busca datos de personal y verifica resultados exitosos
     Given el usuario está en la página de búsqueda de personal
     When el usuario ingresa "<searchQuery>" en el campo de búsqueda
     Then el sistema debe mostrar "<expectedResult>"

     Examples:
       | searchQuery | expectedResult                                           |
       | r           | Se deben mostrar resultados correspondientes a r         |
       | S           | Se deben mostrar resultados correspondientes a nombres que contienen S |