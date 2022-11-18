package KataCalculator;

import java.io.IOException;
import java.util.TreeMap;

public class ConvertTo {

    TreeMap<Character, Integer> romMap = new TreeMap<>();
    TreeMap<Integer, String> arabianMap = new TreeMap<>();

    public ConvertTo() {
        romMap.put('I', 1);
        romMap.put('V', 5);
        romMap.put('X', 10);
        romMap.put('L', 50);
        romMap.put('C', 100);


        arabianMap.put(100, "C");
        arabianMap.put(99, "XCIX");
        arabianMap.put(98, "XCVIII");
        arabianMap.put(97, "XCVII");
        arabianMap.put(96, "XCVI");
        arabianMap.put(95, "XCV");
        arabianMap.put(94, "XCIV");
        arabianMap.put(93, "XCIII");
        arabianMap.put(92, "XCII");
        arabianMap.put(91, "XCI");
        arabianMap.put(90, "XC");
        arabianMap.put(89, "LXXXIX");
        arabianMap.put(88, "LXXXVII");
        arabianMap.put(87, "LXXXVII");
        arabianMap.put(86, "LXXXVI");
        arabianMap.put(85, "LXXXV");
        arabianMap.put(84, "LXXXIV");
        arabianMap.put(83, "LXXXII");
        arabianMap.put(82, "LXXXII");
        arabianMap.put(81, "LXXXI");
        arabianMap.put(80, "LXXX");
        arabianMap.put(79, "LXXIX");
        arabianMap.put(78, "LXXVIII");
        arabianMap.put(77, "LXXVII");
        arabianMap.put(76, "LXXVI");
        arabianMap.put(75, "LXXV");
        arabianMap.put(74, "LXXIV");
        arabianMap.put(73, "LXXIII");
        arabianMap.put(72, "LXXII");
        arabianMap.put(71, "LXXI");
        arabianMap.put(70, "LXX");
        arabianMap.put(69, "LXIX");
        arabianMap.put(68, "LXVII");
        arabianMap.put(67, "LXVI");
        arabianMap.put(66, "LXVI");
        arabianMap.put(65, "LXV");
        arabianMap.put(64, "LXIV");
        arabianMap.put(63, "LXIII");
        arabianMap.put(62, "LXII");
        arabianMap.put(61, "LXI");
        arabianMap.put(60, "LX");
        arabianMap.put(59, "LIX");
        arabianMap.put(58, "LVIII");
        arabianMap.put(57, "LVII");
        arabianMap.put(56, "LVI");
        arabianMap.put(55, "LV");
        arabianMap.put(54, "LIV");
        arabianMap.put(53, "LIII");
        arabianMap.put(52, "LII");
        arabianMap.put(51, "LI");
        arabianMap.put(50, "L");
        arabianMap.put(49, "XLIX");
        arabianMap.put(48, "XLVII");
        arabianMap.put(47, "XLVII");
        arabianMap.put(46, "XLVI");
        arabianMap.put(45, "XLV");
        arabianMap.put(44, "XLIV");
        arabianMap.put(43, "XLIII");
        arabianMap.put(42, "XLII");
        arabianMap.put(41, "XLI");
        arabianMap.put(40, "XL");
        arabianMap.put(39, "XXXIX");
        arabianMap.put(38, "XXXVIII");
        arabianMap.put(37, "XXXVII");
        arabianMap.put(36, "XXXVI");
        arabianMap.put(35, "XXXV");
        arabianMap.put(34, "XXXIV");
        arabianMap.put(33, "XXXIII");
        arabianMap.put(32, "XXXII");
        arabianMap.put(31, "XXXI");
        arabianMap.put(30, "XXX");
        arabianMap.put(29, "XXIX");
        arabianMap.put(28, "XXVIII");
        arabianMap.put(27, "XXVII");
        arabianMap.put(26, "XXVI");
        arabianMap.put(25, "XXV");
        arabianMap.put(24, "XXIV");
        arabianMap.put(23, "XXIII");
        arabianMap.put(22, "XXII");
        arabianMap.put(21, "XXI");
        arabianMap.put(20, "XX");
        arabianMap.put(19, "XIX");
        arabianMap.put(18, "XVIII");
        arabianMap.put(17, "XVII");
        arabianMap.put(16, "XVI");
        arabianMap.put(15, "XV");
        arabianMap.put(14, "XIV");
        arabianMap.put(13, "XIII");
        arabianMap.put(12, "XII");
        arabianMap.put(11, "XI");
        arabianMap.put(10, "X");
        arabianMap.put(9, "IX");
        arabianMap.put(8, "VIII");
        arabianMap.put(7, "VII");
        arabianMap.put(6, "VI");
        arabianMap.put(5, "V");
        arabianMap.put(4, "IV");
        arabianMap.put(3, "III");
        arabianMap.put(2, "II");
        arabianMap.put(1, "I");
    }

    public boolean romNum(String numb) {
        return romMap.containsKey(numb.charAt(0));
    }

    public String intToRom(int numb) {
        StringBuilder rom = new StringBuilder();
        int arabian;
        do {
            arabian = arabianMap.floorKey(numb);
            rom.append(arabianMap.get(arabian));
            numb -= arabian;

        } while (numb != 0);
        return rom.toString();
    }

    public int romToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romMap.get(arr[i]);

            if (arabian < romMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
