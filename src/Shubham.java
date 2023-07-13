import javafx.util.converter.LocalDateStringConverter;

import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Shubham {
        public static void main(String[] args) {

            if ( true &&
                    (true&&true) &&
                    (false||true) &&
                    (false||true)){
                System.out.println("true");
            }
            else System.out.println(false);


//            System.out.println(monthName != null ? monthName : "Invalid month abbreviation");
//            DateTimeFormatter monthFormatter = new DateTimeFormatterBuilder()
//                    .parseCaseInsensitive()
//                    .appendPattern("MMM")
//                    .toFormatter(Locale.ENGLISH);
//
//            Month month = Month.from(monthFormatter.parse("MAR"));
//            System.out.println(month);
//            String time = "05:30";
//            LocalDate date = LocalDate.now();
//            DateTimeFormatter converter = new DateTimeFormatterBuilder()
//                    .appendPattern("dd-MMM-yyyy").toFormatter();
//            String datetime = converter.format(date);
//            datetime += (" "+time);
//            System.out.println(datetime);

//            System.out.println(getAtachmentForToday("LAED_DXB_SG_SIR_"));
//            LocalTime time1 = LocalTime.now();
//            LocalTime nightTime = LocalTime.of(21,04);
//            LocalTime eod = LocalTime.of(23,59);
//            if (time1.compareTo(nightTime)<0)
//                System.out.println("localTime: "+time1);
//            validatedateFormate("2023-06-01");
//            Map<Boolean,String> map = utcToist("2300");
//            System.out.println(map);
//            System.out.println(LocalDateTime.now());
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
//            System.out.println(formatter.format(LocalDate.now()));

//            LocalDate date = LocalDate.now();
//            System.out.println(LocalDate.now());
//            String strDate = LocalDate.now().toString();
//            System.out.println(LocalDate.parse(strDate).format(DateTimeFormatter.ofPattern("yyyy-MMM-dd")));
//            String str = "Hi this is shubham jaiswal sending attachment";
//            byte[] ar = str.getBytes();
//            System.out.println(ar.toString());
//            DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DAY_OF_MONTH, 5);
//            String date = formatter.format(cal.getTime());
//            date += " 23:59";
//            System.out.println(date);

        }
    static int countMin(String str)
    {
        // code here
        Stack<Character> stack = new Stack<>();
        int maxPal = 0;
        int largestpal = 0;
        char removedChar='*';
        for (int i=0;i<str.length();i++){
            if (stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i)==stack.peek()){
                maxPal+=2;
                removedChar = stack.pop();
            }
            if (str.charAt(i)!=stack.peek()&& str.charAt(i)==removedChar){
                maxPal+=1;
            }
            if (str.charAt(i)!=stack.peek() && str.charAt(i)!=removedChar){
                stack.push(str.charAt(i));
                if (largestpal<maxPal) largestpal=maxPal;
                maxPal=0;
                removedChar='*';
            }
        }
        return str.length()-largestpal;
    }
    public static String getAtachmentForToday(String prefix){
        String date[] = LocalDate.now().toString().split("-");
        return prefix+date[0]+date[1]+date[2]+".TXT";
    }

    public static void validatedateFormate(String date){
            LocalDate localDateStr = LocalDate.parse(date);
            LocalDate localDate = LocalDate.of(2023,06,1);
            if (localDateStr.compareTo(localDate)==0)
            {
                System.out.println(localDate);
            }
    }

    public static Map<Boolean,String> utcToist(String time){
            Map<Boolean,String> result = new HashMap<>();
        int hourUtc = Integer.parseInt(time.substring(0,2));
        int minuteUtc = Integer.parseInt(time.substring(2));
        if (hourUtc>23 || minuteUtc>59){
            return null;
        }
        int minuteToAdd = 30;
        int hourToAdd = 05;
        int carry = 0;
        boolean flag=false;
        String istTime="";
        int totalMinute = minuteToAdd+minuteUtc;
        if (totalMinute>59 && totalMinute<90){
            totalMinute-=60;
            carry++;
        }
        int totalHour = hourUtc+hourToAdd+carry;
        if (totalHour>23){
            totalHour-=24;
            flag=true;
//            result.put(true,"0"+totalHour+""+totalMinute);
//            return result;
        }

        if (totalHour<10){
            istTime=totalMinute<10?"0"+totalHour+"0"+totalMinute:"0"+totalHour+""+totalMinute;
        } else {
            istTime=totalMinute<10?totalHour+"0"+totalMinute:totalHour+""+totalMinute;
        }
        result.put(flag,istTime);
        return result;
    }
}


// changes .java file to .class file
// check error
