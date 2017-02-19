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

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.ren.planning.domain.CommonCode;
import com.ge.ren.planning.dto.CommonCodeDto;

/**
 *
 * @author 502585286
 */
@Service("CommonCodeEntityDtoConverter")
public class CommonCodeEntityDtoConverter implements IEntityDtoConverter<CommonCode, CommonCodeDto> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommonCodeDto convertDomainEntityToDto(CommonCode commonCode) {
		CommonCodeDto commonCodeDto = modelMapper.map(commonCode, CommonCodeDto.class);
		return commonCodeDto;
	}

	@Override
	public CommonCode convertDtoToDomainEntity(CommonCodeDto commonCodeDto) {
		CommonCode commonCode = modelMapper.map(commonCodeDto, CommonCode.class);
		return commonCode;
	}

}
