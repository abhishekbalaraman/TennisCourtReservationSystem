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
public enum enumEventOrigin {
    INTERNAL {
            @Override
            public String toString() {
                return "INTERNAL";
            }
    },
    EXTERNAL {
            @Override
            public String toString() {
                return "EXTERNAL";
            }
    }, 
    ADMINISTRATIVE {
            @Override
            public String toString() {
                return "ADMINISTRATIVE";
            }
    }
}
