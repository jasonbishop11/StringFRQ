
package com.company;

public class Sentence {

	private String currSent;

	/** Constructs a new Sentence object. */
	public Sentence(String p) {
		currSent = p;
	}

	/** Returns a string containing the current sentence. */
	public String toString() {
		return currSent;
	}
	


	/** Returns the index of the nth occurrence of str in the current sencence;
	 * returns -1 of the nth occurrence does not exist.
	 * Precondition:  str.length() > 0 and n > 0
	 * Postcondition: the current sentence if not modified.
	 */
	public int findNthTime(String str, int n) {
		if(currSent.contains(str)) {
			String modWord = currSent;
			int start = 0;
			for (int i = 0; i < n; i++) {
				start = modWord.indexOf(str);
				if (start != -1) {
					modWord = modWord.substring(start+str.length());
				} else{return -1;}
			}
			if (modWord != currSent){
				return currSent.indexOf(str+modWord);
			}else{
				return 0;
			}
		}else {
			return -1;
		}
	}

	/** Modifies the current sentence by replacing the nth occurrence of str with repl
	 * If the nth occurrence does not exist, the current sentence is unchanged.
	 * Precondition: str.length() > 0 and n > 0
	 *
	 */
	public void replaceNthTime(String str, int n, String repl) {
		int location = findNthTime(str, n);
		String frontWord = "";
		String backWord = "";
		if (location != -1) {
			if (location!=0) {
				frontWord = currSent.substring(0, location);
				backWord = currSent.substring(location+str.length());
			}else{
				frontWord = currSent.substring(0,location);
				backWord = currSent.substring(location+str.length());
			}
			currSent = frontWord + repl + backWord;
		}
	}

	/** Returns the index of the last occurrence of str in the current sentence:
	 * returns -1 if str is not found.
	 * Precondition:  str.length() > 0
	 * Postcondition: the current sentence is not modified.
	 */
	public int findLastTime(String str) {
		String revSentence = "";
		String revStr = "";
		for(int i=currSent.length()-1; i>=0; i--){
			revSentence += currSent.charAt(i);
		}
		for(int i=str.length()-1; i>=0; i--){
			revStr += str.charAt(i);
		}
		Sentence finalSentence = new Sentence(revSentence);
		int location = finalSentence.findNthTime(revStr, 1);
		int answer = currSent.length()-location;
		if (location==-1){
			return -1;
		}
		return answer-str.length();
	}

	public static void main(String[] args) {
		Sentence sentence1 = new Sentence("A cat ate late.");
		System.out.println(sentence1.findNthTime("at",1));
		sentence1.replaceNthTime("at", 1, "rane");
		System.out.println(sentence1);

		Sentence sentence2 = new Sentence("A cat ate late.");
		System.out.println(sentence2.findNthTime("at",6));
		sentence2.replaceNthTime("at", 6, "xx");
		System.out.println(sentence2);

		Sentence sentence7 = new Sentence("A cat ate late.");
		System.out.println(sentence7.findNthTime("at",3));
		sentence7.replaceNthTime("at", 3, "xx");
		System.out.println(sentence7);

		Sentence sentence3 = new Sentence("A cat ate late.");
		System.out.println(sentence3.findNthTime("bat",2));
		sentence3.replaceNthTime("bat", 2, "xx");
		System.out.println(sentence3);

		Sentence sentence4 = new Sentence("aaaa");
		System.out.println(sentence4.findNthTime("aa",1));
		sentence4.replaceNthTime("aa", 1, "xx");
		System.out.println(sentence4);

		Sentence sentence5 = new Sentence("aaaa");
		System.out.println(sentence5.findNthTime("aa",2));
		sentence5.replaceNthTime("aa", 2, "bbb");
		System.out.println(sentence5);

		Sentence sentence6 = new Sentence("A cat ate late.");
		System.out.println(sentence6.findLastTime("at"));
		System.out.println(sentence6.findLastTime("cat"));
		System.out.println(sentence6.findLastTime("bat"));
	}

}
/*
Output
3
A crane ate late.
-1
A cat ate late.
11
A cat ate lxxe.
-1
A cat ate late.
0
xxaa
0
bbbaa
11
2
-1
 */