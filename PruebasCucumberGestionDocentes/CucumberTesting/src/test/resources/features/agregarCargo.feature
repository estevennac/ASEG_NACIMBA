# Feature: Agregar Nuevo Cargo
#
#  Scenario Outline: Agregar Cargo
#    Given el usuario está en la página de agregar cargo
#    When el usuario ingresa los datos "<tiempo>", "<tipoPersonal>", "<categoria>", "<nivel>", "<grado>", "<remuneracion>"
#    And el usuario hace clic en "Agregar Cargo"
#    Then el resultado de la operación es "<resultado>"
#
#    Examples:
#      | tiempo  | tipoPersonal                                | categoria | nivel | grado | remuneracion | resultado                          |
#      | 1       | PERSONAL DE APOYO ACADEMICO                  | PRINCIPAL  | 1     | 0     | 1000          | Cargo agregado correctamente        |
#      |         | PERSONAL DE APOYO ACADEMICO                  | PRINCIPAL  | 1     | 0     | 1000          | Por favor, llene todos los campos obligatorios |
#      | 1       |                                            | PRINCIPAL  | 1     | 0     | 1000          | Por favor, llene todos los campos obligatorios |
#      | 1       | PERSONAL DE APOYO ACADEMICO                  |           | 1     | 0     | 1000          | Por favor, llene todos los campos obligatorios |
#      | 1       | PERSONAL DE APOYO ACADEMICO                  | PRINCIPAL  |       | 0     | 1000          | Por favor, llene todos los campos obligatorios |
#      | 1       | PERSONAL DE APOYO ACADEMICO                  | PRINCIPAL  | 1     | 0     |              | Por favor, llene todos los campos obligatorios |
