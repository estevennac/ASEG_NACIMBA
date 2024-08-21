Feature: Agregar Nuevo Requerimiento - Éxito
  Scenario Outline: Agregar Requerimiento Exitoso
    Given el usuario está en la página de agregar requerimiento
    When el usuario ingresa los datos "<cargo>", "<departamento>", "<denominacion>", "<dedicacion>" y "<sede>"
    And el usuario hace clic en "Agregar Requerimiento"
    Then el resultado de la operación es "Requerimiento agregado correctamente"

    Examples:
      | cargo                                                      | departamento                    | denominacion                | dedicacion     | sede   |
      | PERSONAL ACADEMICO DE POSGRADO / AUXILIAR / 3 / 2 / 900    | DEPARTAMENTO DE CIENCIAS EXACTAS| PROFESOR NO TITULAR OCASIONAL| TIEMPO COMPLETO| MATRIZ |
      | PERSONAL ACADEMICO DE FORMACION TECNICA Y TECNOLOG / AUXILIAR / 1 / 6 / 2214.35| DEPARTAMENTO DE CIENCIAS EXACTAS| PERSONAL DE APOYO ACADÉMICO TÉCNICO DOCENTE A | TIEMPO COMPLETO | MATRIZ |
