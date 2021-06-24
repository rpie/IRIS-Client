package zeroday;

public class DisClient {
	
	private static final DisClient INSTANCE = new DisClient();
	
	public static final DisClient getInstance() { 
		return INSTANCE;
	}
	
	private DiscordRP discordRP = new DiscordRP();
	
	public void init() {
		discordRP.start();
	}
	
	public void shutdown() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
}
