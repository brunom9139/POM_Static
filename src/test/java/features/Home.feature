# language: es

Característica: Estos test solo tienen click a paginas de la home de demoqa

  @test @logeo @test1_logeo1
  Escenario: Validar seccion elements
    Dado que ingreso a la seccion elements
    Entonces valido que aparece el texto "Please select an item from left to start practice."

  @test @logeo @test1_logeo
  Escenario: Validar seccion elements 2
    Dado que ingreso a la seccion elements
    Entonces valido que aparece el texto "Please select an item from left to start practice."

  @REGRESION @COMPROBANTES @HB-8966
  Escenario: Validar seccion elements 3
    Dado que ingreso el texto "hola"