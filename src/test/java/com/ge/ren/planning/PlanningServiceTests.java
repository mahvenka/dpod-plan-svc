package com.ge.ren.planning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.ge.ren.planning.dto.converters.CommonCodeEntityDtoConverter;
import com.ge.ren.planning.dto.converters.TaskEntityDtoConverter;
import com.ge.ren.planning.dto.converters.TaskRecurrenceDetailsDtoConverter;
import com.ge.ren.planning.dto.converters.TaskStatusDtoConverter;
import com.ge.ren.planning.repository.ICommonCodeRepository;
import com.ge.ren.planning.repository.TaskRecurrenceDetailsRepository;
import com.ge.ren.planning.repository.TaskRepository;
import com.ge.ren.planning.repository.TaskStatusRepository;
import com.ge.ren.planning.constants.PlanningErrorCodes;
import com.ge.ren.planning.constants.RecurrenceEnum;
import com.ge.ren.planning.constants.RecurrenceTypeEnum;
import com.ge.ren.planning.constants.TaskStatusEnum;
import com.ge.ren.planning.domain.CommonCode;
import com.ge.ren.planning.domain.Task;
import com.ge.ren.planning.domain.TaskRecurrenceDetails;
import com.ge.ren.planning.domain.TaskStatus;
import com.ge.ren.planning.dto.AssetPodConfigDto;
import com.ge.ren.planning.dto.CommonCodeDto;
import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskPriorityDto;
import com.ge.ren.planning.dto.TaskRecurrenceDetailsDto;
import com.ge.ren.planning.dto.TaskStatusDto;
import com.ge.ren.planning.domain.TaskType;
import com.ge.ren.planning.dto.TaskTypeDto;
import com.ge.ren.planning.dto.converters.TaskTypeEntityDtoConverter;
import com.ge.ren.planning.repository.TaskTypeRepository;
import com.ge.ren.planning.service.impl.PlanningServiceImpl;
import com.ge.ren.planning.util.PlanningUtil;
import com.ge.ren.planning.validators.PlanningValidator;

public class PlanningServiceTests {

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
	
	@InjectMocks
	private PlanningServiceImpl planningServiceImpl;
	
	private TaskType taskType;
	private TaskTypeDto taskTypeDto;
	private CommonCodeDto commonCodeDto;
	private CommonCode commonCode;
	private Task task;
	private AssetPodConfigDto assetPodConfig;
	private TaskStatusDto taskStatusDto;
	private TaskPriorityDto taskPriorityDto;
	private TaskDto taskDto;
	private TaskStatus taskStatus;
	private TaskRecurrenceDetailsDto taskRecurrenceDetailsDto;
	private TaskRecurrenceDetails taskRecurrenceDetails;
	
	@Mock
	private TaskTypeRepository tasTypeRepo;
	
	@Mock
	private TaskTypeEntityDtoConverter taskTypeEntityDtoConverter;
	
	@Mock
	private TaskStatusDtoConverter taskStatusDtoConverter;
	
	@Mock
	private TaskRecurrenceDetailsDtoConverter taskRecurrenceDetailsDtoConverter;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private TaskRepository taskRepository;
	
	@Mock
	private TaskStatusRepository taskStatusRepository;
	
	@Mock
	private TaskEntityDtoConverter taskEntityDtoConverter;
	
	@Mock
	private TaskRecurrenceDetailsRepository taskRecurrenceDetailsRepository;
	
	@Mock
	private ICommonCodeRepository commonCodeRepo;

	@Mock
	private CommonCodeEntityDtoConverter commonCodeConverter;
	
	@Mock
	private PlanningValidator planningValidator;
	
	@Mock
	private PlanningUtil planningUtil;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		prepareTaskType();
		prepareCommonCode();
		prepareTask();
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
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
	public void testFetchTaskTypeByUserRoleIdForValidInput() {
		
		List<TaskType> taskTypeList = new ArrayList<TaskType>();
		taskTypeList.add(taskType);
		List<TaskTypeDto> taskTypeDtoList;
		Mockito.when(tasTypeRepo.fetchTaskTypeByUserRoleId(new Long(1))).thenReturn(taskTypeList);
		Mockito.when(taskTypeEntityDtoConverter.convertDomainEntityToDto(taskType)).thenReturn(taskTypeDto);
		taskTypeDtoList = planningServiceImpl.fetchTaskTypeByUserRoleId(new Long(1));
		assertNotNull("Errror: Returned Object is empty", taskTypeDtoList);
		assertEquals(new Long(12), taskTypeDtoList.get(0).getTaskTypeId());
		assertEquals(new Long(10), taskTypeDtoList.get(0).getDisplayOrder());
		assertEquals("system", taskTypeDtoList.get(0).getCreatedBy());
		assertEquals(new Boolean("True"), taskTypeDtoList.get(0).getIsActive());
		assertEquals("MCCE", taskTypeDtoList.get(0).getTaskTypeNameDefault());
		
	}
	
	
	private void prepareCommonCode() {

		commonCode = new CommonCode();
		commonCode.setdropdownType("TASK_PRIORITY");
		commonCode.setdropdownCode("1");
		commonCode.setdropdownValue("HIGH-FR");
		commonCode.setlanguageCode("FR");
		commonCodeDto = new CommonCodeDto();
		commonCodeDto.setdropdownType("TASK_PRIORITY");
		commonCodeDto.setdropdownCode("1");
		commonCodeDto.setdropdownValue("HIGH-FR");
		commonCodeDto.setlanguageCode("FR");
	}
	
	
	@Test
	public void testFindAllCodes() {

		List<CommonCode> commonCodeList = new ArrayList<CommonCode>();
		commonCodeList.add(commonCode);
		List<CommonCodeDto> commonCodeDtoList;
		Mockito.when(commonCodeRepo.findByDropdownTypeAndLanguageCode("TASK_PRIORITY", "FR")).thenReturn(commonCodeList);
		Mockito.when(commonCodeConverter.convertDomainEntityToDto(commonCode)).thenReturn(commonCodeDto);
		commonCodeDtoList = planningServiceImpl.findAllCodes("TASK_PRIORITY", "FR");
		assertNotNull("Errror: Returned Object is empty", commonCodeDtoList);
		assertEquals("HIGH-FR", commonCodeDtoList.get(0).getdropdownValue());
		assertEquals("1", commonCodeDtoList.get(0).getdropdownCode());

	}


	@Test
	public void testFindCode() {

		CommonCodeDto dto;
		Mockito.when(commonCodeRepo.findByDropdownTypeAndDropdownCodeAndLanguageCode("TASK_PRIORITY","1","FR")).thenReturn(commonCode);
		Mockito.when(commonCodeConverter.convertDomainEntityToDto(commonCode)).thenReturn(commonCodeDto);
		dto = planningServiceImpl.findCode("TASK_PRIORITY","1","FR");
		assertNotNull("Errror: Returned Object is empty", dto);
		assertEquals("HIGH-FR", dto.getdropdownValue());
		assertEquals("1", dto.getdropdownCode());
		assertEquals("TASK_PRIORITY", dto.getdropdownType());

	}
	
	private void prepareTask() {
		task = new Task();
		task.setTaskId(new Long(1));
		task.setAssetId(new Long(1));
		task.setIsActive(new Boolean("True"));
		task.setCreatedBy("system");
		task.setIsPodTask(new Boolean("True"));
		task.setPartDetails("PartDetails");
		task.setNumberOfTechRequired(new Integer(10));
		
		taskStatus = new TaskStatus();
		taskStatus.setTaskStatusId(new Long(1));
		taskStatus.setTaskStatusId(new Long(1));
		taskStatus.setTaskStatusNameDefault("COMPLETED");
		taskStatus.setIsActive(new Boolean("True"));
		taskStatus.setCreatedBy("system");
		taskStatus.setCreatedOn(LocalDateTime.now());
		taskStatus.setLastUpdatedBy("System");
		taskStatus.setLastUpdatedOn(LocalDateTime.now());
		
		taskRecurrenceDetails = new TaskRecurrenceDetails();
		taskRecurrenceDetails.setTaskId(new Long(1));
		taskRecurrenceDetails.setTaskRecurrenceId(new Long(1));
		taskRecurrenceDetails.setIsActive(new Boolean("True"));
		taskRecurrenceDetails.setRecurrence("4");
		taskRecurrenceDetails.setRecurrenceCycle("recure");
		taskRecurrenceDetails.setRecurrenceEndByCount(new Integer(4));
		taskRecurrenceDetails.setRecurrenceEndByDate(LocalDate.now());
		taskRecurrenceDetails.setRecurrenceType("Other");
		
		taskDto = new TaskDto();
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(new Long(1));
		taskDto.setAssetIds(list);
		taskDto.setTaskId(new Long(1));
		taskDto.setAssetId(new Long(1));
		taskDto.setCreatedBy("system");
		taskDto.setCreatedOn(LocalDateTime.now());
		taskDto.setLastUpdatedBy("system");
		taskDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setIsActive(new Boolean("True"));
		taskDto.setIsPodTask(new Boolean("True"));
		taskDto.setPartDetails("PartDetails");
		taskDto.setNumberOfTechRequired(new Integer(10));
		taskDto.setValid(new Boolean("True"));
		taskDto.setTaskCurrentStatusId(new Long(1));
		taskDto.setTaskActualDurationHrs(new Long(10));
		taskDto.setTaskActualDurationMins(new Long(10));
		taskDto.setTaskEstimatedDurationHrs(new Long(20));
		taskDto.setTaskEstimatedDurationMins(new Long(30));
		taskDto.setTaskExternalNotes("Notes");
		taskDto.setTaskResolutionNotes("system");
		taskDto.setTaskInternalNotes("Notes");
		taskDto.setTaskDescription("Description");
		taskDto.setTaskParentId(new Long(1));
		taskDto.setTaskLocationAtAsset(new Integer(10));
		taskDto.setTaskAddedOn(LocalDateTime.of(2017, 1, 17, 00, 00));
		taskDto.setTaskDueOn(LocalDateTime.of(2017, 1, 20, 00, 00));
		taskDto.setTaskCompletedOn(LocalDateTime.now());
		taskDto.setTaskComponentAtSection(new Long(1));
		
		assetPodConfig = new AssetPodConfigDto();
		assetPodConfig.setAssetPodConfigId(new Long(1));
		assetPodConfig.setAssetId(new Long(10));
		assetPodConfig.setAssetPodPriorityOrder(new Long(10));
		assetPodConfig.setIsActive(new Boolean("True"));
		assetPodConfig.setPodDate(LocalDate.now());
		assetPodConfig.setLastUpdatedBy("system");
		assetPodConfig.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setAssetPodConfig(assetPodConfig);
		
		taskStatusDto = new TaskStatusDto();
		taskStatusDto.setTaskStatusId(new Long(1));
		taskStatusDto.setTaskStatusNameDefault("NCED");
		taskStatusDto.setIsActive(new Boolean("True"));
		taskStatusDto.setCreatedBy("system");
		taskStatusDto.setCreatedOn(LocalDateTime.now());
		taskStatusDto.setLastUpdatedBy("System");
		taskStatusDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setTaskStatus(taskStatusDto);
		
		taskPriorityDto = new TaskPriorityDto();
		taskPriorityDto.setTaskPriorityId(new Long(1));
		taskPriorityDto.setTaskPriorityOrder(new Integer(10));
		taskPriorityDto.setTenantId(new Long(1));
		taskPriorityDto.setIsActive(new Boolean("True"));
		taskPriorityDto.setTaskPriorityNameDefault("system");
		taskDto.setTaskPriority(taskPriorityDto);
		
		taskTypeDto = new TaskTypeDto();
		taskTypeDto.setTenantId(new Long(1));
		taskTypeDto.setTaskTypeId(new Long(12));
		taskTypeDto.setTaskTypeNameDefault("MCCE");
		taskTypeDto.setIsActive(new Boolean("True"));
		taskTypeDto.setDisplayOrder(new Long(10));
		taskTypeDto.setCreatedBy("system");
		taskTypeDto.setCreatedOn(LocalDateTime.now());
		taskTypeDto.setLastUpdatedBy("system");
		taskTypeDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setTaskType(taskTypeDto);
		
		taskRecurrenceDetailsDto = new TaskRecurrenceDetailsDto();
		taskRecurrenceDetailsDto.setTaskId(new Long(1));
		taskRecurrenceDetailsDto.setTaskRecurrenceId(new Long(1));
		taskRecurrenceDetailsDto.setIsActive(new Boolean("True"));
		taskRecurrenceDetailsDto.setRecurrence("4");
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(new Integer(4));
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(LocalDate.now());
		taskRecurrenceDetailsDto.setRecurrenceType("Other");
		taskDto.setTaskRecurrenceDetailsDto(taskRecurrenceDetailsDto);
		taskDto.setTaskSectionAtLocation(new Long(10));
		
	}
	
	@Test
 	public void testCreateAssetTaskWithValidDataWithoutRecurrence(){
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		
		taskDto.setTaskRecurrenceDetailsDto(null);
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNull("Errror: Returned Object is not empty", result.getErrorDetails());
		assertEquals(new Long(1), result.getAssetId());
		assertEquals("system", result.getCreatedBy());
		assertEquals(new Boolean("True"), result.getIsActive());
		assertEquals("PartDetails", result.getPartDetails());
		assertEquals("system", result.getTaskPriority().getTaskPriorityNameDefault());
		
		assertEquals(LocalDateTime.of(2017, 1, 17, 00, 00), result.getTaskAddedOn());
		assertEquals(LocalDateTime.of(2017, 1, 20, 00, 00), result.getTaskDueOn());
		
	}
	
	@Test
	public void testCreateSiteTaskWithValidValuesWithoutRecurrence(){
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateSiteTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		
		taskDto.setTaskRecurrenceDetailsDto(null);
		taskDto.setTaskCategory("SITE");
		TaskDto siteResult = planningServiceImpl.createSiteTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", siteResult);
		assertNull("Errror: Returned Object is not empty", siteResult.getErrorDetails());
		assertEquals(new Long(1), siteResult.getAssetId());
		assertEquals("system", siteResult.getCreatedBy());
		assertEquals(new Boolean("True"), siteResult.getIsActive());
		assertEquals("PartDetails", siteResult.getPartDetails());
		assertEquals("system", siteResult.getTaskPriority().getTaskPriorityNameDefault());
		
		assertEquals(LocalDateTime.of(2017, 1, 17, 00, 00), siteResult.getTaskAddedOn());
		assertEquals(LocalDateTime.of(2017, 1, 20, 00, 00), siteResult.getTaskDueOn());
	}
	
	private void constructInvalidTaskDto() {
		taskDto.setAssetIds(null);
		taskDto.setTaskPriority(null);
		if(PlanningUtil.isNotNull(taskDto.getTaskPriority())){
		   taskDto.getTaskPriority().setTaskPriorityNameDefault(null);
		}
		taskDto.setTaskEstimatedDurationHrs(null);
		taskDto.setTaskEstimatedDurationMins(null);
		taskDto.setTaskAddedOn(LocalDateTime.of(2017, 1, 25, 00, 00));
		taskDto.setTaskDueOn(LocalDateTime.of(2017, 1, 20, 00, 00));
	}
	
	@Test
	public void testCreateAssetTaskWithInvalidData(){
		
		constructInvalidTaskDto();
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_DUE_ON_DATE_ADD_ON_DATE, result.getErrorDetails()[2].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ATLEAST_ONE_ASSET, result.getErrorDetails()[3].getErrorCode());
	
	}
	
	@Test
	public void testCreateSiteTaskWithInvalidData(){
		
		constructInvalidTaskDto();
		
		taskDto.setTaskCategory("ASSET");
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateSiteTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createSiteTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is not empty", result.getErrorDetails());
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_DUE_ON_DATE_ADD_ON_DATE, result.getErrorDetails()[2].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_CATEGORY_INVALID, result.getErrorDetails()[3].getErrorCode());
	
	}
	
	@Test
	public void testCreateAssetTaskWithRecurrenceWithValidData(){
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNull("Errror: Returned Object is empty", result.getErrorDetails());
		assertEquals(new Long(1), result.getAssetId());
		assertEquals("system", result.getCreatedBy());
		assertEquals(new Boolean("True"), result.getIsActive());
		assertEquals("PartDetails", result.getPartDetails());
		assertEquals("system", result.getTaskPriority().getTaskPriorityNameDefault());
		
		assertEquals("4", result.getTaskRecurrenceDetailsDto().getRecurrence());

	}
	
    private void prepareInvalidTaskRecurrenceDetails() {
		
    	task = new Task();
		task.setTaskId(new Long(1));
		task.setAssetId(new Long(1));
		task.setIsActive(new Boolean("True"));
		task.setCreatedBy("system");
		task.setIsPodTask(new Boolean("True"));
		task.setPartDetails("PartDetails");
		task.setNumberOfTechRequired(new Integer(10));
		
		taskStatus = new TaskStatus();
		taskStatus.setTaskStatusId(new Long(1));
		taskStatus.setTaskStatusId(new Long(1));
		taskStatus.setTaskStatusNameDefault("COMPLETED");
		taskStatus.setIsActive(new Boolean("True"));
		taskStatus.setCreatedBy("system");
		taskStatus.setCreatedOn(LocalDateTime.now());
		taskStatus.setLastUpdatedBy("System");
		taskStatus.setLastUpdatedOn(LocalDateTime.now());
		
		taskDto = new TaskDto();
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(new Long(1));
		taskDto.setAssetIds(list);
		taskDto.setTaskId(new Long(1));
		taskDto.setAssetId(new Long(1));
		taskDto.setCreatedBy("system");
		taskDto.setCreatedOn(LocalDateTime.now());
		taskDto.setLastUpdatedBy("system");
		taskDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setIsActive(new Boolean("True"));
		taskDto.setIsPodTask(new Boolean("True"));
		taskDto.setPartDetails("PartDetails");
		taskDto.setNumberOfTechRequired(new Integer(10));
		taskDto.setValid(new Boolean("True"));
		taskDto.setTaskCurrentStatusId(new Long(1));
		taskDto.setTaskActualDurationHrs(new Long(10));
		taskDto.setTaskActualDurationMins(new Long(10));
		taskDto.setTaskEstimatedDurationHrs(new Long(20));
		taskDto.setTaskEstimatedDurationMins(new Long(30));
		taskDto.setTaskExternalNotes("Notes");
		taskDto.setTaskResolutionNotes("system");
		taskDto.setTaskInternalNotes("Notes");
		taskDto.setTaskDescription("Description");
		taskDto.setTaskParentId(new Long(1));
		taskDto.setTaskLocationAtAsset(new Integer(10));
		//taskDto.setTaskAddedOn(LocalDateTime.of(2017, 1, 17, 00, 00));
		//taskDto.setTaskDueOn(LocalDateTime.of(2017, 1, 20, 00, 00));
		taskDto.setTaskCompletedOn(LocalDateTime.now());
		taskDto.setTaskComponentAtSection(new Long(1));
		
		assetPodConfig = new AssetPodConfigDto();
		assetPodConfig.setAssetPodConfigId(new Long(1));
		assetPodConfig.setAssetId(new Long(10));
		assetPodConfig.setAssetPodPriorityOrder(new Long(10));
		assetPodConfig.setIsActive(new Boolean("True"));
		assetPodConfig.setPodDate(LocalDate.now());
		assetPodConfig.setLastUpdatedBy("system");
		assetPodConfig.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setAssetPodConfig(assetPodConfig);
		
		taskStatusDto = new TaskStatusDto();
		taskStatusDto.setTaskStatusId(new Long(1));
		taskStatusDto.setTaskStatusNameDefault("NCED");
		taskStatusDto.setIsActive(new Boolean("True"));
		taskStatusDto.setCreatedBy("system");
		taskStatusDto.setCreatedOn(LocalDateTime.now());
		taskStatusDto.setLastUpdatedBy("System");
		taskStatusDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setTaskStatus(taskStatusDto);
		
		taskPriorityDto = new TaskPriorityDto();
		taskPriorityDto.setTaskPriorityId(new Long(1));
		taskPriorityDto.setTaskPriorityOrder(new Integer(10));
		taskPriorityDto.setTenantId(new Long(1));
		taskPriorityDto.setIsActive(new Boolean("True"));
		taskPriorityDto.setTaskPriorityNameDefault("system");
		taskDto.setTaskPriority(taskPriorityDto);
		
		taskTypeDto = new TaskTypeDto();
		taskTypeDto.setTenantId(new Long(1));
		taskTypeDto.setTaskTypeId(new Long(12));
		taskTypeDto.setTaskTypeNameDefault("MCE");
		taskTypeDto.setIsActive(new Boolean("True"));
		taskTypeDto.setDisplayOrder(new Long(10));
		taskTypeDto.setCreatedBy("system");
		taskTypeDto.setCreatedOn(LocalDateTime.now());
		taskTypeDto.setLastUpdatedBy("system");
		taskTypeDto.setLastUpdatedOn(LocalDateTime.now());
		taskDto.setTaskType(taskTypeDto);
		
    	//taskDto.setAssetIds(null);
		taskDto.setTaskPriority(null);
		taskDto.setTaskEstimatedDurationHrs(null);
		taskDto.setTaskEstimatedDurationMins(null);
		taskDto.setTaskAddedOn(LocalDateTime.of(2017, 1, 17, 00, 00));
		taskDto.setTaskDueOn(LocalDateTime.of(2017, 1, 20, 00, 00));
		taskRecurrenceDetails = new TaskRecurrenceDetails();
		taskRecurrenceDetails.setTaskId(new Long(1));
		taskRecurrenceDetails.setTaskRecurrenceId(new Long(1));
		taskRecurrenceDetails.setIsActive(new Boolean("True"));
		taskRecurrenceDetails.setRecurrence("4");
		taskRecurrenceDetails.setRecurrenceCycle("recure");
		taskRecurrenceDetails.setRecurrenceEndByCount(null);
		taskRecurrenceDetails.setRecurrenceEndByDate(LocalDate.now());
		taskRecurrenceDetails.setRecurrenceType(RecurrenceTypeEnum.ENDBYOCCURENCE.name());
		
		taskRecurrenceDetailsDto = new TaskRecurrenceDetailsDto();
		taskRecurrenceDetailsDto.setTaskId(new Long(1));
		taskRecurrenceDetailsDto.setTaskRecurrenceId(new Long(1));
		taskRecurrenceDetailsDto.setIsActive(new Boolean("True"));
		taskRecurrenceDetailsDto.setRecurrence("4");
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(LocalDate.now());
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYOCCURENCE.name());
		taskDto.setTaskRecurrenceDetailsDto(taskRecurrenceDetailsDto);
				
	}
	
	@Test
	public void testCreateAssetTaskForMCETypeWithRecurrence(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertEquals("4", result.getTaskRecurrenceDetailsDto().getRecurrence());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_RECURRENCE_NOT_APPLICABLE_FOR_THIS_TASK, result.getErrorDetails()[2].getErrorCode());
		
	}
	
	
	@Test
	public void testCreateAssetTaskForEndByOccuranceRecurrenceWithNullEndByCount(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(LocalDate.now());
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYOCCURENCE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYOCCURENCE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		assertEquals("4", result.getTaskRecurrenceDetailsDto().getRecurrence());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_OCCURRENCE_MANDATORY_FOR_END_AFTER_RECURRENCE, result.getErrorDetails()[2].getErrorCode());
		
	}
	
	@Test
	public void testCreateAssetTaskForEndByDateRecurrenceWithInvalidData(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(LocalDate.of(2017, 1, 17));
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		assertEquals("4", result.getTaskRecurrenceDetailsDto().getRecurrence());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_END_BY_DATE_SHOULD_NOT_BE_PAST_DATE, result.getErrorDetails()[2].getErrorCode());
		
	}
	
	@Test
	public void testCreateAssetTaskForEndByDateRecurrenceWithNullData(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(null);
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		assertEquals("4", result.getTaskRecurrenceDetailsDto().getRecurrence());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE, result.getErrorDetails()[2].getErrorCode());
		
	}
	
	@Test
	public void testCreateAssetTaskForCustomRecurrenceWithInvalidData(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle("re0cure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(null);
		taskRecurrenceDetailsDto.setRecurrence(RecurrenceEnum.CUSTOM.getRecurrenceEnumCode());
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE, result.getErrorDetails()[2].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_INVALID, result.getErrorDetails()[3].getErrorCode());
		
	}
	
	@Test
	public void testCreateAssetTaskForCustomWithRecurrenceData(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle("recure");
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(null);
		taskRecurrenceDetailsDto.setRecurrence(RecurrenceEnum.CUSTOM.getRecurrenceEnumCode());
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE, result.getErrorDetails()[2].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_INVALID, result.getErrorDetails()[3].getErrorCode());
		
	}
	
	@Test
	public void testCreateAssetTaskForCustomRecurrenceWithNullRecurrenceCycle(){
      
		prepareInvalidTaskRecurrenceDetails();
		
		taskDto.getTaskType().setTaskTypeNameDefault("ETC");
		
		taskRecurrenceDetailsDto.setRecurrenceCycle(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByCount(null);
		taskRecurrenceDetailsDto.setRecurrenceEndByDate(null);
		taskRecurrenceDetailsDto.setRecurrence(RecurrenceEnum.CUSTOM.getRecurrenceEnumCode());
		taskRecurrenceDetailsDto.setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceType(RecurrenceTypeEnum.ENDBYDATE.name());
		taskDto.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(null);
		
		Mockito.when(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)).thenReturn(task);
		Mockito.when(taskEntityDtoConverter.convertDomainEntityToDto(task)).thenReturn(taskDto);
		
		Mockito.when(planningValidator.validateAssetTask(taskDto)).thenCallRealMethod();
		Mockito.when(taskStatusDtoConverter.convertDomainEntityToDto(taskStatus)).thenReturn(taskStatusDto);
		
		Mockito.when(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString())).thenReturn(taskStatus);
		
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetails)).thenReturn(taskRecurrenceDetailsDto);
		Mockito.when(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskRecurrenceDetailsDto)).thenReturn(taskRecurrenceDetails);
		
		Mockito.when(taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto))).thenReturn(task);
		Mockito.when(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))).thenReturn(taskRecurrenceDetails);
		
		TaskDto result = planningServiceImpl.createTask(taskDto);
		assertNotNull("Errror: Returned Object is empty", result);
		assertNotNull("Errror: Returned Object is empty", result.getTaskRecurrenceDetailsDto());
		assertNotNull("Errror: Returned Object is empty", result.getErrorDetails());
		
		assertEquals(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, result.getErrorDetails()[0].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY, result.getErrorDetails()[1].getErrorCode());
		assertEquals(PlanningErrorCodes.TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE, result.getErrorDetails()[2].getErrorCode());
		
		assertEquals(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_MANDATORY, result.getErrorDetails()[3].getErrorCode());
		
	}

}
