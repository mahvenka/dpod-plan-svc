/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.util;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
*
* @author Yessesvy
*/
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {
	
    @Override
    public Time convertToDatabaseColumn(LocalTime locTime) {
    	return (locTime == null ? null : Time.valueOf(locTime));
    }

    @Override
    public LocalTime convertToEntityAttribute(Time sqlTime) {
    	return (sqlTime == null ? null : sqlTime.toLocalTime());
    }
}

