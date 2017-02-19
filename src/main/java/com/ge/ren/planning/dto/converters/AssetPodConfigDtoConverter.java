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

import com.ge.ren.planning.domain.AssetPodConfig;
import com.ge.ren.planning.dto.AssetPodConfigDto;

/**
 *
 * @author Yessesvy
 */
@Service("AssetPodConfigDtoConverter")
public class AssetPodConfigDtoConverter implements IEntityDtoConverter<AssetPodConfig, AssetPodConfigDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssetPodConfigDto convertDomainEntityToDto(AssetPodConfig assetPodConfig) {
	AssetPodConfigDto assetPodConfigDto = modelMapper.map(assetPodConfig, AssetPodConfigDto.class);
	return assetPodConfigDto;
    }

    @Override
    public AssetPodConfig convertDtoToDomainEntity(AssetPodConfigDto assetPodConfigDto) {
	AssetPodConfig assetPodConfig = modelMapper.map(assetPodConfigDto, AssetPodConfig.class);
	return assetPodConfig;
    }

}
