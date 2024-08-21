Feature: Login Fallido

  Scenario Outline: Inicio de Sesión Fallido
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "<nombreus>" "<contraseniaus>"
    Then el resultado del login es "<resultado>"

    Examples:
      | nombreus | contraseniaus | resultado                             |
      |        |              | Intento fallido de redirigir|
      | admin    | c         | Intento fallido de redirigir|