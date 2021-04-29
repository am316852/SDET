package server;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;




public class ApiStepDefination {

	private static Response res;
	private static RequestSpecification request;
	
	@Given("I have the the POST request body with {string} and {string} and {string}")
	public void i_have_the_the_post_request_body_with_and_and(String name, String email, String address) {
	   
		
		JSONObject req= new JSONObject();
		req.put("name", name);
		req.put("email", email);
		req.put("address", address);
			

		request=   RestAssured.given();
		request.header("Content-Type","application/json").
		  body(req.toJSONString());
	}

	@When("I the the URL {string}")
	public void i_the_the_url(String string) {
	  res= request.
			    post("http://localhost:8080/eligibility/check");
	}

	@Then("I should get response code as {string}")
	public void i_should_get_response_code_as(String code) {
	   
	int statusCode= res.getStatusCode();
	int actual=Integer.valueOf(code);
	Assert.assertEquals(actual, statusCode);
	
	}
	
	@Then("I should get card details in result")
	public void i_should_get_card_details_in_result() {
		JsonPath jsonPathEvaluator = res.jsonPath();
		
		ArrayList<String> list=jsonPathEvaluator.get("eligibleCards");
		
		Assert.assertTrue(list.size()!=0);

	}
	
	@Then("I should get no cards for customer")
	public void i_should_get_no_cards_for_customer() {
        JsonPath jsonPathEvaluator = res.jsonPath();
		
		ArrayList<String> list=jsonPathEvaluator.get("eligibleCards");
		
		Assert.assertTrue(list.size()==0);
	}

}
