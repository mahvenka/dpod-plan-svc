/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.dto.converters;

/**
 *
 * Generic interface for conversion of Domain Entity to Data Transfer Object and vice versa 
 *
 * @author Yessesvy 
 *
 * @param <DomainEntity> input domain entity object type
 * @param <Dto> input data transfer object type
 */
public interface IEntityDtoConverter<DomainEntity, Dto> {

    /**
     * Converts entity to dto.
     *
    */
    Dto convertDomainEntityToDto(DomainEntity domainentity);

    /**
     * Converts dto to entity.
     *
    */
    DomainEntity convertDtoToDomainEntity(Dto dto);

}

