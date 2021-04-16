package tcpservertranslator;

public class ServerTranslationModel {
	protected static String[] malay = {"Selamat pagi","Selamat malam","Apa khabar?","Terima kasih","Selamat tinggal","Ada apa?"};
	protected static String[] arabic = {"صباح الخير", "طاب مساؤك", "كيف حالك؟", "شكرا لك", "مع السلامة", "ما أخبارك؟"};
	protected static String[] korean = {"좋은 아침", "안녕히 주무세요", "어떻게 지내세요?", "감사합니다", "안녕", "뭐야?"};
	protected static String[] english = {"Good morning", "Good night", "How are you?", "Thank you", "Goodbye", "What’s up?"};
	
	public String translate(String clientEng, int transTo) {
		String translated = "Sorry, translation failed.";
		int pos = -1;
		
		for(int i = 0; i<english.length; i++) {
			if (clientEng.contains(english[i])) {
				pos=i;
			}
		}
		
		if (transTo == 0) {
			translated = malay[pos];
		} else if (transTo == 1) {
			translated = arabic[pos];
		} else if (transTo == 2) {
			translated = korean[pos];
		} 
		return translated;
	}
	
}
