package practice.pokemon;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonInit {
    //1. GET https://pokeapi.co/api/v2/pokemon
    //2. Validate you got 20 pokemons
    //3. Get every pokemons ability and store those in Map<String, List<String>>

    @Test
    public void testInitPokemon(){

        RestAssured.baseURI = "https://pokeapi.co";
        RestAssured.basePath = "/api/v2/pokemon?limit=20";

        Response response = RestAssured.given().accept("application/json")
                .when().get().then().statusCode(200).extract().response();


        Map<String, Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        //System.out.println(parsedResponse);

        List<Map<String, Object>> list = (List<Map<String, Object>>) parsedResponse.get("results");

        //System.out.println(list);
        String urlForBulbasaur = "";

        for (int i = 0; i < list.size(); i++) {

            Map<String, Object> map = list.get(i);

            if (map.get("name").equals("bulbasaur")){
                urlForBulbasaur += map.get("url");
               // System.out.println("map.get(\"url\") = " + map.get("url"));
            }

        }

        response = RestAssured.given().accept("application/json").when().get(urlForBulbasaur).then().extract().response();
        Map<String, Object> parsedBul = response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String, Map<String, Object>>> abilities = (List<Map<String, Map<String, Object>>>) parsedBul.get("abilities");

       // System.out.println(abilities);

        Map<String, Map<String, Object>> overgrow = new HashMap<>();

        for (int i = 0; i < abilities.size(); i++) {

            Map<String, Map<String, Object>> map = abilities.get(i);

           // System.out.println(map);

            System.out.println(map.get("ability"));


        }




    }

}
