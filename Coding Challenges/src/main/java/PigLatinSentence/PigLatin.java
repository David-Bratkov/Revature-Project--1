package PigLatinSentence;

public class PigLatin {

    public String encrypt(String sentence){
        //validate sentence for illegal characters
        if(!isSentenceValid(sentence)){
            return "Invalid sentence.";
        }

        //variable for pigLatin
        StringBuilder pigLatinSentence = new StringBuilder("");

        //tokenize string to an array of words
        String[] words = sentence.split(" ");



        //pigLatin log for each word and append that to the pigLatinVariable
        for(String word : words){
            pigLatinSentence
                    .append(word.substring(1))
                    .append(word.charAt(0))
                    .append("ay ");
        }


        return pigLatinSentence.deleteCharAt(pigLatinSentence.length() - 1).toString();
    }

    public boolean isSentenceValid(String sentence) {
        String[] words = sentence.split(" ");

        for(String word : words){
            if(!isWordValid(word))
                return false;
        }

        return true;
    }

    public boolean isWordValid(String word) {

        //the word is valid until proven guilty
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) < 'A')
                return false;

            if(word.charAt(i) > 'Z' && word.charAt(i) < 'a')
                return false;

            if(word.charAt(i) > 'z')
                return false;
        }

        return true;
    }

    public String decrypt(String pigLatinSentence){
        //make sure sentence is valid
        if(!isSentenceValid(pigLatinSentence))
            return "Invalid sentence.";

        //variable for sentence
        StringBuilder sentence = new StringBuilder("");

        //tokenize
        String[] words = pigLatinSentence.split(" ");

        for(String word : words){
            sentence
                    .append(word.charAt(word.length() - 3))
                    .append(word, 0, word.length() - 3)
                    .append(" ");
        }

        return sentence.deleteCharAt(sentence.length() - 1).toString();
    }
}