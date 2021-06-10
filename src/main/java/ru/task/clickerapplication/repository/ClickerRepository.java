package ru.task.clickerapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickerRepository extends JpaRepository<ClickerEntity,Long> {
}
