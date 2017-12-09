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
public class jDate {
    
    /****** Atributes ******/
    private Date dateFrom;
    private Date dateTo;
    private String datePurpose;
         
    /****** Methods ******/
    public static int validDate (jDate dates) {
        if (dates.dateFrom == null || dates.dateTo == null || dates.datePurpose == null) return -1;
        if (dates.dateTo.before(dates.dateFrom)) return -2; 
        return 0;
    }
	
    public static enumErrorCode addDate (jDate dates) {
        int err = validDate(dates);
        if (err == -1) return enumErrorCode.INF_INVALID;
	if (err == -2) return enumErrorCode.DATE_INVERSION;
        dataCourtReservation.jCourtReservationArraylists.appendDate(dates);
	return enumErrorCode.OK;
    }
    
    public static enumErrorCode enabledDate (Date reservDate)   {
        for(int i = 0; i < dataCourtReservation.jCourtReservationArraylists.Dates.size(); ++i) 
        {
            if (dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateFrom.equals(reservDate) ||
                dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateTo.equals(reservDate) ||
                    (reservDate.after(dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateFrom) &&
                    reservDate.before(dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateTo)))  
            return enumErrorCode.CLUB_CLOSED;
	}
        return enumErrorCode.CLUB_OPEN;
    }
    
    public static String enabledPurpose (Date reservDate)   {
        int i = 0;
        boolean found = false;
        String result = null;
        while (i < dataCourtReservation.jCourtReservationArraylists.Dates.size() || !found) {
           if (dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateFrom.equals(reservDate) ||
                dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateTo.equals(reservDate) ||
                    (reservDate.after(dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateFrom) &&
                    reservDate.before(dataCourtReservation.jCourtReservationArraylists.Dates.get(i).dateTo))) {
            found = true;
           }
           i++;       
        } 
        if (found)  
        {
            result = dataCourtReservation.jCourtReservationArraylists.Dates.get(i - 1).datePurpose;
	}
        return result;
    }
    
    /****** Constructor ******/
    public jDate(Date fromDate, Date toDate, String purpose)  {
        this.dateFrom = fromDate;
        this.dateTo = toDate;
        this.datePurpose = purpose;
    }
}
