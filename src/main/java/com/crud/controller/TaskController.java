package com.crud.controller;

import com.crud.payload.TaskDto;
import com.crud.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskService service;

    @PostMapping("/{taskId}/tasks")
    public ResponseEntity<TaskDto> saveNew(@PathVariable("taskId") long taskId,
                                           @RequestBody TaskDto taskDto) {
        TaskDto saveNewTask = this.service.saveTask(taskId, taskDto);
        logger.info("save new task based on Exist User : ");
        return new ResponseEntity<>(saveNewTask, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> findAllTaskById(@PathVariable("userId") long userId) {
        List<TaskDto> allTaskByUserId = service.getAllTaskByUserId(userId);
        logger.info("find All Tasks successfully  : " + allTaskByUserId.stream().count());
        return new ResponseEntity<>(allTaskByUserId, HttpStatus.FOUND);
    }

    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getIndividualTask(@PathVariable("userId") long userId,
                                                     @PathVariable("taskId") long taskId) {
        TaskDto individualTask = service.getIndividualTask(userId, taskId);
        logger.info("find Individual task name :  " + individualTask.getTaskName());
        return new ResponseEntity<>(individualTask, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteIndividualTask(@PathVariable("userId") long userId,
                                                       @PathVariable("taskId") long taskId) {
        this.service.deleteTask(userId, taskId);
        logger.info("successfully deleted Individual task name");
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }
}
