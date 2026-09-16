package KeywordDrivenFramework;

import KeywordDriven.KeywordExecutorSauceDemo;


public class KeywordSauceDemo {

	public static void main(String[] args) {
		KeywordExecutorSauceDemo e = new KeywordExecutorSauceDemo();
		e.executor("OPEN_BROWSER");
	    e.executor("OPEN_URL");
	    e.executor("USERNAME");
	    e.executor("PASSWORD");
	    e.executor("LOGIN");
	    e.executor("CLOSE_BROWSER");
	}

}
