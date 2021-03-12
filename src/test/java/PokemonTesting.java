import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

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
