@CH1
Feature: US1011 kullanici dogru bilgilerle sayfaya gidebilmeli

  Scenario: TC17 Positive login
    When kullanici "CHQAUrl" sayfasina gider
    Then CH login linkine tiklar
    And CH username kutusuna "manager" yazar
    And CH password kutusuna "manager1!" yazar
    And CH login butonuna basar.
    Then CH basarili girid yspildigini test eder.
    And sayfayi kapatir
