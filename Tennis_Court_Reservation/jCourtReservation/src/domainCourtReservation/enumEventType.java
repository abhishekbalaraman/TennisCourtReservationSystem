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
public enum enumEventType {
    BOOKING {
            @Override
            public String toString() {
                return "BOOKING";
            }
    },
    MAINTENANCE {
            @Override
            public String toString() {
                return "MAINTENANCE";
            }
    },
    COUCHING {
            @Override
            public String toString() {
                return "COUCHING";
            }
    },
    COMPETITION {
            @Override
            public String toString() {
                return "COMPETITION";
            }
    },
    CLOSURE {
            @Override
            public String toString() {
                return "CLOSURE";
            }
    },
    UNFORSEEN {
            @Override
            public String toString() {
                return "UNFORSEEN";
            }
    },
    OTHER {
            @Override
            public String toString() {
                return "OTHER";
            }
    }
}
