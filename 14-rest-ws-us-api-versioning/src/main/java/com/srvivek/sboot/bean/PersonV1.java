/**
 * 
 */
package com.srvivek.sboot.bean;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * User bean
 */
@Schema(description = "User details.")
public record PersonV1(@Schema(description = "Full Name") String name) {

}
