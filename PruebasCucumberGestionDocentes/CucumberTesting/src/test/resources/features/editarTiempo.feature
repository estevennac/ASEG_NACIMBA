# Feature: Actualización de Datos del Tiempo
#
#  Scenario Outline: Actualización de Datos del Tiempo
#    Given el usuario accede a la página de gestión de tiempos
#    When el usuario selecciona el tiempo con ID "<idtiempo>"
#    And el usuario actualiza los datos del tiempo con "<horas>", "<codigo>", "<descripcion>"
#    Then el resultado de la actualización es "<resultado>"
#
#    Examples:
#      | idtiempo | horas | codigo | descripcion  | resultado                                |
#      | 1        | 10    | T001   | Descripción 1 | Requerimiento actualizado correctamente |
#      | 2        |       | T002   |              | Campos vacíos y mensaje de error        |
#      | 3        | 5     |        | Descripción 3 | Información incompleta y mensaje de error|
