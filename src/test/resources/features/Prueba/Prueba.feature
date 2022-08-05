Feature: Prueba de Apis

  Scenario Outline: GET to query employee
    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> |
    When verifico el status code <StatusCode>

    Then Verifico los valores esperados en el response <ValoresEsperados>
    Examples:
      | API | Peticion | Enviroment | EndPoint      | METODO | StatusCode | ValoresEsperados |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Get
|GET|Success|BASE|employees|Get|200|Successfully! All records has been fetched.|
|GET|Success|BASE|employee/1|Get|200|Successfully! Record has been fetched.|

  Scenario Outline: Post to create employee

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> |
    When verifico el status code <StatusCode>

    Then Verifico los valores esperados en el response <ValoresEsperados>
    Examples:
      | API  | Peticion | Enviroment | EndPoint | METODO       | StatusCode | ValoresEsperados    |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Post
|POST|Success|BASE|create|Post|200|Successfully! Record has been added.|


  Scenario Outline: Delete to delete employee

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>
    Examples:
      | API    | Peticion | Enviroment | EndPoint | METODO | StatusCode | ValoresEsperados              |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Delete
|DELETE|Success|BASE|delete/2|Delete|200|Successfully! Record has been deleted|
