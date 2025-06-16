package com.alucom.demo.services;

import com.alucom.demo.entities.Tasks;
import com.alucom.demo.repositories.TasksRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    private final TasksRepository _tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this._tasksRepository = tasksRepository;
    }

    public List<Tasks> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "priority").and(
            Sort.by(Sort.Direction.ASC, "title")
        );

        return _tasksRepository.findAll(sort);
    }

    public List<Tasks> create(Tasks task) {
        _tasksRepository.save(task);

        return this.list();
    }

    public List<Tasks> update(Tasks task) {
        _tasksRepository.save(task);

        return this.list();
    }

    public List<Tasks> delete(Long id) {
        _tasksRepository.deleteById(id);

        return this.list();
    }
}
