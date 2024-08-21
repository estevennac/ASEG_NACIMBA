Feature: Agregar Docente Exitoso

Scenario Outline: Agregar Docente Exitoso
Given el usuario está en la página de agregar docente
When el usuario ingresa los datos "<apellidos>", "<nombres>", "<cedula>", "<nacionalidad>", "<genero>", "<correoPersonal>", "<correoInstitucional>", "<ciudad>", "<provincia>", "<numeroPersonal>", "<campus>" y "<observaciones>"
And el usuario hace clic en "Agregar Docente"
Then el resultado de la operación es "<resultado>"

Examples:
| apellidos | nombres | cedula    | nacionalidad | genero   | correoPersonal           | correoInstitucional     | ciudad | provincia | numeroPersonal | campus | observaciones     | resultado                          |
| Castillo  | Maribel   | 1727266123 | Ecuador      | FEMENINO | mcastillo@espe.edu.com | m@universidad.edu | Quito  | Pichincha | 1237577890     | MATRIZ | Notas adicionales | Docente agregado correctamente      |
