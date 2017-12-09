/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainCourtReservation;

import java.util.Date;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class jTimetable {
       
    /****** Atributes ******/
    private int courtID;
    private Date dateStart;
    private Date dateEnd;
    private String hourFrom;
    private String hourTo;
    private boolean weekend;
         
    /****** Methods ******/
    public static int validTimetable (jTimetable timetable) {
        if (timetable.dateStart == null || timetable.dateEnd == null
            || timetable.hourFrom == null || timetable.hourTo == null
            || timetable.hourFrom.isEmpty() || timetable.hourTo.isEmpty()) return -1;
	
        if (timetable.dateEnd.before(timetable.dateEnd)) return -2;
        
        try {
                String strFrom = timetable.hourFrom;
                String strTo = timetable.hourTo;
                int k = Integer.valueOf(strFrom.substring(0, 2));
                int j = Integer.valueOf(strTo.substring(0, 2));
                if (k > j) return -3;
            } catch (NumberFormatException e) { 
                    return -1;}
            
        return 0;
    }
	
    public static enumErrorCode addTimetable (jTimetable timetable) {
	int err = validTimetable(timetable);
	if (err == -1) return enumErrorCode.INF_INVALID;
	if (err == -2) return enumErrorCode.DATE_INVERSION;
	if (err == -3) return enumErrorCode.HOUR_INVERSION;
        
        if (overlapCourtTimetable (timetable.courtID, timetable.dateStart, timetable.dateEnd)) return enumErrorCode.DATE_OVERLAP;
        
        dataCourtReservation.jCourtReservationArraylists.appendTimetable(timetable);
        return enumErrorCode.OK;
    }
    
    public static int existCourtTimetable (int idCourt, Date reservDate)  {
        for(int i = 0; i < dataCourtReservation.jCourtReservationArraylists.Timetables.size(); ++i) 
        {
            if (dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).courtID == idCourt) {
                if (dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart.equals(reservDate) ||
                    dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd.equals(reservDate) ||
                    (reservDate.after(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart) &&
                    reservDate.before(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd)))  
                    return i;
            }
	}
        return -1;
    }
    
    public static boolean overlapCourtTimetable (int idCourt, Date startDate, Date endDate)  {
        for(int i = 0; i < dataCourtReservation.jCourtReservationArraylists.Timetables.size(); ++i) 
        {
            if (dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).courtID == idCourt) {
                if (startDate.after(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart) &&
                    startDate.before(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd))  
                    return true;
                if (endDate.after(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart) &&
                    endDate.before(dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd))  
                    return true;
                if (dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart.equals(startDate) ||
                    dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd.equals(startDate))
                    return true;
                if (dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateStart.equals(endDate) ||
                    dataCourtReservation.jCourtReservationArraylists.Timetables.get(i).dateEnd.equals(endDate))
                    return true;
            }
	}
        return false;
    }
    
    public static jTimetable getCourtTimetable (int index)  {
        return dataCourtReservation.jCourtReservationArraylists.Timetables.get(index);
    }
    
    public static enumReservationStatus[][] setupSlots(int[] arrayidCourt, int nrows, Date reservDate, Boolean noWorkingDay)  {
        int ncols = arrayidCourt.length + 1;
        enumReservationStatus[][] setupResult = new enumReservationStatus[nrows][ncols];
        String [] hourSlots = {"00:00", "01:00", "02:00", "03:00", "04:00",
                        "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                        "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                        "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
        for (int j = 1; j < ncols; j++)  {
            int index = existCourtTimetable(arrayidCourt[j - 1], reservDate);
            if (index != -1 && noWorkingDay.equals(getCourtTimetable(index).weekend))  { 
                String from = getCourtTimetable(index).hourFrom;
                String to = getCourtTimetable(index).hourTo;
                boolean topLimit = false;
                boolean bottomLimit = false;
                for (int i = 0; i < nrows; i++)  {
                    if (from.equalsIgnoreCase(hourSlots[i])) topLimit = true;
                    if (to.equalsIgnoreCase(hourSlots[i])) bottomLimit = true;
                    if (topLimit && !bottomLimit) {
                        setupResult[i][j] = enumReservationStatus.AVAILABLE;
                    } else {
                        setupResult[i][j] = enumReservationStatus.UNAVAILABLE;
                    }
                }       
            } else {
                for (int l = 0; l < nrows; l++) {
                    setupResult[l][j] = enumReservationStatus.UNAVAILABLE;    
                }       
            }                
        }
        return setupResult;
    }
    
    /****** Constructor ******/
    public jTimetable(int idCourt, Date startDate, Date endDate, String fromHour, String toHour, boolean nwd)  {
        this.courtID = idCourt;
        this.dateStart = startDate;
        this.dateEnd = endDate;
        this.hourFrom = fromHour;
        this.hourTo = toHour;
        this.weekend = nwd;
    }
}
