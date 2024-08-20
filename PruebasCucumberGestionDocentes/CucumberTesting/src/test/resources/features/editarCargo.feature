# Feature: Actualización de Información del Cargo
#
#  Scenario Outline: Actualización de Datos del Cargo
#    Given el usuario accede a la página de gestión de cargos
#    When el usuario selecciona el cargo con ID "<idcargo>"
#    And el usuario actualiza los datos del cargo con "<tipoPersonal>", "<categoria>", "<nivel>", "<grado>", "<remuneracion>"
#    Then el resultado de la actualización es "<resultado>"
#
#    Examples:
#      | idcargo | tipoPersonal                               | categoria | nivel | grado | remuneracion | resultado                             |
#      | 1       | PERSONAL ACADEMICO DE GRADO                | PRINCIPAL  | 2     | 4     | 1200          | Cargo actualizado correctamente       |
#      | 2       |                 | AUXILIAR   | 3     | 2     | 900           | Campos vacíos y mensaje de error      |
#      | 3       |                                          |           |       |       |              | Información incompleta y mensaje de error |
