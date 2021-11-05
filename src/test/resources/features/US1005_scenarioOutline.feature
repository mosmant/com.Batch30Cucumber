@Paralel2
Feature: US1005 Amazonda liste ile arama

  Scenario Outline: TC09 amazonda verilen bir listeyi aratip, var olduklarini tespit edelim.

    Given kullanici "amazonUrl" sayfasina gider
    Then "<arananUrun>" icin arama yapar
    And sonuc sayisini yazdirir.
    And sonucun "<arananUrun>" icerdigini test eder
    Then sayfayi kapatir

    #<<arananUrun> list olarak aranaccak kelimeleri temsil eder.

    Examples:
    |arananUrun|
    |nutella|
    |ipod|
    |armut|
    |Apple|