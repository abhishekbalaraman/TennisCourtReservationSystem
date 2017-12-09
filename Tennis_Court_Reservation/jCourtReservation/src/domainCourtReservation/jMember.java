/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainCourtReservation;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class jMember {

    /****** Atributes ******/
    private int memberID;
    private String name;
    private enumSurface surface;
    private String email;
    private String password;
    private Boolean status;

     
    /****** Methods ******/
    public static int findMember (int idMember) {
        for(int i = 0; i < dataCourtReservation.jCourtReservationArraylists.Members.size(); ++i) {
            if(dataCourtReservation.jCourtReservationArraylists.Members.get(i).memberID == idMember) return i;
        }
	return -1;
    }
    
    public static int newMember (jMember member) {
        dataCourtReservation.jCourtReservationArraylists.appendMember(member);
        return 0;
    }
    
    public static int modifyMember (int index, jMember member) {
        dataCourtReservation.jCourtReservationArraylists.editMember(index, member);
        return 0;
    }
	
    public static int validMember (jMember member)  {
        if (member.name == null || member.surface == null
            || member.email == null || member.password == null
            || member.status == null || member.name.isEmpty()
            || member.email.isEmpty() || member.password.isEmpty()) return -1;
        try {
            javax.mail.internet.InternetAddress emailAddr = new javax.mail.internet.InternetAddress(member.email);
            emailAddr.validate();        
        } catch (javax.mail.internet.AddressException ex) {
            return -1;
	}
        return 0;
    }
    
    public static enumErrorCode saveMember (int index, jMember member) {
        int i = 0;
        int err = validMember(member);
        if (err != 0) {
            return enumErrorCode.INF_INVALID;
        } 
        if (index >= 0)  {
            i = modifyMember(index, member);
        } else {
            i = newMember(member);
        }
        if (i == 0) {
            return enumErrorCode.OK;
        } else {
            return enumErrorCode.NOT_SAVE;
        }
    }
	
    public static enumErrorCode deleteMember (int index) {
	if (index >= 0)  {
            dataCourtReservation.jCourtReservationArraylists.removeMember(index);
            return enumErrorCode.OK;
	}
        return enumErrorCode.NOT_FOUND; 
    }
    
    public static int getMemberID (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).memberID;
    }
	
    public static String getName (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).name;
    }
         
    public static enumSurface getSurface (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).surface;
    }
	
    public static String getEmail (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).email;
    }
	
    public static String getPassword (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).password;
    }
	
    public static boolean getStatus (int index) {
        return dataCourtReservation.jCourtReservationArraylists.getMember(index).status;
    }
    
    public static String[] getMembersID() {
        String[] array = new String[dataCourtReservation.jCourtReservationArraylists.Members.size()];
        for(int i = 0; i < array.length; i++) {
            int j = dataCourtReservation.jCourtReservationArraylists.Members.get(i).memberID;
            array[i] = Integer.toString(j);
        }
        return array;
    }
    
    /****** Constructor ********/
    public jMember(int idMember, String nameMemb, enumSurface playground, String emailMemb, String passMemb, Boolean active)  {
        this.memberID = idMember;
        this.name = nameMemb;
        this.surface = playground;
        this.email = emailMemb;
        this.password = passMemb;
        this.status = active;
    }  
}
