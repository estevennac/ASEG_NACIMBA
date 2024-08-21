Feature: Agregar Nuevo Requerimiento - Fallido
  Scenario Outline: Agregar Requerimiento Fallido
    Given el usuario está en la página de agregar requerimiento
    When el usuario ingresa los datos "<cargo>", "<departamento>", "<denominacion>", "<dedicacion>" y "<sede>"
    And el usuario hace clic en "Agregar Requerimiento"
    Then el resultado de la operación es "Por favor, llene todos los campos obligatorios"

    Examples:
      | cargo | departamento                    | denominacion                | dedicacion | sede   |
      |       |                                 | PROFESOR NO TITULAR OCASIONAL| TIEMPO COMPLETO| MATRIZ |
      | 3     | DEPARTAMENTO DE CIENCIAS EXACTAS| PROFESOR NO TITULAR OCASIONAL|             | MATRIZ |
