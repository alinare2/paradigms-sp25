public class Homework8{
    public boolean check(char[] correctPositions, String word) {
        /* your solution goes here */
        for (int i = 0; i < word.length(); i++) {
            char wordC = word.charAt(i);
            if (i < correctPositions.length){
                if (wordC != correctPositions[i] && correctPositions[i] != '*'){
                    return false;
                }
            }
        }

        return true;
    }

    //checking
    public static void main(String[] args) {
        char[] correctPositions = new char[]{ 'W', '*' };
        String word = "wordle";

        Homework8 sol = new Homework8();
        System.out.println(sol.check(correctPositions, word));
    }
}
