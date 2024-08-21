Feature: Agregar Nuevo Contrato

Scenario Outline: Agregar Contrato con Campos Vacíos
Given el usuario está en la página de agregar contrato
When el usuario selecciona el docente "<docente>", el requerimiento "<requerimiento>" y llena los datos "<fechaInicio>", "<fechaFin>", "<fuente>", "<fecha>", "<certificacionPresupuestaria>", "<idMemo>", "<analistaDelProceso>" y "<archivoMemo>"
And el usuario hace clic en "Agregar Contrato"
Then el resultado de la operación es "<resultado>"

Examples:
| docente | requerimiento                                                                 | fechaInicio | fechaFin  | fuente | fecha     | certificacionPresupuestaria | idMemo | analistaDelProceso | archivoMemo | resultado                          |
      | AGUAS ALARCON Luis CI: 654321         | Matriz / CENTRO DE NANO CIENCIA Y NANO TECNOLOGÍA / PROFESOR NO TITULAR OCASIONAL / TIEMPO COMPLETO            | 2024-01-01  | 2024-12-31 | Fuente B | 2024-01-01 | Certificación 12345            | Memo0042 | AGUAS ALARCN Luis           | | Campos incompletos     |
