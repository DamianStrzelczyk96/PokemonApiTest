import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private void startApp(){
        String oponentPokoemonType;
        Pokemon yourPokemon = new Pokemon();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ pokemona");
        String pokemonType = scanner.nextLine();
        System.out.println("Podaj typ wrogiego pokemona");
        oponentPokoemonType = scanner.nextLine();
        yourPokemon = connectByPokemonType(pokemonType);

        double dmg = countDamage(oponentPokoemonType,yourPokemon);

        System.out.println(pokemonType + " vs " + oponentPokoemonType + ": dmg =  x " + dmg);
        System.out.println("");
        System.out.println("Naciśnij '1' aby kontynuowc lub '0' aby zakonczyc");
        int status =0;
        Scanner scanner1 = new Scanner(System.in);
        status = scanner1.nextInt();
        if(status!=0){
            startApp();
        }else {
        }

    }

    public double countDamage(String oponentPokoemons , Pokemon yourPok){
        double atack = 1;

        String[] actualValue = oponentPokoemons.split(" ");
        int num = 0;
        try {
            while (actualValue[num] != null) {
                String oponentPokoemon = actualValue[num];
                List<String> attacksX2 = yourPok.getDoubleDamageTo();
                List<String> attacksXFalf = yourPok.getHalfDamageTo();
                List<String> attacksX0 = yourPok.getNoDamageTo();
                if (attacksX2.contains(oponentPokoemon)) {
                    atack = atack * 2;
                }
                if (attacksXFalf.contains(oponentPokoemon)) {
                    atack = atack * (0.5);
                }
                if (attacksX0.contains(oponentPokoemon)) {
                    atack = atack * 0;
                }
                num++;
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }
        return atack;
    }

    public Pokemon connectByPokemonType(String pokemonType){
        String response = null;
        try {
            response = new HttpService().connect(pokemonType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseJsonForPokeontType(response);
    }

    private Pokemon parseJsonForPokeontType(String json) {
        JSONObject rootObject = new JSONObject(json);
        Pokemon pokemon = new Pokemon();
        JSONObject damage_relations = rootObject.getJSONObject("damage_relations");
        JSONArray double_damage_to = damage_relations.getJSONArray("double_damage_to");
        int i = 0;
        try {
            while (double_damage_to.get(i)!=null){
                JSONObject one = (JSONObject) double_damage_to.get(i);
                if(one.getString("name")!=null){
                    pokemon.setDoubleDamageTo(one.getString("name"));}
                i++;
            }
        }catch (JSONException e){
        }

        JSONArray half_damage_to = damage_relations.getJSONArray("half_damage_to");

        int j = 0;
        try {
            while (half_damage_to.get(j)!=null) {
                JSONObject one = (JSONObject) half_damage_to.get(j);
                pokemon.setHalfDamageTo(one.getString("name"));
                j++;
            }
        }catch (JSONException e){

        }
        JSONArray no_damage_to = damage_relations.getJSONArray("no_damage_to");
        int k = 0;
        try {
            while (no_damage_to.get(k)!=null){

                JSONObject one = (JSONObject) no_damage_to.get(k);

                pokemon.setNoDamageTo(one.getString("name"));
                k++;
            }
        }catch (JSONException e){
        }
        return pokemon;

    }


    public void run() {
        startApp();
    }
}
