# Feature: Agregar Nuevo Tiempo
#
#  Scenario Outline: Agregar Tiempo
#    Given el usuario está en la página de agregar tiempo
#    When el usuario ingresa los datos "<descripcion>", "<codigo>", "<horas>"
#    And el usuario hace clic en "Agregar Tiempo"
#    Then el resultado de la operación es "<resultado>"
#
#    Examples:
#      | descripcion       | codigo | horas | resultado                          |
#      | Tiempo parcial | 123456  | 40    | Tiempo agregado correctamente        |
#      | Medio Tiempo      | 678906  | 20    | Tiempo agregado correctamente        |
#      |                   | 12345  | 30    | Por favor, llene todos los campos obligatorios |
#      | Tiempo completo   |        | 40    | Por favor, llene todos los campos obligatorios |
#
