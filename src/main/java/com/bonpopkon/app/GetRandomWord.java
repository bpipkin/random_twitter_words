package com.bonpopkon.app;

import java.net.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class GetRandomWord {
	
	private RandomWordResponse response;
	private int index;

	public GetRandomWord() {
		response = new RandomWordResponse();
		response.addWord("Hello");
		response.addWord("World");
		index = 0;
	}

	public String getNextWord() {
		final String retVal = response.getWords().get(index);
		index = (index + 1) % response.getWords().size();
		return retVal;
	}
	
	public List<String> callRandomWordApi(final int amount) throws IOException {
		// Create a neat value object to hold the URL
		URL url = new URL("https://random-word-api.herokuapp.com/word?number=" + amount);

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream responseStream = connection.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();
		List<String> responseList = mapper.readValue(responseStream, new TypeReference<List<String>>(){});
		// RandomWordResponse response = mapper.readValue(responseStream, RandomWordResponse.class);

		// Finally we have the response
		System.out.println("Amount of words: " + responseList.size());
		
		for (int i = 0; i < responseList.size(); i++) {
			System.out.println("word[" + i + "] = " + responseList.get(i));
		}
		
		return responseList;
	}

}
