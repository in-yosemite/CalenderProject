
import java.util.Scanner;

public class Start_main {

	    public static void main(String[] args) {
	    	
	    
	        int menu_num;
	        CalendarVersion2 calendarV2 = new CalendarVersion2(); //calndear를 상속받은 calndearVersion2 객체 생성
	        EventManager event_manager = new EventManager();

	        while(true){
	            System.out.println("메뉴 번호를 선택하시오. (1: 종료, 2: 달력조회, 3: 이벤트 추가, 4: 이벤트조회) : ");
	            Scanner scanner = new Scanner(System.in);

	            menu_num = scanner.nextInt();

	            switch (menu_num){
	                case 1 : //종료
	                    System.exit(0);

	                case 2 : //달력조회
	                    int search_year;
	                    int search_month;

	                    System.out.print("조회할 달력의 년도를 입력하세요 : ");
	                    Scanner s_year = new Scanner(System.in);
	                    search_year = s_year.nextInt();

	                    System.out.print("조회할 달력의 월을 입력하세요 : ");
	                    Scanner s_month = new Scanner(System.in);
	                    search_month = s_month.nextInt();

	                    calendarV2.setCalendar(search_year,search_month);
	                    calendarV2.print();

	                    break;

	                case 3 : //이벤트 추가

	                    int event_year;
	                    int event_month;
	                    int event_date;

	                    String event_title;
	                    int event_start_hour;
	                    int event_start_minute;
	                    int event_end_hour;
	                    int event_end_minute;

	                    System.out.print("이벤트를 생성할 년도를 입력하세요 : ");
	                    Scanner e_year = new Scanner(System.in);
	                    event_year = e_year.nextInt();

	                    System.out.print("이벤트를 생성할 월을 입력하세요 : ");
	                    Scanner e_month = new Scanner(System.in);
	                    event_month = e_month.nextInt();

	                    System.out.print("이벤트를 생성할 일를 입력하세요 : ");
	                    Scanner e_date = new Scanner(System.in);
	                    event_date = e_date.nextInt();

	                    System.out.print("이벤트를 생성할 제목를 입력하세요 : ");
	                    Scanner e_title = new Scanner(System.in);
	                    event_title = e_title.nextLine();

	                    System.out.print("이벤트 시작 시간을 입력하세요 : ");
	                    Scanner e_start_hour = new Scanner(System.in);
	                    event_start_hour = e_start_hour.nextInt();

	                    System.out.print("이벤트 시작 분을 입력하세요 : ");
	                    Scanner e_start_minute = new Scanner(System.in);
	                    event_start_minute = e_start_minute.nextInt();

	                    System.out.print("이벤트 종료 시간을 입력하세요 : ");
	                    Scanner e_end_hour = new Scanner(System.in);
	                    event_end_hour = e_end_hour.nextInt();

	                    System.out.print("이벤트를 종료 분을 입력하세요 : ");
	                    Scanner e_end_minute = new Scanner(System.in);
	                    event_end_minute = e_end_minute.nextInt();


	                    Event new_event = new Event(event_title, new Date(event_year, event_month , event_date , event_start_hour, event_start_minute),
	                            new Date(event_year, event_month , event_date , event_end_hour, event_end_minute));

	                    event_manager.addEvent(new_event);

	                    //추가된 이벤트를 표시하기 위해, 해당 set 메소드 호출
	                    calendarV2.setEventDisplay(event_manager.getEventsListForCalendar());
	                    calendarV2.setCalendar(event_year,event_month);

	                    break;

	                case 4 : //이벤트 조회
	                    int user_search_year;
	                    int user_search_month;
	                    int user_search_date;

	                    System.out.print("조회할 달력의 년도를 입력하세요 : ");
	                    Scanner scan_user_year = new Scanner(System.in);
	                    user_search_year = scan_user_year.nextInt();

	                    System.out.print("조회할 달력의 월을 입력하세요 : ");
	                    Scanner scan_user_month = new Scanner(System.in);
	                    user_search_month = scan_user_month.nextInt();

	                    System.out.print("조회할 달력의 일을 입력하세요 : ");
	                    Scanner scan_user_date = new Scanner(System.in);
	                    user_search_date = scan_user_date.nextInt();

	                    event_manager.getEvents(new Date(user_search_year,user_search_month,user_search_date));
	                    event_manager.print();

	                    break;

	            }
	        }

	    }
	}

	class Date{
	    int year, month, day, hour, minute;

	    Date(){}//디폴트 생성자

	    Date(int year, int month, int day){
	        this.year = year;
	        this.month = month;
	        this.day = day;
	    }

	    Date(int year, int month, int day, int hour, int minute){
	        this.year = year;
	        this.month = month;
	        this.day = day;
	        this.hour = hour;
	        this.minute = minute;
	    }

	}

	class Event{
	    String name;
	    Date start_date;
	    Date end_date;

	    Event(){}//디폴트 생성자

	    Event(String name, Date start_date, Date end_date){
	        this.name = name;
	        this.start_date = start_date;
	        this.end_date = end_date;
	    }
	}

	class EventManager {

	    int search_year;
	    int search_month;
	    int search_day;

	    Event[] list_event; //이벤트를 담기위한 배열
	    int count;

	    Event[] search_list; // list_event에서 검색 결과에 해당하는 이벤트를 저장하기 위한 배열
	    int search_count;
	    int search_flag; // serarch_list 배열 생성확인을 위한 플래그 변수

	    EventManager() { //생성자
	        this.list_event = new Event[10];
	        this.count = 0;

	        this.search_list = new Event[10];
	        this.search_count = 0;
	        this.search_flag = 0;
	    }

	    void addEvent(Event e) {//이벤트를 추가하는 메소드
	        list_event[count] = e;
	        count++;
	    }

	    Event[] getEvents(Date date) {
	        search_list = new Event[10]; //검색 결과를 저장하는 search_list 배열 초기화 작업
	        search_count = 0;

	        for (int i = 0; i < count; i++) {
	            if (list_event[i].start_date.year == date.year && //검색하려는 이벤트 날짜가 list_event 배열에 있는지 확인
	                    list_event[i].start_date.month == date.month &&
	                    list_event[i].start_date.day == date.day) {

	                search_list[search_count] = list_event[i]; //검색되면 이를 검색 결과를 저장하는 search_list에 저장
	                search_count++;
	                search_flag = 1;
	            }
	        }
	        return search_list; //search_list 배열 리턴
	    }


	    Event[] getEventsListForCalendar() { // list_event 배열을 리턴하는 get 메소드
	        return this.list_event;
	    }


	    void print() {
	        System.out.println("***Event List***");

	        if(search_flag==1){//검색배열이 생성되었음을 나타내는 플래그가 참일 경우.
	            for (int i = 0; i < search_count; i++) {
	                System.out.println("제목: " + search_list[i].name);
	                System.out.println("시작: [" + search_list[i].start_date.year + "년 "
	                                        + search_list[i].start_date.month + "월 "+
	                                        + search_list[i].start_date.day + "일 "+
	                                        + search_list[i].start_date.hour + ": "+
	                                        + search_list[i].start_date.minute + "] , 종료:["+
	                                        + search_list[i].end_date.year + "년 "
	                                        + search_list[i].end_date.month + "월 "+
	                                        + search_list[i].end_date.day + "일 "+
	                                        + search_list[i].end_date.hour + ": "+
	                                        + search_list[i].end_date.minute + "] ");
	            }
	            search_flag = 0;
	        }
	        else{
	            System.out.println("해당 날짜에 이벤트가 없습니다.");
	        }

	    }
	}

	class CalendarUtil {
	    public static int calDays(int year, int month, int day) {
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int total_days = 0;
	        total_days += (year - 1) * 365;                             // 이전 년도까지의 일수
	        total_days += year / 4 - year / 100 + year / 400;             // 윤년의 횟수를 더함
	        if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) &&   // year가 윤년이고
	                (month <= 2))                                    // month가 1,2월이면
	            total_days--;                                       // 윤년이므로 앞에서 추가한 하루를 다시 빼줌
	        for (int i = 0; i < month - 1; i++)
	            total_days += months[i];
	        total_days += day;                                      // day 일수를 추가
	        return total_days;
	    }

	    public static int calcLastDay(int year, int month) {
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int day = 1;

	        if (month != 2)                                     // 2월이 아니면
	            day = months[month - 1];
	        else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 2월이고 윤년이면
	            day = months[month - 1] + 1;                        // 윤달의 일수 하루 추가
	        return day;

	    }
	}

	class Calendar {
	    static final int DAYS_OF_WEEK = 7;
	    static final int WEAKS_OF_MONTH = 6;

	    protected int[][] calArray;

	    protected int year;
	    protected int month;
	    protected int day;

	    public Calendar() {
	        year = month = day = 0;
	        calArray = new int[WEAKS_OF_MONTH][DAYS_OF_WEEK];
	    }

	    public void setCalendar(int year, int month) {
	        this.year = year;
	        this.month = month;
	        this.day = 0;
	        makeCalendar(year,month);
	    }

	    public void setCalendar(int year, int month, int day) {
	        setCalendar(year,month);
	        this.day = day;

	    }

	    private void makeCalendar(int year, int month) {
	        initCalArray();
	        int total_days = CalendarUtil.calDays(year, month, 1);
	        int dayOfWeek = total_days % 7;
	        int lastDay = CalendarUtil.calcLastDay(year, month);
	        setCalArray(dayOfWeek, lastDay);
	    }

	    private void initCalArray() {
	        for (int i = 0; i < WEAKS_OF_MONTH; i++)
	            for (int j = 0; j < DAYS_OF_WEEK; j++)
	                calArray[i][j] =0;
	    }

	    private void setCalArray(int startDayOfWeek, int lastDay) {
	        int day = 1;
	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {  //첫번째 주는 1일의 요일부터 시작
	                calArray[i][j] = day++;
	                if (day > lastDay) return;
	            }
	            if (i == 0) startDayOfWeek = 0;             // 두번째 주부터는 다시 월요일부터 시작
	        }
	    }

	    public void print() {
	        System.out.printf("%4d 년 %2d 월 달력\n",year,month);
	        System.out.printf("%3s%5s%5s%5s%5s%5s%5s\n", "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT");
	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = 0; j < DAYS_OF_WEEK; j++) {
	                printDate(calArray[i][j]);


	                /*
	                if(){

	                }
	                else{
	                    printDate(calArray[i][j]);
	                }*/
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    /**
	     * 달력에서 입력 파라미터인 day를 형식회된 형태로 출력하는 메소드
	     * 이 메소드는 서브클래스에서 재정의하여 day를 다른 형식으로 출력되도록 할 때 사용할 수 있다
	     * @param date
	     */
	    //protected void printDate(int date) {
	    public void printDate(int date) {
	        if (date >= 1 && date <= 31) {
	            if (date == day)
	                //System.out.printf("%2d%s%2s", date,"*",""); // date는 두자리 정수로 출력하고, 이어서 *를 출력하고 두칸의 빈 문자열 공백을 출력
	                System.out.printf("%2d%s%2s", date,"");
	            else
	                System.out.printf("%2d%3s", date, ""); // date는 두자리 정수로 출력하고, 이어서 세칸의 빈 문자열 공백을 출력

	        } else {
	            String s = "";
	            System.out.printf("%5s", s);          // date 값이 범위 밖이면, 다섯칸의 빈 문자열 공백을 출력
	        }
	    }
	}

	class CalendarVersion2 extends Calendar { //Calendar 클래스를 상속받은 CalendarVersion2 클래스

	    static final int DAYS_OF_WEEK = 7;
	    static final int WEAKS_OF_MONTH = 6;

	    protected int[][] calArray;

	    protected int year;
	    protected int month;
	    protected int day;

	    Event[] event_display= new Event[10]; //추가 된 부분
	    int event_display_flag = 0; //이벤트가 담겨있는 배열의 주소가 set 되었는지 확인하는 플래그 변수.

	    //해당날짜에 몇개의 이벤트가 있는지 저장하는 배열 생성.
	    protected int[][] event_count_array = new int[WEAKS_OF_MONTH][DAYS_OF_WEEK];


	    public void setEventDisplay(Event[] event_display){ //이벤트가 담겨있는 배열의 주소를 set 하는 메소드
	        this.event_display = event_display;
	        event_display_flag = 1;
	    }


	    public CalendarVersion2() {//생성자
	        year = month = day = 0;
	        calArray = new int[WEAKS_OF_MONTH][DAYS_OF_WEEK];
	    }

	    public void setCalendar(int year, int month) {
	        this.year = year;
	        this.month = month;
	        this.day = 0;
	        makeCalendar(year,month);
	    }

	    public void setCalendar(int year, int month, int day) {
	        setCalendar(year,month);
	        this.day = day;
	    }

	    private void makeCalendar(int year, int month) {
	        initCalArray();

	        if(event_display_flag==1) { // 플래그가 참이라면
	            initEventCountArray();
	        }

	        int total_days = CalendarUtil.calDays(year, month, 1);
	        int dayOfWeek = total_days % 7;
	        int lastDay = CalendarUtil.calcLastDay(year, month);
	        setCalArray(dayOfWeek, lastDay);
	    }

	    private void initCalArray() {
	        for (int i = 0; i < WEAKS_OF_MONTH; i++)
	            for (int j = 0; j < DAYS_OF_WEEK; j++)
	                calArray[i][j] =0;
	    }

	    // 이벤트가 몇개 생성되었는지 확인 할 수 있는 event_count_array을 초기화하는 메소드
	    private void initEventCountArray() {
	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = 0; j < DAYS_OF_WEEK; j++){
	                event_count_array[i][j] = 0;
	            }
	        }
	    }

	    private void setCalArray(int startDayOfWeek, int lastDay) {
	        int day = 1;
	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {  //첫번째 주는 1일의 요일부터 시작
	                calArray[i][j] = day++;

	                if (day > lastDay) break;
	            }
	            if (i == 0) startDayOfWeek = 0;             // 두번째 주부터는 다시 월요일부터 시작
	        }

	        if(event_display_flag==1) {

	            for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	                for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {
	                    for (int k = 0; k < event_display.length; k++) {

	                        if(event_display[k] == null){ //이벤트가 없으면 break
	                            break;}

	                        //이벤트가 해당 월에 있다면, event_count_array 배열에 이벤트 개수를 1 증가
	                        if (event_display[k].start_date.month == this.month && event_display[k].start_date.day == calArray[i][j]) {
	                            event_count_array[i][j] += 1;}
	                    }
	                }
	            }//for문 종료
	        }

	    }

	    public void print() {
	        System.out.printf("%4d 년 %2d 월 달력\n",year,month);
	        System.out.printf("%3s%5s%5s%5s%5s%5s%5s\n", "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT");

	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = 0; j < DAYS_OF_WEEK; j++) {

	                if(event_display_flag == 1){ //이벤트가 생성된 달력을 출력할 경우
	                    printDate(calArray[i][j],event_count_array[i][j]); //해당날짜의 이벤트 개수를 인자값으로 넘김.
	                }
	                else{
	                    //이벤트가 생성되지 않은 달력을 출력할 경우
	                    super.printDate(calArray[i][j]);
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }


	    public void printDate(int date, int event_count) {

	        if (date >= 1 && date <= 31) {
	            if (event_count != 0) { //이벤트가 있는경우
	                System.out.printf("%2d%s%2d%s", date, "(",event_count, ")");
	            }
	            else{
	                System.out.printf("%2d%3s", date, "");} // date는 두자리 정수로 출력하고, 이어서 세칸의 빈 문자열 공백을 출력*/}
	        }
	        else {
	            String s = "";
	            System.out.printf("%5s", s);          // date 값이 범위 밖이면, 다섯칸의 빈 문자열 공백을 출력
	        }
	    }

	}//CalendarVersion2 class


