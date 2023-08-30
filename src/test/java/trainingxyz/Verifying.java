package trainingxyz;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Examples {
    @Test
    public void verifyingComplexResponseBodiesWithHamcrestMatchers() {
        String endpoint = "http://localhost:8888/api_testing/product/read.php";

                given().
                when().
                        get(endpoint).
                then().
                        log().body().  //.log().body();
                        assertThat().
                        statusCode(200).
                        body("records.size()",greaterThan(0)).
                        body("records.id",everyItem(notNullValue())).
                        body("records.name",everyItem(notNullValue())).
                        body("records.description",everyItem(notNullValue())).
                        body("records.price",everyItem(notNullValue())).
                        body("records.category_id",everyItem(notNullValue())).
                        body("records.category_name",everyItem(notNullValue())).
                        body("records.id[0]",equalTo(19));


    }
}
