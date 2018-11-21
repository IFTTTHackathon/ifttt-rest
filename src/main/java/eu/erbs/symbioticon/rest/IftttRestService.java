package eu.erbs.symbioticon.rest;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class for overall protection
 */
@Path("/")
public class IftttRestService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Logger logger = LoggerFactory.getLogger(IftttRestService.class);


	/**
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws org.json.JSONException 
	 * @throws TelegramApiException 
	 * @see HttpServlet#HttpServlet()
	 */
	public IftttRestService() throws IOException, org.json.JSONException, JSONException {
		super();
		logger.info("Initialized RESTful Service");
	}
	
	private String getJson(String text) {
		JSONObject result = null;
		try {
			result = new JSONObject("{\"text\":\""+text+"\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}

	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String style() {
		try {
			return getJson("Let's start");
		} catch (org.json.JSONException e) {
		}
		return getJson("Komische Exception.");
	}

}