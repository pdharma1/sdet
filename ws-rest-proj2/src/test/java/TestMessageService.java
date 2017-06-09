
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fnmae.beans.Message;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class TestMessageService {

	private String message = "http://localhost:2080/ws-rest-proj2/rest";
	private String delete = "http://localhost:2080/ws-rest-proj2/delete";

	private Message m1, m2;

	@Before
	public void setUp() throws Exception {

		Message m1 = new Message();
		m1.setId(1001);
		m1.setDate("2017-06-08");
		m1.setText("Sample text 1001");
		m1.setAuthor("Author 1001");

		Message m2 = new Message();
		m2.setId(1002);
		m2.setDate("2017-06-07");
		m2.setText("Sample text 1001");
		m2.setAuthor("Author 1002");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveMessage() {
		RestAssured.baseURI = message;
		Response response =
				given().
					.contentType(ContentType.JSON)
					.body(m1)
				when()
					.post("/message")
				.then()
					.body("id",is(m1.getId()))
					.body("author",is(m1.getAuthor()))
					.body("date",is(m1.getDate()))
					.body("text",is(m1.getText()));
	}

}
