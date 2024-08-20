#Feature: Actualización de Información del Requerimiento
#
#  Scenario Outline: Actualización de Datos del Requerimiento
#    Given el usuario accede a la página de gestión de requerimientos
#    When el usuario selecciona el requerimiento con ID "<idrequerimiento>"
#    And el usuario actualiza los datos del requerimiento con "<sede>", "<departamento>", "<denominacion>", "<dedicacion>"
#    Then el resultado de la actualización es "<resultado>"
#
#    Examples:
#      | idrequerimiento | sede    | departamento | denominacion  | dedicacion | resultado                          |
#      | 1               | Quito   | Ciencias     | Profesorado   | Tiempo completo | Requerimiento actualizado correctamente |
#      | 2               |         | Ingenierías  |               |             | Campos vacíos y mensaje de error  |
#      | 3               | Guayaquil|             |               |             | Información incompleta y mensaje de error |
