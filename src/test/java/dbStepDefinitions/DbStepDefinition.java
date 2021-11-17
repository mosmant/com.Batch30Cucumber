package dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbStepDefinition {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=qaconcorthotel; user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("kullanici CHQA database'ine baglanir")
    public void kullanici_chqa_database_ine_baglanir() throws SQLException {
        connection=DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


    }
    @Then("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {

        // burada table kullanmak istedigimiz tablo field da sutundu.
        // yapacagimiz sorgu da ==> SELECT Price FROM tHOTELROOM  budur.

        String readQuery= "SELECT "+field+" FROM "+table;

        // bu sorguyu dinamik hale getirdik.

        resultSet=statement.executeQuery(readQuery);

        // bu yaptigimiz yukaridaki query i calistirir. ==> statement.executeQuery(readQuery);

    }
    @Then("kullanici {string} sutunundaki verileri okur ve istedigi islemleri yapar")
    public void kullanici_sutunundaki_verileri_alir(String field) throws SQLException {


        resultSet.first();
        System.out.println(resultSet.getObject(field).toString());  //225

        // su anda method bize price sutunu getirdi. ==>  resultSet.getObject(field);

        // resultset ITERATOR GIBI CALISIR. DIKKATLI CALISMAK LAZIM. KURSORUN NEREDE OLDUGUNU SUREKLI TAKIP ETMEK GEREKIR.

        System.out.println(resultSet.next()); // true

        // resultSet.next() bir sonraki objeye gecer, sonraki eleman varsa true yoksa false doner.
        // kursordan sonra bisey var mi yok mu diye bakar.

        System.out.println(resultSet.getObject(field).toString());  //4000

        // artık kursor 2 elemanda oldugundan dolayi 2. elemanin degerini yazdirdi.

        resultSet.last();
        // sonuncu elemana gittik.

        System.out.println(resultSet.next());  // false
        // sonuncu elemandan sonra eleman olmadigi icin false aliriz.


        //TUM LISTEYI YAZDIRMAK ICIN
        //yum listeyi yazdirmak istersek while loop ile birlikte resultSet.next() kullanabiliriz.
        // cunku resultSet.next() bir sonraki obje var oldugu muddetce bize true donecek ve while loop calismaya devam edecek.
        // son objeye ulastigimizda resultSet.next() false donecek ve while loop bitecek
        // ancak biz 59. satirda sona gittigimiz icin while loop bize bisey yazdirmaz.
        // while loop calismadan evvel ilk objeye gitmek gerekir.


        /*
        resultSet.first();  // bu sekilde yaptigimizda da while loıopun icinde 1 kez calisir ve 2. objenin degerini yazdirir.
        while (resultSet.next()){
            System.out.println(resultSet.getObject(field).toString());

        }
        */

//        resultSet.absolute(0);
//        while (resultSet.next()){
//            System.out.println(resultSet.getObject(field).toString());
//        }

        // bu sorunun cevabini verir.

        // *** ACIKLAMA DATABASE DE PRICE SUTUNUNDA SORUN OLDUGUNDAN HATA VERIYOR. 1 SATIRDA NULL DEGERI OLDUGUNDAN DOLAYI...

        //========================================

        // varsa ilk 100 fiyati double olarak bir liste seklinde kaydedelim.

        int counter = 1;
        resultSet.absolute(0);
        List<Double> first100Number = new ArrayList<>();

        while (counter<101 && resultSet.next()){
            first100Number.add(resultSet.getDouble(field));
            counter++;

        }
        System.out.println(first100Number);

        // 7. FIYATIN DOUBLE OLARAK 620.0 OLDUGUNU TEST EDIN.
        resultSet.absolute(7);
        double seventhNumber = resultSet.getDouble(field);
        Assert.assertTrue(seventhNumber==620);

    }



}
