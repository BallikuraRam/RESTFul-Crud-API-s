package com.crud.service;

import com.crud.exception.APIException;
import com.crud.exception.TaskNotFoundException;
import com.crud.exception.UserNotFoundException;
import com.crud.model.Task;
import com.crud.model.Users;
import com.crud.payload.TaskDto;
import com.crud.repository.TaskRepository;
import com.crud.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) {
        Users users = this.usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User Id %d is not present", userId))
        );
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(users); // after setting the user we are going to store the DB
        Task saveTask = this.taskRepository.save(task);
        return modelMapper.map(saveTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTaskByUserId(long userId) {
        this.usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User Id %d is not present", userId))
        );
        List<Task> taskList = this.taskRepository.findAllByTaskId(userId);

        return taskList.stream().map(
                task -> modelMapper.map(task, TaskDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TaskDto getIndividualTask(long userId, long taskId) {

        Users existUserId = this.usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User not found this id &d ", userId)));

        Task existTaskId = this.taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(String.format("Task not this id %d ", taskId)));

        if (existUserId.getUserId() != existTaskId.getUsers().getUserId()) {
            throw new APIException(String.format("taskId %d is not belongs to userId %d ",
                    userId, taskId));
        }
        return modelMapper.map(existTaskId, TaskDto.class);
    }

    @Override
    public void deleteTask(Long userId, Long taskId) {

        Users existUserId = this.usersRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User not found this id &d ", userId)));

        Task existTaskId = this.taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(String.format("Task not this id %d ", taskId)));

        if (existUserId.getUserId() != existTaskId.getUsers().getUserId()) {
            throw new APIException(String.format("taskId %d is not belongs to userId %d ",
                    userId, taskId));
        }
        this.taskRepository.deleteById(taskId);
    }
}
