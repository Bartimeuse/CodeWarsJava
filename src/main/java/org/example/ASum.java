package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class ASum {
    public static long findNb(long m) {
        long n = 0;
        while (m > 0) m -= ++n*n*n;
        return m == 0? n: -1;
        }
    public static boolean validatePin(String pin) {
        var arr = pin.toCharArray();
        var counterDigits = 0;
        if (arr.length == 4 || arr.length == 6)
            for (char c : arr)
                if ('\u0030' <= c && c <= '\u0039')
                    counterDigits++;
        return counterDigits == 4 || counterDigits == 6;
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        if (p0<p) return 0;
        else return nbYear((int)(percent*p0/100 + aug), percent, aug, p ) +1;
        //        int counter = 0;
//        for (; p0 <= p; counter++)
//            p0 += percent*p0/100 + aug;
//        return counter;
    }

    public static String accum(String s) {
        var arr = s.toCharArray();
        var dArr = new ArrayList<StringBuilder >();
        for (int i =0; i < arr.length; i++)
            dArr.add((((new StringBuilder())
                    .append(Character.toUpperCase(arr[i] )))
                    .append(String.valueOf(Character.toLowerCase(arr[i])).repeat(i))
                    .append('-')));
        return String.join((""), dArr).replaceAll(".$", "");


// import java.util.stream.IntStream;
//       var chars = s.split("");
//
//        return IntStream.range(0, chars.length)
//                .mapToObj(i -> chars[i].toUpperCase() + chars[i].toLowerCase().repeat(i))
//                .collect(Collectors.joining("-"));
        }
    public static String reverseWords(final String original)
    {
        var arr = original.split(" ");
        if(arr.length == 0)
            return original;
        StringBuilder dArr = new StringBuilder();
        for (String k : arr) {
          dArr.append(new StringBuilder(k).reverse());
          dArr.append(" ");
        }
        return dArr.toString().replaceAll(".$", "");
    }

    private static TreeMap<Integer, String> MAP;
    static {
        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
        MAP.put( 1, "I" );
        MAP.put( 4, "IV" );
        MAP.put( 5, "V" );
        MAP.put( 9, "IX" );
        MAP.put( 10, "X" );
        MAP.put( 40, "XL" );
        MAP.put( 50, "L" );
        MAP.put( 90, "XC" );
        MAP.put( 100, "C" );
        MAP.put( 400, "CD" );
        MAP.put( 500, "D" );
        MAP.put( 900, "CM" );
        MAP.put( 1000, "M" );
    }

    public String solution(int n) {
        return "I".repeat(n)
                .replace("IIIII", "V").replace("IIII", "IV")
                .replace("VV", "X").replace("VIV", "IX")
                .replace("XXXXX", "L").replace("XXXX", "XL")
                .replace("LL", "C").replace("LXL", "XC")
                .replace("CCCCC", "D").replace("CCCC", "CD")
                .replace("DD", "M").replace("DCD", "CM");
        //        StringBuilder builder = new StringBuilder();
//        for(Map.Entry<Integer, String> entry: MAP.entrySet() ){
//            int i = entry.getKey();
//            String s = entry.getValue();
//            while( n>=i ){
//                builder.append(s);
//                n -= i;
//            }
//        }
//        return builder.toString();
    }
}
