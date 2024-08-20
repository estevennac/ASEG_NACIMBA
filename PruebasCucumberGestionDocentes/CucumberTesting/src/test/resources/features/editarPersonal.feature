# Feature: Actualización de Información del Docente
#
#  Scenario Outline: Actualización de Datos del Docente
#    Given el usuario accede a la página de gestión de personal
#    When el usuario selecciona el docente con ID "<iddocente>"
#    And el usuario actualiza los datos del docente con "<apellidos>", "<nombres>", "<cedula>", "<nacionalidad>", "<genero>", "<correop>", "<correoi>", "<ciudad>", "<provincia>", "<numero>", "<campus>", "<observacion>"
#    Then el resultado de la actualización es "<resultado>"
#
#    Examples:
#      | iddocente | apellidos | nombres | cedula | nacionalidad | genero   | correop       | correoi       | ciudad   | provincia  | numero | campus   | observacion  | resultado                       |
#      | 1       | Pérez     | Juan    | 123456 | Ecuatoriana   | MASCULINO| juan.perez@dominio.com | juan.perez@espe.edu.ec | Quito    | Pichincha | 1234   | Central   | Observación adicional | Personal actualizado correctamente            |
#      | 2       | González  | Ana     |         |               | FEMENINO | ana.gonzalez@dominio.com | ana.gonzalez@espe.edu.ec | Ambato   | Tungurahua | 5678   | Norte    |  | Campos vacíos y mensaje de error |
#      | 4       |           | Luis    | 654321 |               |          | luis@dominio.com         | luis@espe.edu.ec         | Puyo     | Pastaza    | 7890   | Sur      |  | Información incompleta y mensaje de error |
