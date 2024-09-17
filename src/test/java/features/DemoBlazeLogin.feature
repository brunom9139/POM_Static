# language: es

Característica: Test de registro de usuarios, logueo y desbloqueó
  Como un usuario del sistema,
  Quiero poder registrarme si no tengo cuenta, iniciar sesión y cerrar sesión,
  Para asegurarme de que puedo acceder a las funcionalidades del sistema

  @TEST @LOGUEO @TEST_001
  Escenario: Registro usuario exitoso
    Dado Un usuario no registrado se desea registrar a la página web de la empresa
    Cuando Ingresa nombre de usuario y contraseña validos "username" "password"
    Entonces Se registra el usuario correctamente "alert"

  @TEST @LOGUEO @TEST_002
  Escenario: Registro usuario fallido - credenciales inválidas
    Dado Un usuario no registrado se desea registrar a la página web de la empresa
    Cuando Ingresa nombre de usuario y contraseña incorrectos o inválidos "username" "password"
    #Entonces No se permite registrar el usuario

  @TEST @LOGUEO @TEST_003
  Escenario: Registro fallido - usuario ya registrado
    Dado Un usuario registrado se desea registrar a la página web de la empresa
    Cuando Ingresa nombre de usuario y contraseña ya registrados "username" "password"
    Entonces No se permite registrar el usuario "alert"

  @TEST @LOGUEO @TEST_004
  Escenario: Logueo válido - acceso exitoso
    Dado Un usuario registrado se desea loguear a la página web de la empresa
    Cuando Ingresa nombre de usuario y contraseña validos en login "username" "password"
    Entonces Se loguea en la pagina correctamente "login"

  @TEST @LOGUEO @TEST_005
  Escenario: Logueo fallido - credenciales inválidas
    Dado Un usuario registrado se desea loguear a la página web de la empresa
    Cuando Ingresa nombre de usuario y contraseña invalidos "username" "password"
    Entonces No se loguea informando la situación "alert"

  @TEST @LOGUEO @TEST_006
  Escenario: Deslogueo exitoso
    Dado Un usuario logueado en la página web de la empresa "username" "password"
    Cuando Desea desloguearse
    Entonces Se deloguea correctamente "login"