Feature: US1007 editor sayfasina farkli kullanicilar ekleyebilmeliyim

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

    Examples:
    |firstName|lastName|position|office|extension|startDate|salary|
    |osman|turker|QA lead|melbourne|125|12.01.2021|60000|
    |omer|bulut|QA tester|ankara|126|12.01.2021|80000|