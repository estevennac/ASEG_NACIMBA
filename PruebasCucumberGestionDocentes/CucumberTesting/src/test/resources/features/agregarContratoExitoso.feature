Feature: Agregar Nuevo Contrato

Scenario Outline: Agregar Contrato Exitoso
Given el usuario está en la página de agregar contrato
When el usuario selecciona el docente "<docente>", el requerimiento "<requerimiento>" y llena los datos "<fechaInicio>", "<fechaFin>", "<fuente>", "<fecha>", "<certificacionPresupuestaria>", "<idMemo>", "<analistaDelProceso>" y "<archivoMemo>"
And el usuario hace clic en "Agregar Contrato"
Then el resultado de la operación es "<resultado>"

Examples:
| docente                                      | requerimiento                                                                 | fechaInicio | fechaFin  | fuente | fecha     | certificacionPresupuestaria | idMemo | analistaDelProceso                        | archivoMemo | resultado                          |
| ALAVA FREIRE JORGE ENRIQUE CI: 1706348073 | Matriz / CENTRO DE NANO CIENCIA Y NANO TECNOLOGÍA / PROFESOR NO TITULAR OCASIONAL / TIEMPO COMPLETO | 2024-01-01 | 2024-12-31 | Fuente A | 2024-01-01 | Certificación 223            | Memo009 | ALAVA FREIRE JORGE ENRIQUE         | Archivo021 | Contrato agregado correctamente     |
