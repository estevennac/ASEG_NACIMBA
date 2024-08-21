
Feature: Actualización Exitosa de Información del Requerimiento

  Scenario Outline: Actualización de Datos Exitosa
    Given el usuario accede a la página de gestión de requerimientos
    When el usuario selecciona el requerimiento con ID "<idrequerimiento>"
    And el usuario actualiza los datos del requerimiento con "<sede>", "<departamento>", "<denominacion>", "<dedicacion>"
    Then el resultado de la actualización es "Requerimiento actualizado correctamente"

    Examples:
      | idrequerimiento | sede    | departamento | denominacion  | dedicacion       |
      | 1               | Quito   | Ciencias     | Profesorado   | Tiempo completo  |
