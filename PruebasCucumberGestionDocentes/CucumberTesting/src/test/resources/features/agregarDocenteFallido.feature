Feature: Agregar Docente Fallido

Scenario Outline: Agregar Docente Fallido
Given el usuario está en la página de agregar docente
When el usuario ingresa los datos "<apellidos>", "<nombres>", "<cedula>", "<nacionalidad>", "<genero>", "<correoPersonal>", "<correoInstitucional>", "<ciudad>", "<provincia>", "<numeroPersonal>", "<campus>" y "<observaciones>"
And el usuario hace clic en "Agregar Docente"
Then el resultado de la operación es "<resultado>"

Examples:
| apellidos | nombres | cedula | nacionalidad | genero   | correoPersonal           | correoInstitucional     | ciudad | provincia | numeroPersonal | campus | observaciones     | resultado                                        |
| Pérez     |         | 123456 | Ecuador      | MASCULINO | juan.perez@example.com | juan.perez@universidad.edu | Quito  | Pichincha | 1234567890     | MATRIZ | Notas adicionales | Por favor, llene todos los campos obligatorios |
