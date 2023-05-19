/**
*The Containment enum represents different containment levels for an SCP.
*/
package acs;

public enum Containment {
	SAFE, // Indicates the object is safely contained and poses no threat.
	EUCLID, // Indicates the object requires special containment procedures and poses a
			// moderate threat.
	KETER, // Indicates the object is highly dangerous and requires extreme containment
			// procedures.
	NEUTRALIZED, // Indicates the object has been neutralized and no longer poses a threat.
	PENDING, // Indicates the containment status is pending and under evaluation.
	EXPLAINED, // Indicates the containment status has been explained but not yet implemented.
	ESOTERIC; // Indicates the containment status is unknown or cannot be easily explained.
}
