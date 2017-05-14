
import java.util.Scanner;

public class Start_main {

	    public static void main(String[] args) {
	    	
	    
	        int menu_num;
	        CalendarVersion2 calendarV2 = new CalendarVersion2(); //calndear�� ��ӹ��� calndearVersion2 ��ü ����
	        EventManager event_manager = new EventManager();

	        while(true){
	            System.out.println("�޴� ��ȣ�� �����Ͻÿ�. (1: ����, 2: �޷���ȸ, 3: �̺�Ʈ �߰�, 4: �̺�Ʈ��ȸ) : ");
	            Scanner scanner = new Scanner(System.in);

	            menu_num = scanner.nextInt();

	            switch (menu_num){
	                case 1 : //����
	                    System.exit(0);

	                case 2 : //�޷���ȸ
	                    int search_year;
	                    int search_month;

	                    System.out.print("��ȸ�� �޷��� �⵵�� �Է��ϼ��� : ");
	                    Scanner s_year = new Scanner(System.in);
	                    search_year = s_year.nextInt();

	                    System.out.print("��ȸ�� �޷��� ���� �Է��ϼ��� : ");
	                    Scanner s_month = new Scanner(System.in);
	                    search_month = s_month.nextInt();

	                    calendarV2.setCalendar(search_year,search_month);
	                    calendarV2.print();

	                    break;

	                case 3 : //�̺�Ʈ �߰�

	                    int event_year;
	                    int event_month;
	                    int event_date;

	                    String event_title;
	                    int event_start_hour;
	                    int event_start_minute;
	                    int event_end_hour;
	                    int event_end_minute;

	                    System.out.print("�̺�Ʈ�� ������ �⵵�� �Է��ϼ��� : ");
	                    Scanner e_year = new Scanner(System.in);
	                    event_year = e_year.nextInt();

	                    System.out.print("�̺�Ʈ�� ������ ���� �Է��ϼ��� : ");
	                    Scanner e_month = new Scanner(System.in);
	                    event_month = e_month.nextInt();

	                    System.out.print("�̺�Ʈ�� ������ �ϸ� �Է��ϼ��� : ");
	                    Scanner e_date = new Scanner(System.in);
	                    event_date = e_date.nextInt();

	                    System.out.print("�̺�Ʈ�� ������ ���� �Է��ϼ��� : ");
	                    Scanner e_title = new Scanner(System.in);
	                    event_title = e_title.nextLine();

	                    System.out.print("�̺�Ʈ ���� �ð��� �Է��ϼ��� : ");
	                    Scanner e_start_hour = new Scanner(System.in);
	                    event_start_hour = e_start_hour.nextInt();

	                    System.out.print("�̺�Ʈ ���� ���� �Է��ϼ��� : ");
	                    Scanner e_start_minute = new Scanner(System.in);
	                    event_start_minute = e_start_minute.nextInt();

	                    System.out.print("�̺�Ʈ ���� �ð��� �Է��ϼ��� : ");
	                    Scanner e_end_hour = new Scanner(System.in);
	                    event_end_hour = e_end_hour.nextInt();

	                    System.out.print("�̺�Ʈ�� ���� ���� �Է��ϼ��� : ");
	                    Scanner e_end_minute = new Scanner(System.in);
	                    event_end_minute = e_end_minute.nextInt();


	                    Event new_event = new Event(event_title, new Date(event_year, event_month , event_date , event_start_hour, event_start_minute),
	                            new Date(event_year, event_month , event_date , event_end_hour, event_end_minute));

	                    event_manager.addEvent(new_event);

	                    //�߰��� �̺�Ʈ�� ǥ���ϱ� ����, �ش� set �޼ҵ� ȣ��
	                    calendarV2.setEventDisplay(event_manager.getEventsListForCalendar());
	                    calendarV2.setCalendar(event_year,event_month);

	                    break;

	                case 4 : //�̺�Ʈ ��ȸ
	                    int user_search_year;
	                    int user_search_month;
	                    int user_search_date;

	                    System.out.print("��ȸ�� �޷��� �⵵�� �Է��ϼ��� : ");
	                    Scanner scan_user_year = new Scanner(System.in);
	                    user_search_year = scan_user_year.nextInt();

	                    System.out.print("��ȸ�� �޷��� ���� �Է��ϼ��� : ");
	                    Scanner scan_user_month = new Scanner(System.in);
	                    user_search_month = scan_user_month.nextInt();

	                    System.out.print("��ȸ�� �޷��� ���� �Է��ϼ��� : ");
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

	    Date(){}//����Ʈ ������

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

	    Event(){}//����Ʈ ������

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

	    Event[] list_event; //�̺�Ʈ�� ������� �迭
	    int count;

	    Event[] search_list; // list_event���� �˻� ����� �ش��ϴ� �̺�Ʈ�� �����ϱ� ���� �迭
	    int search_count;
	    int search_flag; // serarch_list �迭 ����Ȯ���� ���� �÷��� ����

	    EventManager() { //������
	        this.list_event = new Event[10];
	        this.count = 0;

	        this.search_list = new Event[10];
	        this.search_count = 0;
	        this.search_flag = 0;
	    }

	    void addEvent(Event e) {//�̺�Ʈ�� �߰��ϴ� �޼ҵ�
	        list_event[count] = e;
	        count++;
	    }

	    Event[] getEvents(Date date) {
	        search_list = new Event[10]; //�˻� ����� �����ϴ� search_list �迭 �ʱ�ȭ �۾�
	        search_count = 0;

	        for (int i = 0; i < count; i++) {
	            if (list_event[i].start_date.year == date.year && //�˻��Ϸ��� �̺�Ʈ ��¥�� list_event �迭�� �ִ��� Ȯ��
	                    list_event[i].start_date.month == date.month &&
	                    list_event[i].start_date.day == date.day) {

	                search_list[search_count] = list_event[i]; //�˻��Ǹ� �̸� �˻� ����� �����ϴ� search_list�� ����
	                search_count++;
	                search_flag = 1;
	            }
	        }
	        return search_list; //search_list �迭 ����
	    }


	    Event[] getEventsListForCalendar() { // list_event �迭�� �����ϴ� get �޼ҵ�
	        return this.list_event;
	    }


	    void print() {
	        System.out.println("***Event List***");

	        if(search_flag==1){//�˻��迭�� �����Ǿ����� ��Ÿ���� �÷��װ� ���� ���.
	            for (int i = 0; i < search_count; i++) {
	                System.out.println("����: " + search_list[i].name);
	                System.out.println("����: [" + search_list[i].start_date.year + "�� "
	                                        + search_list[i].start_date.month + "�� "+
	                                        + search_list[i].start_date.day + "�� "+
	                                        + search_list[i].start_date.hour + ": "+
	                                        + search_list[i].start_date.minute + "] , ����:["+
	                                        + search_list[i].end_date.year + "�� "
	                                        + search_list[i].end_date.month + "�� "+
	                                        + search_list[i].end_date.day + "�� "+
	                                        + search_list[i].end_date.hour + ": "+
	                                        + search_list[i].end_date.minute + "] ");
	            }
	            search_flag = 0;
	        }
	        else{
	            System.out.println("�ش� ��¥�� �̺�Ʈ�� �����ϴ�.");
	        }

	    }
	}

	class CalendarUtil {
	    public static int calDays(int year, int month, int day) {
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int total_days = 0;
	        total_days += (year - 1) * 365;                             // ���� �⵵������ �ϼ�
	        total_days += year / 4 - year / 100 + year / 400;             // ������ Ƚ���� ����
	        if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) &&   // year�� �����̰�
	                (month <= 2))                                    // month�� 1,2���̸�
	            total_days--;                                       // �����̹Ƿ� �տ��� �߰��� �Ϸ縦 �ٽ� ����
	        for (int i = 0; i < month - 1; i++)
	            total_days += months[i];
	        total_days += day;                                      // day �ϼ��� �߰�
	        return total_days;
	    }

	    public static int calcLastDay(int year, int month) {
	        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int day = 1;

	        if (month != 2)                                     // 2���� �ƴϸ�
	            day = months[month - 1];
	        else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 2���̰� �����̸�
	            day = months[month - 1] + 1;                        // ������ �ϼ� �Ϸ� �߰�
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
	            for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {  //ù��° �ִ� 1���� ���Ϻ��� ����
	                calArray[i][j] = day++;
	                if (day > lastDay) return;
	            }
	            if (i == 0) startDayOfWeek = 0;             // �ι�° �ֺ��ʹ� �ٽ� �����Ϻ��� ����
	        }
	    }

	    public void print() {
	        System.out.printf("%4d �� %2d �� �޷�\n",year,month);
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
	     * �޷¿��� �Է� �Ķ������ day�� ����ȸ�� ���·� ����ϴ� �޼ҵ�
	     * �� �޼ҵ�� ����Ŭ�������� �������Ͽ� day�� �ٸ� �������� ��µǵ��� �� �� ����� �� �ִ�
	     * @param date
	     */
	    //protected void printDate(int date) {
	    public void printDate(int date) {
	        if (date >= 1 && date <= 31) {
	            if (date == day)
	                //System.out.printf("%2d%s%2s", date,"*",""); // date�� ���ڸ� ������ ����ϰ�, �̾ *�� ����ϰ� ��ĭ�� �� ���ڿ� ������ ���
	                System.out.printf("%2d%s%2s", date,"");
	            else
	                System.out.printf("%2d%3s", date, ""); // date�� ���ڸ� ������ ����ϰ�, �̾ ��ĭ�� �� ���ڿ� ������ ���

	        } else {
	            String s = "";
	            System.out.printf("%5s", s);          // date ���� ���� ���̸�, �ټ�ĭ�� �� ���ڿ� ������ ���
	        }
	    }
	}

	class CalendarVersion2 extends Calendar { //Calendar Ŭ������ ��ӹ��� CalendarVersion2 Ŭ����

	    static final int DAYS_OF_WEEK = 7;
	    static final int WEAKS_OF_MONTH = 6;

	    protected int[][] calArray;

	    protected int year;
	    protected int month;
	    protected int day;

	    Event[] event_display= new Event[10]; //�߰� �� �κ�
	    int event_display_flag = 0; //�̺�Ʈ�� ����ִ� �迭�� �ּҰ� set �Ǿ����� Ȯ���ϴ� �÷��� ����.

	    //�ش糯¥�� ��� �̺�Ʈ�� �ִ��� �����ϴ� �迭 ����.
	    protected int[][] event_count_array = new int[WEAKS_OF_MONTH][DAYS_OF_WEEK];


	    public void setEventDisplay(Event[] event_display){ //�̺�Ʈ�� ����ִ� �迭�� �ּҸ� set �ϴ� �޼ҵ�
	        this.event_display = event_display;
	        event_display_flag = 1;
	    }


	    public CalendarVersion2() {//������
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

	        if(event_display_flag==1) { // �÷��װ� ���̶��
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

	    // �̺�Ʈ�� � �����Ǿ����� Ȯ�� �� �� �ִ� event_count_array�� �ʱ�ȭ�ϴ� �޼ҵ�
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
	            for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {  //ù��° �ִ� 1���� ���Ϻ��� ����
	                calArray[i][j] = day++;

	                if (day > lastDay) break;
	            }
	            if (i == 0) startDayOfWeek = 0;             // �ι�° �ֺ��ʹ� �ٽ� �����Ϻ��� ����
	        }

	        if(event_display_flag==1) {

	            for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	                for (int j = startDayOfWeek; j < DAYS_OF_WEEK; j++) {
	                    for (int k = 0; k < event_display.length; k++) {

	                        if(event_display[k] == null){ //�̺�Ʈ�� ������ break
	                            break;}

	                        //�̺�Ʈ�� �ش� ���� �ִٸ�, event_count_array �迭�� �̺�Ʈ ������ 1 ����
	                        if (event_display[k].start_date.month == this.month && event_display[k].start_date.day == calArray[i][j]) {
	                            event_count_array[i][j] += 1;}
	                    }
	                }
	            }//for�� ����
	        }

	    }

	    public void print() {
	        System.out.printf("%4d �� %2d �� �޷�\n",year,month);
	        System.out.printf("%3s%5s%5s%5s%5s%5s%5s\n", "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT");

	        for (int i = 0; i < WEAKS_OF_MONTH; i++) {
	            for (int j = 0; j < DAYS_OF_WEEK; j++) {

	                if(event_display_flag == 1){ //�̺�Ʈ�� ������ �޷��� ����� ���
	                    printDate(calArray[i][j],event_count_array[i][j]); //�ش糯¥�� �̺�Ʈ ������ ���ڰ����� �ѱ�.
	                }
	                else{
	                    //�̺�Ʈ�� �������� ���� �޷��� ����� ���
	                    super.printDate(calArray[i][j]);
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }


	    public void printDate(int date, int event_count) {

	        if (date >= 1 && date <= 31) {
	            if (event_count != 0) { //�̺�Ʈ�� �ִ°��
	                System.out.printf("%2d%s%2d%s", date, "(",event_count, ")");
	            }
	            else{
	                System.out.printf("%2d%3s", date, "");} // date�� ���ڸ� ������ ����ϰ�, �̾ ��ĭ�� �� ���ڿ� ������ ���*/}
	        }
	        else {
	            String s = "";
	            System.out.printf("%5s", s);          // date ���� ���� ���̸�, �ټ�ĭ�� �� ���ڿ� ������ ���
	        }
	    }

	}//CalendarVersion2 class


