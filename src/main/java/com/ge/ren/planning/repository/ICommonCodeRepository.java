/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ge.ren.planning.domain.CommonCode;

/**
 *
 * @author 502585286
 */
public interface ICommonCodeRepository extends JpaRepository<CommonCode, Long> {

	List<CommonCode> findByDropdownTypeAndLanguageCode(String dropdownType, String languageCode);
	CommonCode findByDropdownTypeAndDropdownCodeAndLanguageCode(String dropdownType, String dropdownCode, String languageCode);

}
