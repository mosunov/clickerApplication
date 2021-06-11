package ru.task.clickerapplication.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "click")
public class ClickerEntity {
        @Id
        private Long id;
        private String counter;

        public ClickerEntity(String counter) {
            this.counter = counter;
        }

        public ClickerEntity() {}
    }
