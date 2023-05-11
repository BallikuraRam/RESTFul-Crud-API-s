package com.crud.service;

import com.crud.payload.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto saveTask(long userId, TaskDto taskDto);

    public List<TaskDto> getAllTaskByUserId(long userId);

    public TaskDto getIndividualTask(long userId , long taskId);
    public void deleteTask(Long userId , Long taskId);
}
