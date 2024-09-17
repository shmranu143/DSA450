import com.sun.deploy.util.StringUtils;
import javafx.util.converter.LocalDateStringConverter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
            String[] leaves = {"2024-01-01", "2024-01-02", "2024-01-03", "2024-01-04", "2024-01-05", "2024-01-06", "2024-01-07", "2024-01-08", "2024-01-09", "2024-01-10", "2024-01-11", "2024-01-15", "2024-01-16", "2024-01-18", "2024-01-19", "2024-01-20", "2024-01-21", "2024-01-22", "2024-01-23", "2024-01-24", "2024-01-25", "2024-01-26", "2024-01-27", "2024-01-28", "2024-01-30", "2024-01-31"};

//            String[] leavesDuringFirstQuiz = getLeavesDuringFirstQuiz(leaves);
//            String[] leavesDuringSecondQuiz = getLeavesDuringSecondQuiz(leaves);
//            System.out.println(leaves.length);
//            System.out.println("Leaves during first quiz:");
//            System.out.println(leavesDuringFirstQuiz.length);
//            for (String leave : leavesDuringFirstQuiz) {
//                System.out.print(leave+",");
//            }
//
//            System.out.println("\nLeaves during second quiz:");
//            System.out.println(leavesDuringSecondQuiz.length);
//            for (String leave : leavesDuringSecondQuiz) {
//                System.out.print(leave+",");
//            }
            LocalDate date = LocalDate.now();
            int numberOfDay = date.lengthOfMonth();
            int diff = numberOfDay-15;


        }

        public  String[] getLeavesDuringFirstQuiz(String[] leaves) {
            List<String> leavesDuringFirstQuiz = new ArrayList<>();
            for (String leave : leaves) {
                int day = Integer.parseInt(leave.split("-")[2]);
                if (day >= 1 && day <= 15) {
                    leavesDuringFirstQuiz.add(leave);
                }
            }
            return leavesDuringFirstQuiz.toArray(new String[0]);
        }

        public  String[] getLeavesDuringSecondQuiz(String[] leaves) {
            List<String> leavesDuringSecondQuiz = new ArrayList<>();
            for (String leave : leaves) {
                int day = Integer.parseInt(leave.split("-")[2]);
                if (day >= 16) {
                    leavesDuringSecondQuiz.add(leave);
                }
            }
            return leavesDuringSecondQuiz.toArray(new String[0]);
        }



//    public static void main(String[] args) {
//
//
//
////            if ( true &&
////                    (true&&true) &&
////                    (false||true) &&
////                    (false||true)){
////                System.out.println("true");
////            }
////            else System.out.println(false);
//
//
////            System.out.println(monthName != null ? monthName : "Invalid month abbreviation");
////            DateTimeFormatter monthFormatter = new DateTimeFormatterBuilder()
////                    .parseCaseInsensitive()
////                    .appendPattern("MMM")
////                    .toFormatter(Locale.ENGLISH);
////
////            Month month = Month.from(monthFormatter.parse("MAR"));
////            System.out.println(month);
////            String time = "05:30";
////            LocalDate date = LocalDate.now();
////            DateTimeFormatter converter = new DateTimeFormatterBuilder()
////                    .appendPattern("dd-MMM-yyyy").toFormatter();
////            String datetime = converter.format(date);
////            datetime += (" "+time);
////            System.out.println(datetime);
//
////            System.out.println(getAtachmentForToday("LAED_DXB_SG_SIR_"));
////            LocalTime time1 = LocalTime.now();
////            LocalTime nightTime = LocalTime.of(21,04);
////            LocalTime eod = LocalTime.of(23,59);
////            if (time1.compareTo(nightTime)<0)
////                System.out.println("localTime: "+time1);
////            validatedateFormate("2023-06-01");
////            Map<Boolean,String> map = utcToist("2300");
////            System.out.println(map);
////            System.out.println(LocalDateTime.now());
////            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
////            System.out.println(formatter.format(LocalDate.now()));
//
////            LocalDate date = LocalDate.now();
////            System.out.println(LocalDate.now());
////            String strDate = LocalDate.now().toString();
////            System.out.println(LocalDate.parse(strDate).format(DateTimeFormatter.ofPattern("yyyy-MMM-dd")));
////            String str = "Hi this is shubham jaiswal sending attachment";
////            byte[] ar = str.getBytes();
////            System.out.println(ar.toString());
////            DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
////            Calendar cal = Calendar.getInstance();
////            cal.add(Calendar.DAY_OF_MONTH, 5);
////            String date = formatter.format(cal.getTime());
////            date += " 23:59";
////            System.out.println(date);
//
//    }
    public int lengthOfLastWord(String s) {
        String [] trimmed = s.trim().split(" ");
        return trimmed[trimmed.length-1].length();

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i=0;i<m;i++){
//            nums1[n+i]=nums1[i];
//        }
        int l=m;
        for (int i = m + n - 1; i > n - 1; i--) {
            nums1[i] = nums1[--l];
        }
        for(int i=0;i<m+n;i++){
            System.out.print(nums1[i]+" ");
        }
        int j=n;int k=0;
        if(n==0) return;
        if(m==0){
            for(int i=0;i<n;i++) nums1[i]=nums2[i];
            return;
        }
        for (int i=0;i<m+n;i++){
            if (j>=m+n ){
                nums1[i]=nums2[k];
                k++;
            } else if(k>=n){
                nums1[i]=nums1[j];
                j++;
            }
            else if(nums1[j]<=nums2[k]){
                nums1[i]=nums1[j];
                j++;
            } else if (nums1[j]>nums2[k]){
                nums1[i]=nums2[k];
                k++;
            }
        }
    }
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m + n - 1; i > n - 1; i--) {
//            nums1[i] = nums1[--m];
////        }
////        for (int i=0;i<m;i++){
////            nums1[n+i]=nums1[i];
////        }
//            for (int i = 0; i < m + n; i++) System.out.print(nums1[i] + " ");
//            int j = n;
//            int k = 0;
//            if (n == 0) return;
//            if (m == 0) {
//                for (int i = 0; i < n; i++) nums1[i] = nums2[i];
//                return;
//            }
//            for (int i = 0; i < m + n; i++) {
//                if (j >= m + n) {
//                    nums1[i] = nums2[k];
//                    k++;
//                } else if (k >= n) {
//                    nums1[i] = nums1[j];
//                    j++;
//                } else if (nums1[j] <= nums2[k]) {
//                    nums1[i] = nums1[j];
//                    j++;
//                } else if (nums1[j] > nums2[k]) {
//                    nums1[i] = nums2[k];
//                    k++;
//                }
//            }
//        }
//    }

//    public int removeDuplicates(int[] nums) {
//        int newSize=0;
//        int ptr = 1;
//        for (int i=1;i<nums.length;i++){
//            if (nums[i]>nums[ptr] && nums[i]>nums[i-1]){
//                nums[ptr]=nums[i];
//                ptr++;
//            }
//        }
//        return ptr;
//    }

//    public int removeElement(int[] nums, int val) {
//        int last = nums.length-1;
//        int count = 0;
//        for (int i =0;i<nums.length;i++){
//            if (nums[i]!=val) count++;
//        }
//        //[0,1,2,2,3,0,4,2], val = 2
//        for (int i =0;i<count;i++){
//            if (nums[i]==val && nums[last]!=val) {
//                int temp = nums[i];
//                nums[i]=nums[last];
//                nums[last]=temp;
//            }
//            else if(nums[i]==val && nums[last]==val){
//                while (nums[last]==val && last>0) last--;
//                int temp = nums[i];
//                nums[i]=nums[last];
//                nums[last]=temp;
//            }
//        }
//        return count;
//    }

//    private void swap(int num, int num1) {
//        int temp = num;
//        num=num1;
//        num1=temp;
//    }

//    private static String[] getTrimedMailIds(String[] mailIds) {
////        log.info("in getTrimedMailIds , mailIds:"+mailIds);
//        if (mailIds==null) return new String[0];
//        List<String> trimedMails = new ArrayList<>();
//        try {
//            for (int i=0;i<mailIds.length;i++){
//                if (mailIds[i]!=null)
//                trimedMails.add(mailIds[i].trim());
//            }
//        } catch (Exception e){
////            log.error("exception in getTrimedMailIds");
//        }
//        return trimedMails.toArray(new String[0]);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    static int countMin(String str)
//    {
//        // code here
//        Stack<Character> stack = new Stack<>();
//        int maxPal = 0;
//        int largestpal = 0;
//        char removedChar='*';
//        for (int i=0;i<str.length();i++){
//            if (stack.isEmpty()){
//                stack.push(str.charAt(i));
//                continue;
//            }
//            if (str.charAt(i)==stack.peek()){
//                maxPal+=2;
//                removedChar = stack.pop();
//            }
//            if (str.charAt(i)!=stack.peek()&& str.charAt(i)==removedChar){
//                maxPal+=1;
//            }
//            if (str.charAt(i)!=stack.peek() && str.charAt(i)!=removedChar){
//                stack.push(str.charAt(i));
//                if (largestpal<maxPal) largestpal=maxPal;
//                maxPal=0;
//                removedChar='*';
//            }
//        }
//        return str.length()-largestpal;
//    }
//    public static String getAtachmentForToday(String prefix){
//        String date[] = LocalDate.now().toString().split("-");
//        return prefix+date[0]+date[1]+date[2]+".TXT";
//    }
//
//    public static void validatedateFormate(String date){
//            LocalDate localDateStr = LocalDate.parse(date);
//            LocalDate localDate = LocalDate.of(2023,06,1);
//            if (localDateStr.compareTo(localDate)==0)
//            {
//                System.out.println(localDate);
//            }
//    }
//
//    public static Map<Boolean,String> utcToist(String time){
//            Map<Boolean,String> result = new HashMap<>();
//        int hourUtc = Integer.parseInt(time.substring(0,2));
//        int minuteUtc = Integer.parseInt(time.substring(2));
//        if (hourUtc>23 || minuteUtc>59){
//            return null;
//        }
//        int minuteToAdd = 30;
//        int hourToAdd = 05;
//        int carry = 0;
//        boolean flag=false;
//        String istTime="";
//        int totalMinute = minuteToAdd+minuteUtc;
//        if (totalMinute>59 && totalMinute<90){
//            totalMinute-=60;
//            carry++;
//        }
//        int totalHour = hourUtc+hourToAdd+carry;
//        if (totalHour>23){
//            totalHour-=24;
//            flag=true;
////            result.put(true,"0"+totalHour+""+totalMinute);
////            return result;
//        }
//
//        if (totalHour<10){
//            istTime=totalMinute<10?"0"+totalHour+"0"+totalMinute:"0"+totalHour+""+totalMinute;
//        } else {
//            istTime=totalMinute<10?totalHour+"0"+totalMinute:totalHour+""+totalMinute;
//        }
//        result.put(flag,istTime);
//        return result;
//    }
}


// changes .java file to .class file
// check error
