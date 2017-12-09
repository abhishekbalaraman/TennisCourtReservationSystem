/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainCourtReservation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class jReservations {

    /****** Atributes ******/
    private Date dateReservation;
    private String hourReservation;
    public int memberID;
    public int courtID;
    public enumReservationStatus status;
    public enumEventType eventType;
    public enumEventOrigin eventOrigin;
         
    /****** Methods ******/
    public static boolean isRowReserved (Date reservDate, String reservHour, int idCourt)   {
        int i = 0;
        boolean result = false;
        while (i < dataCourtReservation.jCourtReservationArraylists.Reservations.size() && !result) {
           if (dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).dateReservation.equals(reservDate) &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).hourReservation.equalsIgnoreCase(reservHour) &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).courtID == idCourt &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).status == enumReservationStatus.RESERVED) {
            result = true;
           }
           i++;       
        } 
        return result;
    }
    
     public static boolean isRowCanceled (Date reservDate, String reservHour, int idCourt)   {
        int i = 0;
        boolean result = false;
        while (i < dataCourtReservation.jCourtReservationArraylists.Reservations.size() && !result) {
           if (dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).dateReservation.equals(reservDate) &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).hourReservation.equalsIgnoreCase(reservHour) &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).courtID == idCourt &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).status == enumReservationStatus.CANCELED) {
            result = true;
           }
           i++;       
        } 
        return result;
    }
    
    public static jReservations getReservation (int index)   {
        return dataCourtReservation.jCourtReservationArraylists.Reservations.get(index);
    }
    
    public static enumErrorCode cancelReservation (int index)   {
        jReservations element = dataCourtReservation.jCourtReservationArraylists.Reservations.get(index);
        element.status = enumReservationStatus.CANCELED;
        dataCourtReservation.jCourtReservationArraylists.Reservations.set(index, element);
        return enumErrorCode.OK;
    }
    
    public static int findReservation (Date reservDate, String reservHour)   {
        int i = 0;
        boolean result = false;
        while (i < dataCourtReservation.jCourtReservationArraylists.Reservations.size() && !result) {
           if (dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).dateReservation.equals(reservDate) &&
                dataCourtReservation.jCourtReservationArraylists.Reservations.get(i).hourReservation.equalsIgnoreCase(reservHour)) {
            result = true;
            return i;
           }
           i++;       
        } 
        return -1;
    }
    
    public static String[] presentMemberReservations (int memberID, Date start, Date end)   {
        String[] result = new String[100];
        int cnt = 0;
        for (int i=0; i < dataCourtReservation.jCourtReservationArraylists.Reservations.size(); ++i) {
            jReservations reserv = dataCourtReservation.jCourtReservationArraylists.Reservations.get(i);
            if (reserv.memberID == memberID && (start.before(reserv.dateReservation) || start.equals(reserv.dateReservation))
                                        && (end.after(reserv.dateReservation) || end.equals(reserv.dateReservation))) {
              String tmp1 = reserv.eventType.name();
              String tmp2 = reserv.eventOrigin.name();
              String tmp3 = reserv.status.name();
              SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              String tmp4 = sdf.format(reserv.dateReservation);
              String tmp5 = reserv.hourReservation;
              String tmp6 = Integer.toString(reserv.courtID);
              String tmp7 = Integer.toString(reserv.memberID);
              String finalStr = "Court ID: " + tmp6 + "    Date: " + tmp4 + "    Hour: " + tmp5;
              result[cnt] = finalStr;
              cnt++;
            }      
        } 
        return result;
    }
    
    public static String[] getMemberReservations (int memberID)   {
        String[] result = new String[100];
        int cnt = 0;
        for (int i=0; i < dataCourtReservation.jCourtReservationArraylists.Reservations.size(); ++i) {
            jReservations reserv = dataCourtReservation.jCourtReservationArraylists.Reservations.get(i);
            if (reserv.memberID == memberID && reserv.status == enumReservationStatus.RESERVED) {
              String tmp1 = reserv.eventType.name();
              String tmp2 = reserv.eventOrigin.name();
              String tmp3 = reserv.status.name();
              SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              String tmp4 = sdf.format(reserv.dateReservation);
              String tmp5 = reserv.hourReservation;
              String tmp6 = Integer.toString(reserv.courtID);
              String tmp7 = Integer.toString(reserv.memberID);
              String finalStr = "Court ID: " + tmp6 + "    Date: " + tmp4 + "    Hour: " + tmp5;
              result[cnt] = finalStr;
              cnt++;
            }      
        } 
        return result;
    }
    
    public static String[] getCourtReservations (int courtID)   {
        String[] result = new String[100];
        int cnt = 0;
        for (int i=0; i < dataCourtReservation.jCourtReservationArraylists.Reservations.size(); ++i) {
            jReservations reserv = dataCourtReservation.jCourtReservationArraylists.Reservations.get(i);
            if (reserv.courtID == courtID && reserv.status == enumReservationStatus.RESERVED) {
              String tmp1 = reserv.eventType.name();
              String tmp2 = reserv.eventOrigin.name();
              String tmp3 = reserv.status.name();
              SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              String tmp4 = sdf.format(reserv.dateReservation);
              String tmp5 = reserv.hourReservation;
              String tmp6 = Integer.toString(reserv.courtID);
              String tmp7 = Integer.toString(reserv.memberID);
              String finalStr = "Member ID: " + tmp7 + "    Date: " + tmp4 + "    Hour: " + tmp5 + "    Type: " + tmp1 + "    Origin: " + tmp2;
              result[cnt] = finalStr;
              cnt++;
            }      
        } 
        return result;
    }
    
    public static String[] presentCourtReservations (int courtID, Date dateReserv)   {
        String [] hourSlots = {"00:00", "01:00", "02:00", "03:00", "04:00",
                        "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                        "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                        "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
        String[] result = new String[24];
        for (int n = 0; n < 24; n++) {
            result[n] = hourSlots[n] + "   NOT RESERVED";
        }
        for (int i=0; i < dataCourtReservation.jCourtReservationArraylists.Reservations.size(); ++i) {
            jReservations reserv = dataCourtReservation.jCourtReservationArraylists.Reservations.get(i);
            if (reserv.courtID == courtID && dateReserv.equals(reserv.dateReservation)) {
              int index = 0;
              for (int l = 0; l < hourSlots.length; l++) {
                if(hourSlots[l].equals(reserv.hourReservation)){
                    index = l;
                }
              } 
              String tmp1 = reserv.eventType.name();
              String tmp2 = reserv.eventOrigin.name();
              String tmp3 = reserv.status.name();
              SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              String tmp4 = sdf.format(reserv.dateReservation);
              String tmp5 = reserv.hourReservation;
              String tmp6 = Integer.toString(reserv.courtID);
              String tmp7 = Integer.toString(reserv.memberID);
              String finalStr = tmp5 + "    Member ID: " + tmp7 + "    Type: " + tmp1 + "    Origin: " + tmp2;
              result[index] = finalStr;
            }      
        } 
        return result;
    }
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    public static float presentOccupation (int courtID, Date start, Date end)   {
        int numHoursDay = 24;
        Date myDate = start;
        int cntReservs = 0;
        while (myDate.before(end) || myDate.equals(end)) {
            for (int i=0; i < dataCourtReservation.jCourtReservationArraylists.Reservations.size(); ++i) {
                    jReservations reserv = dataCourtReservation.jCourtReservationArraylists.Reservations.get(i);
                    if (reserv.courtID == courtID && myDate.equals(reserv.dateReservation) && reserv.status == enumReservationStatus.RESERVED) {
                        cntReservs++;
                    }
            }
            myDate = addDays(myDate, 1);
            numHoursDay = numHoursDay + 24;
        }
        if (cntReservs != 0) {
                return (cntReservs * 100) / numHoursDay;
        } else return 0;    
    }
    
    public static enumErrorCode confirmReservation (jReservations reservation) {
        dataCourtReservation.jCourtReservationArraylists.appendReservation(reservation);
	return enumErrorCode.OK;
    }
    
    /****** Constructor ******/
    public jReservations(Date reservDate, String reservHour, int idMember, int idCourt, 
                           enumReservationStatus reservStatus, enumEventType typeEvent, enumEventOrigin origEvent)  {
        this.dateReservation = reservDate;
        this.hourReservation = reservHour;
        this.memberID = idMember;
        this.courtID = idCourt;
        this.status = reservStatus;
        this.eventType = typeEvent;
        this.eventOrigin = origEvent;
    }
}
