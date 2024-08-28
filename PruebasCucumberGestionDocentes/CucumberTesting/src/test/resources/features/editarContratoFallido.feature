Feature: Actualización de Contrato

Scenario Outline: Actualización de Datos del Contrato con Campos Vacíos o Incompletos
Given el usuario accede a la página de actualización de contratos
When el usuario selecciona el contrato con ID "<idcontrato>"
And el usuario actualiza los datos del contrato con "<fechainicio>", "<fechaFin>", "<fuente>", "<fecha>", "<certificacion_presupuestaria>", "<idmemo>", "<analistadelproceso>", "<archivomemo>"
Then el resultado de la actualización es "<resultado>"

Examples:
| idcontrato | fechainicio | fechaFin | fuente | fecha    | certificacion_presupuestaria | idmemo | analistadelproceso | archivomemo | resultado                                      |
| 2          |             |          | Fuente B | 2024-01-01 | Certificación B               | MEMO456 | Analista 2          | archivo2.pdf | Campos vacíos y mensaje de error               |
