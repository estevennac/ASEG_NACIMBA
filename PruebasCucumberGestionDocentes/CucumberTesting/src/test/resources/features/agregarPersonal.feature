# Feature: Agregar Nuevo Docente
#
#  Scenario Outline: Agregar Docente
#    Given el usuario está en la página de agregar docente
#    When el usuario ingresa los datos "<apellidos>", "<nombres>", "<cedula>", "<nacionalidad>", "<genero>", "<correoPersonal>", "<correoInstitucional>", "<ciudad>", "<provincia>", "<numeroPersonal>", "<campus>" y "<observaciones>"
#    And el usuario hace clic en "Agregar Docente"
#    Then el resultado de la operación es "<resultado>"
#
#    Examples:
#      | apellidos | nombres | cedula | nacionalidad | genero | correoPersonal | correoInstitucional | ciudad | provincia | numeroPersonal | campus    | observaciones | resultado                          |
#      | Castillo    | Sofia   | 1727296123 | Ecuador      | FEMENINO | sofiacastillo@espe.edu.com | sofia@universidad.edu | Quito  | Pichincha | 1234577890     | MATRIZ    | Notas adicionales | Docente agregado correctamente |
#      | Pérez     |         | 123456 | Ecuador      | MASCULINO | juan.perez@example.com | juan.perez@universidad.edu | Quito  | Pichincha | 1234567890     | MATRIZ    | Notas adicionales | Por favor, llene todos los campos obligatorios |
#      | Pérez     | Juan    |         | Ecuador      | MASCULINO | juan.perez@example.com | juan.perez@universidad.edu | Quito  | Pichincha | 1234567890     | MATRIZ    | Notas adicionales | Por favor, llene todos los campos obligatorios |
