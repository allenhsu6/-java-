package PreparedForAmzon;

public class FindDate {
    public static void main(String[] args) {
        Date[] dates = new Date[6];
        dates[0] = new Date(2014, 4, 29);
        dates[1] = new Date(2018, 5, 29);
        dates[2] = new Date(2018, 6, 25);
        dates[3] = new Date(2017, 6, 23);
        dates[4] = new Date(2016, 5, 9);
        dates[5] = new Date(2014, 4, 29);
//        bubbleSort(dates);
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }

    }

//    static Date[] bubbleSort(Date[] dates){
//        for (int i = 0; i < dates.length; i++) {
//            for (int j = i+1; j < dates.length; j++) {
//                if (dates[i].compare(dates[j]) > 0) {
//                    Date a = dates[j];
//                    dates[j] = dates[i];
//                    dates[i] = a;
//                }
//            }
//        }
//        return dates;
//    }
}
