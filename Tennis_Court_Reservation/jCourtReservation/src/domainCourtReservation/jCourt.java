/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainCourtReservation;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Paulo Garcez Vieira
 */

public class jCourt {
    
    /****** Atributes ******/
    private int courtID;
    private enumSurface surface;
    private String locationType;
    private Boolean lighting;
    private Boolean enable;
    private jTimetable[] timetable;

     
    /****** Methods ******/
    public static int findCourt (int idCourt) {
        for(int i = 0; i < dataCourtReservation.jCourtReservationArraylists.Courts.size(); ++i) {
            if(dataCourtReservation.jCourtReservationArraylists.Courts.get(i).courtID == idCourt) return i;
        }
		return -1;
    }
    
    public static int newCourt (jCourt court) {
        dataCourtReservation.jCourtReservationArraylists.appendCourt(court);
        return 0;
    }
    
    public static int modifyCourt (int index, jCourt court) {
        dataCourtReservation.jCourtReservationArraylists.editCourt(index, court);
        return 0;
    }
    
    public static int validCourt (jCourt court) {
        if (court.surface == null || court.locationType == null 
                || court.lighting == null || court.enable == null
                || court.locationType.isEmpty()) return -1;
        return 0;
    }
    
    public static enumErrorCode saveCourt (int index, jCourt court) {
        int i = 0;
        int err = validCourt(court);
        if (err != 0) {
            return enumErrorCode.INF_INVALID;
        } 
        if (index >= 0)  {
            i = modifyCourt(index, court);
        } else {
            i = newCourt(court);
        }
        if (i == 0) {
            return enumErrorCode.OK;
        } else {
            return enumErrorCode.NOT_SAVE;
        }
    }
    
    public static enumErrorCode deleteCourt (int index) {
        if (index >= 0)  {
            dataCourtReservation.jCourtReservationArraylists.removeCourt(index);
            return enumErrorCode.OK;
        }
        return enumErrorCode.NOT_FOUND;
    }
      
    public static int getCourtID (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getCourt(index).courtID;
    }
    
    public static enumSurface getSurface (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getCourt(index).surface;
    }
    
    public static String getLocation (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getCourt(index).locationType;
    }
    
    public static boolean getLighting (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getCourt(index).lighting;
    }
    
    public static boolean getEnable (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getCourt(index).enable;
    }
    
    public static String[] getCourtsID() {
        String[] array = new String[dataCourtReservation.jCourtReservationArraylists.Courts.size()];
        for(int i = 0; i < array.length; i++) {
            int j = dataCourtReservation.jCourtReservationArraylists.Courts.get(i).courtID;
            array[i] = Integer.toString(j);
        }
        return array;
    }

    public static int[] matchCourts(enumSurface playground, String location, Boolean lights, Boolean all) {
        int comp = dataCourtReservation.jCourtReservationArraylists.Courts.size();
        
        ArrayList<Integer> list = new ArrayList<Integer> ();
        boolean a, b, c;
        if (!all) {
            for (int i = 0; i < comp; i++) {
                if (playground != null) {
                    a = getSurface(i) == playground;
                } else { a = true; }
                if (location == null || location.isEmpty())  {
                    b = true;
                } else { b = getLocation(i).equalsIgnoreCase(location); }
                if (lights) {
                    c = getLighting(i) && lights;
                } else { c = true; }
                if (a && b && c) {
                    list.add(dataCourtReservation.jCourtReservationArraylists.Courts.get(i).courtID);           
                }
            }
        } else  {
            for (int i = 0; i < comp; i++)  {
                list.add(dataCourtReservation.jCourtReservationArraylists.Courts.get(i).courtID);
            }
        }
        int[] array = new int[list.size()];
        for (int j = 0; j < array.length; j++) {
            array[j] = list.get(j);
        }
        return array;
    }    
    
    /****** Constructor *******/
    public jCourt(int idCourt, enumSurface playground, String location, Boolean lights, Boolean enabled)  {
        this.courtID = idCourt;
        this.surface = playground;
        this.locationType = location;
        this.lighting = lights;
        this.enable = enabled;
    }

}
