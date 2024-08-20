#
#Feature: Login
#
#  Scenario Outline: Inicio de Sesión
#    Given el usuario ingresa a la página de login
#    When el usuario ingresa datos "<nombreus>" "<contraseniaus>"
#    Then el resultado del login es "<resultado>"
#
#    Examples:
#      | nombreus | contraseniaus | resultado                    |
#      | admin   | admin        | redirigido                   |
#      |         |            | Todos los campos son obligatorios |
#      | admin   | admin  | Intento fallido de redirigir |
#      | admin   | 123        | redirigido                   |

Feature: Login

  Scenario: Inicio de Sesión exitoso con credenciales correctas
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "admin" "admin"
    Then el resultado del login es "redirigido"

  Scenario: Inicio de Sesión con campos vacíos
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "" ""
    Then el resultado del login es "Todos los campos son obligatorios"

  Scenario: Intento de inicio de sesión fallido con credenciales incorrectas
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "admin" "admin"
    Then el resultado del login es "Intento fallido de redirigir"

  Scenario: Inicio de Sesión exitoso con contraseña incorrecta
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "admin" "123"
    Then el resultado del login es "redirigido"
