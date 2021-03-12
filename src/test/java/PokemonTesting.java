import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PokemonTesting {

    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        RestAssured.given().
                when().
                get("https://pokeapi.co/api/v2/type/fire").
                then().
                assertThat().
                contentType(ContentType.JSON);

    }
    @Test
    public void  http_Service_work() throws IOException {
        HttpService httpService = new HttpService();

    Assert.assertTrue(httpService.connect("https://pokeapi.co/api/v2/type/fire").startsWith("{"));
    }

    @Test
    public void  check_Pokemon_Connection(){
        MainApp mainApp = new MainApp();
        Pokemon pokemon = mainApp.connectByPokemonType("fire");

        Assert.assertFalse(pokemon.doubleDamageTo.isEmpty());
    }

    @Test
    public void check_count_DMG(){
         MainApp mainApp = new MainApp();
        Pokemon pokemon = mainApp.connectByPokemonType("fire");

        Assert.assertEquals(mainApp.countDamage("grass",pokemon),2,0);

    }
}
