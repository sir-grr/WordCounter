import java.util.HashMap;

public class wordCounter {
    private HashMap<String, Integer> wordHolder;

    //here we have our constructors

    public wordCounter(){//create a new hashmap
        wordHolder = new HashMap<String, Integer>();
    }

    public wordCounter(String[] words){//create a new hashmap and add the passed in words to it
        wordHolder = new HashMap<String, Integer>();
        addWords(words);
    }

    //here we have main functionality 

    public void addWord(String word){//translate a given word to english and then add it to the word counter
        if(isValid(word)){//check it's a valid word with only alphabetic characters
            String englishWord = translator.translateString(word);//translate it to english
            if(wordHolder.containsKey(englishWord)){//if its already in wordholder
                wordHolder.replace(englishWord,wordHolder.get(englishWord) + 1);//increment it's count by 1
            } else{
                wordHolder.put(englishWord, 1);//else add it to the word holder
            }
        } else{
            throw new java.lang.RuntimeException("Error In addWord, " + word + " is not a valid input");
        }
    }

    public void addWords(String[] words){//pass an array of words to addWord
        for(String word : words){
            addWord(word);
        }
    }

    public int countOf(String word){//return the count of a given word
        if (wordHolder.containsKey(word)){
            return wordHolder.get(word);
        }
        return 0;
    }

    //and here we have utility methods

    private boolean isValid(String word){
        //the regex here looks for any characters that aren't alphabetic
        //then we have a chack that the string contins characters
        boolean isValid = (!word.matches("^.*[^a-zA-Z].*$")) && (word.length()>0) ;
        
        return isValid;
    }
    
}