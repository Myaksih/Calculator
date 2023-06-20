import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws RomanianNumberExeption, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String example = bufferedReader.readLine();
        System.out.println(calc(example));
    }
    public static String calc(String input) throws RomanianNumberExeption {
        String[] splittedDigits = input.split(" ");           //Ввод строки



        int countMathOperations = 0;

        for (int i = 0; i < splittedDigits.length; i++) {           // проверка чтобы было всего 2 слагаемых
            if(splittedDigits[i].equals("+") || splittedDigits[i].equals("-") || splittedDigits[i].equals("/") || splittedDigits[i].equals("*")){
                countMathOperations++;
            }
            if(countMathOperations>1){
                throw new RomanianNumberExeption();
            }
        }
        try {
            Integer.parseInt(splittedDigits[2]);
            Integer.parseInt(splittedDigits[0]);
            return arabicDigit(splittedDigits);            // отделение методов арабских от римских
        }
        catch (Exception e){

            return romanianNumbers(splittedDigits);
        }
    }

    public static String arabicDigit(String[] arrayNumbers) throws RomanianNumberExeption {
        int first = Integer.parseInt(arrayNumbers[0]);
        int second = Integer.parseInt(arrayNumbers[2]);
        if(first>10 || first<1){
            throw new RomanianNumberExeption();
        }
        if(second>10 || second<1){
            throw new RomanianNumberExeption();
        }

        switch (arrayNumbers[1]){
            case "+":
                return String.valueOf(first+second);

            case "-":
                return String.valueOf(first-second);

            case "*":
                return String.valueOf(first*second);

            case  "/":
                return String.valueOf(first/second);

        }
        return "";
    }

    public static String romanianNumbers(String[] arrayNumbers) throws RomanianNumberExeption {

        String[] digits = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String[] romanianNumbers= new String[] { "I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII",
        "XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII",
        "XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII",
        "XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII",
        "LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII",
        "LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV",
        "LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

        int first = 0;
        int second = 0;
        int answer = 0;

        for (int i = 0; i < 10; i++) {                      // проверка что оба слагаемые римские
            boolean isRomanian = true;
           if(arrayNumbers[0].equals(digits[i]) || arrayNumbers[2].equals(digits[i])){
               throw new RomanianNumberExeption();
           }
        }

        for (int i = 0; i < 10; i++) {
            if(arrayNumbers[0].equals(romanianNumbers[i])){
                first = i+1;
            }
            if(arrayNumbers[2].equals(romanianNumbers[i])){
                second = i+1;
            }
        }

        switch (arrayNumbers[1]){
            case "+":
                answer = first+second;
                break;
            case "-":
                answer = first-second;
                break;
            case "*":
                answer = first*second;
                break;
            case  "/":
                answer = first/second;
                break;
        }
        if (answer-1<0){                                    // проверка чтобы ответ был больше 0
            throw new RomanianNumberExeption();
        }
        else{
            return romanianNumbers[answer-1];
        }
    }
}

class   RomanianNumberExeption extends Exception{
    public RomanianNumberExeption(){
        System.out.println("Проверьте правильность ввода данных");
    }
}

