# Feature: Búsqueda de Requerimientos
#
# Scenario Outline: El usuario busca datos de requerimientos y verifica resultados
# Given el usuario está en la página de búsqueda de requerimientos
# When el usuario ingresa "<searchQuery>" en el campo de búsqueda
# Then el sistema debe mostrar "<expectedResult>"
#
# Examples:
# | searchQuery | expectedResult                               |
# | r           | Se deben mostrar resultados correspondientes a r   |
# |             |                       |
# | NoExist     |                        |
# | S           | Se deben mostrar resultados correspondientes a nombres que contienen S |
