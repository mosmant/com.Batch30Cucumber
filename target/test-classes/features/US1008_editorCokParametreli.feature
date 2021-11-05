Feature: US1008 coklu parametreli bir step ile kisi ekleme
  @Editor2
  Scenario Outline: TC12 Editor sayfasina paramtreli olarak farkli kisiler ekleme
    Given kullanici "editorUrl" sayfasina gider
    Then new butonuna tiklar
    And editor textboxuna "<firstName>" "<lastName>" "<position>" "<office>" "<extension>" "<startDate>" "<salary>" bilgileri girer.
    And Create tusuna basar




    Examples:
      |firstName|lastName |position |office   |extension|startDate |salary|
      |osman    |turker   |QA lead  |melbourne|125      |2021-01-21|60000|
      |omer     |bulut    |QA tester|ankara   |126      |2021-01-21|80000|
      |Hakan    |Tetik    |TestLead |Paris    |124      |2021-01-21|60000|
      |Murat    |Ercoban  |QA       |Kenya    |126      |2021-01-21|40000|
      |Furkan   |Yilmaz   |QA       |Adana    |130      |2021-01-21|80000|