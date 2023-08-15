package src;

import java.util.*;

public class B13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentTime = sc.nextLine();
        String dropTime = sc.nextLine();

        String[] currentUnit = currentTime.split(":");
        int currentHour = Integer.parseInt(currentUnit[0]);
        int currentMinute = Integer.parseInt(currentUnit[1]);
        int currentSecond = Integer.parseInt(currentUnit[2]);
        
        String[] dropUtil = dropTime.split(":");
        int dropHour = Integer.parseInt(dropUtil[0]);
        int dropMinute = Integer.parseInt(dropUtil[1]);
        int dropSecond = Integer.parseInt(dropUtil[2]);

        int currentSecondAmount
                = currentHour * (60*60) + currentMinute * 60 + currentSecond;
        int dropSecondAmount
                = dropHour * (60*60) + dropMinute * 60 + dropSecond;

        int needSecondAmount = dropSecondAmount - currentSecondAmount;
        if (needSecondAmount <= 0) {  // cf. 출력 조건: needSecondAmount가 0일 때도 포함
            needSecondAmount += 24 * 60 * 60;
        }

        int needHour = needSecondAmount / (60*60);
        int needMinute = (needSecondAmount % (60*60)) / 60;
        int needSecond = needSecondAmount % 60;

//        String answer = String.format("%02d:%02d:%02d", needHour, needMinute, needSecond);
//        System.out.println(answer);
        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);
    }
}
