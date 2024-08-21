Feature: Actualización de Contrato

Scenario Outline: Actualización de Datos del Contrato
Given el usuario accede a la página de actualización de contratos
When el usuario selecciona el contrato con ID "<idcontrato>"
And el usuario actualiza los datos del contrato con "<fechainicio>", "<fechaFin>", "<fuente>", "<fecha>", "<certificacion_presupuestaria>", "<idmemo>", "<analistadelproceso>", "<archivomemo>"
Then el resultado de la actualización es "<resultado>"

Examples:
| idcontrato | fechainicio | fechaFin  | fuente    | fecha    | certificacion_presupuestaria | idmemo | analistadelproceso | archivomemo | resultado                                      |
| 1          | 01-01-2024  | 01-07-2024 | Fuente A  | 01-01-2024 | Certificación A               | MEMO123 | Analista 1          | archivo1.pdf | Contrato actualizado correctamente              |
