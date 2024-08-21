Feature: Actualización Exitosa de Información del Docente

Scenario: Actualización de Datos del Docente Exitosa
Given el usuario accede a la página de gestión de personal
When el usuario selecciona el docente con ID "1"
And el usuario actualiza los datos del docente con "Pérez", "Juan", "123456", "Ecuatoriana", "MASCULINO", "juan.perez@dominio.com", "juan.perez@espe.edu.ec", "Quito", "Pichincha", "1234", "Central", "Observación adicional"
Then el resultado de la actualización es "Personal actualizado correctamente"
