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
public enum enumReservationStatus {
    AVAILABLE {
            @Override
            public String toString() {
                return "AVAILABLE";
            }
    },
    RESERVED {
            @Override
            public String toString() {
                return "RESERVED";
            }
    },
    UNAVAILABLE {
            @Override
            public String toString() {
                return "UNAVAILABLE";
            }
    },
    CANCELED {
            @Override
            public String toString() {
                return "CANCELED";
            }
    }
}
