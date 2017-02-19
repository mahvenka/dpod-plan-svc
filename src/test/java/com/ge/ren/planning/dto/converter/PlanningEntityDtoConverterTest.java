package com.ge.ren.planning.dto.converter;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.ge.ren.planning.domain.TaskType;
import com.ge.ren.planning.dto.TaskTypeDto;
import com.ge.ren.planning.dto.converters.TaskTypeEntityDtoConverter;

public class PlanningEntityDtoConverterTest {
	
    private TaskType taskType;
	
	private TaskTypeDto taskTypeDto;
	
	@InjectMocks
	private TaskTypeEntityDtoConverter taskTypeEntityDtoConverter;
	
	@Mock
	private ModelMapper modelMapper;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		prepareTaskType();
		
	}
	
	private void prepareTaskType() {
		taskType = new TaskType();
		taskType.setTaskTypeId(new Long(12));
		taskType.setDisplayOrder(new Long(10));
		taskType.setCreatedBy("system");
		taskType.setIsActive(new Boolean("True"));
		taskType.setTaskTypeNameDefault("MCCE");
		
		taskTypeDto = new TaskTypeDto();
		taskTypeDto.setTaskTypeId(new Long(12));
		taskTypeDto.setDisplayOrder(new Long(10));
		taskTypeDto.setCreatedBy("system");
		taskTypeDto.setIsActive(new Boolean("True"));
		taskTypeDto.setTaskTypeNameDefault("MCCE");
	}
	
	@Test
	public void testTaskTypeConvertDomainEntityToDto() {

		Mockito.when(modelMapper.map(taskType, TaskTypeDto.class)).thenReturn(taskTypeDto);
		TaskTypeDto taskTypeDto = taskTypeEntityDtoConverter.convertDomainEntityToDto(taskType);
		assertNotNull("Errror:Returned Object is empty", taskTypeDto);

	}
	
	@Test
	public void testTaskTypeConvertDtoToEntity() {
		Mockito.when(modelMapper.map(taskTypeDto, TaskType.class)).thenReturn(taskType);
		TaskType taskType = taskTypeEntityDtoConverter.convertDtoToDomainEntity(taskTypeDto);
		assertNotNull("Errror:Returned Object is empty", taskType);
	}
}

