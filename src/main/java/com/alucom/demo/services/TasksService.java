package com.alucom.demo.services;

import com.alucom.demo.entities.Tasks;
import com.alucom.demo.repositories.TasksRepository;
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
        // Cria um objeto de ordenação (Sort)
        // Primeiro, ordena pela prioridade de forma decrescente (maior prioridade primeiro)
        Sort sort = Sort.by(Sort.Direction.DESC, "priority")
                // Depois, em caso de prioridades iguais, ordena por título em ordem crescente (A-Z)
                .and(Sort.by(Sort.Direction.ASC, "title"));

        return _tasksRepository.findAll(sort);
    }

    public List<Tasks> create(Tasks task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("O campo 'title' é obrigatório.");
        }

        _tasksRepository.save(task);

        return this.list();
    }

    public List<Tasks> update(Long id, Tasks task) {
        Tasks updateTask = _tasksRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        updateTask.setCompleted(task.isCompleted());
        updateTask.setPriority(task.getPriority());
        _tasksRepository.save(updateTask);

        return this.list();
    }

    public List<Tasks> delete(Long id) {
        _tasksRepository.deleteById(id);

        return this.list();
    }
}
