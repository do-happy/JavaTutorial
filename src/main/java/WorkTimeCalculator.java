import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkTimeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("请输入开始工作的年份");
//        int startYear = sc.nextInt();
//        System.out.println("请输入开始工作的月份");
//        int startMonth = sc.nextInt();
//        System.out.println("请输入开始工作的日");
//        int startDay = sc.nextInt();
//        System.out.println("请输入开始工作当天的起始时间（24小时制，如0830表示8点30分）");
//        int startTimeInput = sc.nextInt();
//        int startTimeHour = startTimeInput / 100;
//        int startTimeMinute = startTimeInput % 100;
//        LocalTime startTime = LocalTime.of(startTimeHour, startTimeMinute);

//        System.out.println("请输入每次工作的时长（分钟）");
//        int workTime = sc.nextInt();
//        System.out.println("请输入工作的休息间隔（分钟）");
//        int intervalTime = sc.nextInt();


        int startYear = 2025;
        int startMonth = 1;
        int startDay = 1;
        LocalTime startTime = LocalTime.of(4, 0);
        int workTime = 120;
        int intervalTime = 480;

        System.out.println("请输入月份和日期");
        int selectYear = 2025;
        int selectMonth = sc.nextInt();
        int selectDay = sc.nextInt();
        sc.close();

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
        LocalDate selectDate = LocalDate.of(selectYear, selectMonth, selectDay);
        LocalDateTime selectDateTime = LocalDateTime.of(selectDate, LocalTime.MIDNIGHT);

        List<String> workPeriods = calculateWorkPeriods(startDateTime, workTime, intervalTime, selectDateTime);

        for (String period : workPeriods) {
            System.out.println(period);
        }
    }

    public static List<String> calculateWorkPeriods(LocalDateTime startDateTime, int workTimeMinutes, int intervalTimeMinutes, LocalDateTime selectDateTime) {
        List<String> periods = new ArrayList<>();
        LocalDateTime currentTime = startDateTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (!currentTime.isAfter(selectDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999))) {
            LocalDateTime endTime = currentTime.plusMinutes(workTimeMinutes);
            if (endTime.isAfter(selectDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999))) {
                // 工作时间跨天，只计算到当天的23:59:59
                endTime = selectDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
            }

            String period = currentTime.format(formatter) + " 到 " + endTime.format(formatter);
            if (!endTime.isBefore(selectDateTime)) {
                periods.add(period);
            }

            currentTime = endTime.plusMinutes(intervalTimeMinutes);
        }

        return periods;
    }
}