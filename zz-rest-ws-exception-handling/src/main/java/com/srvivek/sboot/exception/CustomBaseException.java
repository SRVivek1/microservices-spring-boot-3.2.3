/**
 * 
 */
package com.srvivek.sboot.exception;

import java.util.Date;

/**
 * 
 */
public record CustomBaseException(Date timestamp, String msg, String details) {

}
