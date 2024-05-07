import java.util.HashMap;

public class wordCounter {
    private HashMap<String, Integer> wordHolder;

    public wordCounter(){//create a new hashmap
        wordHolder = new HashMap<String, Integer>();
    }

    public wordCounter(String[] words){//create a new hashmap and add the passed in words to it
        wordHolder = new HashMap<String, Integer>();
        addWords(words);
    }

    public void addWord(String word){//translate a given word to english and then add it to the word counter
        String englishWord = translator.translateString("word");
        if(wordHolder.containsKey(englishWord)){
            wordHolder.replace(englishWord,wordHolder.get(englishWord) + 1);
        } else{
            wordHolder.put(englishWord, 0);
        }
    }

    public void addWords(String[] words){//pass an array of words to addWord
        for(String word : words){
            addWord(word);
        }
    }

    public int countOf(String word){//return the count of a given word
        return wordHolder.get(word);
    }
    
}