Feature: Actualización Fallida de Información del Docente

Scenario: Actualización Fallida por Campos Vacíos
Given el usuario accede a la página de gestión de personal
When el usuario selecciona el docente con ID "2"
And el usuario actualiza los datos del docente con "González", "Ana", "", "", "FEMENINO", "ana.gonzalez@dominio.com", "ana.gonzalez@espe.edu.ec", "Ambato", "Tungurahua", "5678", "Norte", ""
Then el resultado de la actualización es "Campos vacíos y mensaje de error"

Scenario: Actualización Fallida por Información Incompleta
Given el usuario accede a la página de gestión de personal
When el usuario selecciona el docente con ID "4"
And el usuario actualiza los datos del docente con "", "Luis", "654321", "", "", "luis@dominio.com", "luis@espe.edu.ec", "Puyo", "Pastaza", "7890", "Sur", ""
Then el resultado de la actualización es "Información incompleta y mensaje de error"
