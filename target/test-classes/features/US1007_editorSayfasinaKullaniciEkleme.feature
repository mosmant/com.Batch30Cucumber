Feature: US1007 editor sayfasina farkli kullanicilar ekleyebilmeliyim
  @Editor
  Scenario Outline: TC11 Editor sayfasina farkli kisiler ekleme
    Given kullanici "editorUrl" sayfasina gider
    Then new butonuna tiklar
    And editor firstname textboxuna "<firstName>" bilgileri girer.
    And editor lastName textboxuna "<lastName>" bilgileri girer.
    And editor position textboxuna "<position>" bilgileri girer.
    And editor office textboxuna "<office>" bilgileri girer.
    And editor extension textboxuna "<extension>" bilgileri girer.
    And editor startDate textboxuna "<startDate>" bilgileri girer.
    And editor salary textboxuna "<salary>" bilgileri girer.
    And Create tusuna basar

    #And editor firstname textboxuna "<firstName>" "<lastName>" "<position>" "<office>" "<extension>" bilgileri girer.
    # bu

    Examples:
    |firstName|lastName |position |office   |extension|startDate |salary|
    |osman    |turker   |QA lead  |melbourne|125      |2021-01-21|60000|
    |omer     |bulut    |QA tester|ankara   |126      |2021-01-21|80000|
    |Hakan    |Tetik    |TestLead |Paris    |124      |2021-01-21|60000|
    |Murat    |Ercoban  |QA       |Kenya    |126      |2021-01-21|40000|
    |Furkan   |Yilmaz   |QA       |Adana    |130      |2021-01-21|80000|