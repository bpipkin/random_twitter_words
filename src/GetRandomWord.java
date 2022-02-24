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

}
