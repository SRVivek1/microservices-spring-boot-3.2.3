/**
 * 
 */
package com.srvivek.sboot.bean;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * User bean
 */
@Schema(description = "User details.")
public record PersonV2(@Schema(description = "Name representation.") Name name) {

}
