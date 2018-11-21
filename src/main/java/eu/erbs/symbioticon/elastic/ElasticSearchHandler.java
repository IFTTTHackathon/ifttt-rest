package eu.erbs.symbioticon.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;

import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchHandler {
	
	private final static String INDEX_NAME = "handelsblatt";
	private TransportClient client;
	private IndexRequestBuilder indexRequestBuilder;
	
	public static void main(String[] args) throws UnknownHostException, JSONException {
		JSONObject news = new JSONObject("{\"descrription\":\"eine kurze Beschreibung\"}");
		ElasticSearchHandler handler = new ElasticSearchHandler();
		handler.insertNews(news);
		
	}
	
	public ElasticSearchHandler() throws UnknownHostException {
		Settings settings = Settings.builder()
				.put("cluster.name", "elasticsearch")
				//.put("client.transport.sniff", true)
				.build();

		
		client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));


		indexRequestBuilder = client.prepareIndex(INDEX_NAME, "doc");
		
	}

	public void insertNews(JSONObject news) throws UnknownHostException {

		IndexRequestBuilder indexRequestBuilder = client.prepareIndex(INDEX_NAME, "ßdoc");
		//			logger.info("Add " + transaction);
		indexRequestBuilder
		.setSource(news.toString(), XContentType.JSON)
		.get();

		// on shutdown

		client.close();
	}

}
