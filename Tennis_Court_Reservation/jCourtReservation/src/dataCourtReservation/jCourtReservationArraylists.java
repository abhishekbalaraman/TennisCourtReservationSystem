/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataCourtReservation;

import domainCourtReservation.enumEventOrigin;
import domainCourtReservation.enumEventType;
import domainCourtReservation.enumReservationStatus;
import domainCourtReservation.enumSurface;
import domainCourtReservation.jCourt;
import domainCourtReservation.jDate;
import domainCourtReservation.jMember;
import domainCourtReservation.jReservations;
import domainCourtReservation.jTimetable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class jCourtReservationArraylists {
    
        public static ArrayList<jCourt> Courts = new ArrayList<jCourt> ();
        public static ArrayList<jMember> Members = new ArrayList<jMember> ();
        public static ArrayList<jDate> Dates = new ArrayList<jDate> ();
        public static ArrayList<jTimetable> Timetables = new ArrayList<jTimetable> ();
        public static ArrayList<jReservations> Reservations = new ArrayList<jReservations> ();
        
        public jCourtReservationArraylists() throws ParseException {
            Courts.add(new jCourt(1, enumSurface.CLAY, "INDOOR", true, false));
            Courts.add(new jCourt(2, enumSurface.CARPET, "OUTDOOR", false, true));
            Courts.add(new jCourt(3, enumSurface.GRASS, "OUTDOOR", true, false));
            Courts.add(new jCourt(4, enumSurface.HARD, "OUTDOOR", false, true));
            Courts.add(new jCourt(5, enumSurface.HARD, "OUTDOOR", true, true));
            Courts.add(new jCourt(6, enumSurface.CLAY, "INDOOR", false, true));
            
            Members.add(new jMember(1, "Abhishek Balaraman", enumSurface.CLAY, "abhishek@estgoh.pt", "166912", true));
            Members.add(new jMember(2, "António Queirós", enumSurface.CARPET, "queiros@estgoh.pt", "166005", true));
            Members.add(new jMember(3, "Paulo Vieira", enumSurface.GRASS, "paulo@estgoh.pt", "166004", false));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = sdf.parse("20-03-2016");
            Date date2 = sdf.parse("25-03-2016");
            Dates.add(new jDate(date1, date2, "Easter Break"));
            
            Date date3 = sdf.parse("01-03-2016");
            Date date4 = sdf.parse("31-12-2016");
            Timetables.add(new jTimetable(1, date3, date4, "08:00", "20:00", true));
            Timetables.add(new jTimetable(2, date3, date4, "16:00", "24:00", false));
            Timetables.add(new jTimetable(3, date3, date4, "08:00", "20:00", true));
            Timetables.add(new jTimetable(4, date3, date4, "07:00", "14:00", false));
            Timetables.add(new jTimetable(5, date3, date4, "08:00", "18:00", true));
            Timetables.add(new jTimetable(6, date3, date4, "14:00", "20:00", false));
            
            Date date5 = sdf.parse("01-04-2016");
            Date date6 = sdf.parse("31-03-2016");
            Reservations.add(new jReservations(date5, "08:00", 1, 1, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date5, "09:00", 1, 1, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date5, "10:00", 1, 1, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date5, "14:00", 1, 1, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date5, "15:00", 1, 1, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date6, "07:00", 3, 4, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date6, "09:00", 3, 4, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date6, "10:00", 3, 4, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date6, "13:00", 3, 4, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
            Reservations.add(new jReservations(date6, "14:00", 3, 4, enumReservationStatus.RESERVED, enumEventType.BOOKING, enumEventOrigin.EXTERNAL));
        }

        public static jCourt getCourt(int index) {
            return(Courts.get(index));
        }
        
        public static void removeCourt(int index) {
            Courts.remove(index);
        }
         
        public static void appendCourt(jCourt court) {
            Courts.add(court);
        }
        
         public static void editCourt(int index, jCourt court) {
            Courts.set(index, court);
        }
         
        public static jMember getMember(int index) {
            return(Members.get(index));
        }
        
        public static void removeMember(int index) {
            Members.remove(index);
        }
         
        public static void appendMember(jMember member) {
            Members.add(member);
        }
        
        public static void editMember(int index, jMember member) {
            Members.set(index, member);
        }
        
        public static void appendDate(jDate dates) {
            Dates.add(dates);
        }
        
        public static void appendTimetable(jTimetable timetable) {
            Timetables.add(timetable);
        }
        
        public static void appendReservation(jReservations reservation) {
            Reservations.add(reservation);
        }
}
