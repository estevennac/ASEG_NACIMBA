Feature: Login Exitoso

  Scenario Outline: Inicio de Sesión Exitoso
    Given el usuario ingresa a la página de login
    When el usuario ingresa datos "<nombreus>" "<contraseniaus>"
    Then el resultado del login es "<resultado>"

    Examples:
      | nombreus | contraseniaus | resultado   |
      | admin    | admin         | redirigido  |
      | a    | a         | redirigido  |
