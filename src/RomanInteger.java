public class RomanInteger {

    private final String roman;
    private final int number;

    public RomanInteger(String roman) throws NotRomanException {
        this.number = RomanInteger.romanStrToInt(roman);
        this.roman = roman;

    }

    public RomanInteger(int number) {
        this.number = number;
        this.roman = RomanInteger.IntToRomanStr(number);
    }

    public String toString() {
        return roman;
    }

    public int toInt() {
        return number;
    }


    public RomanInteger add(RomanInteger another) {
        return new RomanInteger(this.toInt() + another.toInt());
    }

    public RomanInteger minus(RomanInteger another) {
        return new RomanInteger(this.toInt() - another.toInt());
    }

    public RomanInteger times(RomanInteger another) {
        return new RomanInteger(this.toInt() * another.toInt());
    }

    public RomanInteger div(RomanInteger another) {
        return new RomanInteger((int) this.toInt() / another.toInt());
    }


    public static int romanStrToInt(String roman) throws NotRomanException {
        if (RomanInteger.isRoman(roman)) {
            int result = 0;
            char[] romans = roman.toCharArray();

            for (int i = 0; i < romans.length; i++) {
                int s1 = value(romans[i]);

                if (i + 1 < romans.length) {
                    int s2 = value(romans[i + 1]);

                    if (s1 >= s2) {
                        result = result + s1;
                    }
                    else {
                        result = result + s2 - s1;
                        i++;
                    }
                }
                else {
                    result = result + s1;
                }
            }
            return result;
        } else {
            throw new NotRomanException("Provided strings is not roman numerals");
        }

    }

    public static String IntToRomanStr(int number) {
        if (number < 1 || number > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (number >= 100) {
            s += "C";
            number -= 100;
        }
        while (number >= 90) {
            s += "XC";
            number -= 90;
        }
        while (number >= 50) {
            s += "L";
            number -= 50;
        }
        while (number >= 40) {
            s += "XL";
            number -= 40;
        }
        while (number >= 10) {
            s += "X";
            number -= 10;
        }
        while (number >= 9) {
            s += "IX";
            number -= 9;
        }
        while (number >= 5) {
            s += "V";
            number -= 5;
        }
        while (number >= 4) {
            s += "IV";
            number -= 4;
        }
        while (number >= 1) {
            s += "I";
            number -= 1;
        }
        return s;
    }

    public static boolean isRoman(String susp) {
        for (char c : susp.toCharArray()) {
            if ("IVXLC".contains(Character.toString(c))) continue;
            else
                return false;
        }
        return true;
    }

    private static int value(char r) {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
        }
        return 0;
    }

}
