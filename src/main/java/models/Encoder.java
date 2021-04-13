package models;

public class Encoder {
    private String inputSentence;
    private int key;

    public  Encoder(String inputSentence, int key){
        this.inputSentence = inputSentence;
        this.key = key;
    }

    public String getInputSentence() {
        return inputSentence;
    }

    public int getKey() {

        return key;
    }

    public String encode(String inputSentence, int key){
        StringBuilder encodedStringBuilder = new StringBuilder();
        for (int position = 0; position<inputSentence.length(); position++) {
            if(Character.isSpaceChar(inputSentence.charAt(position))){
                char characterPosition = (char) ((int)inputSentence.charAt(position));
                encodedStringBuilder.append(characterPosition);
            }else if(Character.isUpperCase(inputSentence.charAt(position))) {
                char characterPosition = (char) (((int)inputSentence.charAt(position)+key-65)%26 +65);
                encodedStringBuilder.append(characterPosition);
            }else{
                char characterPosition = (char) (((int)inputSentence.charAt(position)+key-97)%26 +97);
                encodedStringBuilder.append(characterPosition);
            }
        }

        return encodedStringBuilder.toString();
    }

}
