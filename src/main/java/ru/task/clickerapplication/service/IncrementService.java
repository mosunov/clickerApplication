package ru.task.clickerapplication.service;


import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.task.clickerapplication.repository.ClickerEntity;
import ru.task.clickerapplication.repository.ClickerRepository;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class IncrementService implements ClickService {

    private static final Long COUNTER_ID = 1L;
    private final ClickerRepository repository;

    @Transactional
    @NotNull
    @Override
    public String getCounter() {
        return findOrCreate().getCounter();
    }

    @Transactional
    @NotNull
    @Override
    public String increment() {
        ClickerEntity clickHolder = findOrCreate();
        String newValue = new BigInteger(clickHolder.getCounter()).add(BigInteger.ONE).toString();
        clickHolder.setCounter(newValue);
        return repository.save(clickHolder).getCounter();
    }

    private ClickerEntity findOrCreate() {
        return repository.findById(COUNTER_ID).orElseGet(this::createCounter);
    }

    private ClickerEntity createCounter() {
        ClickerEntity clicker = new ClickerEntity();
        clicker.setId(COUNTER_ID);
        clicker.setCounter(BigInteger.ZERO.toString());
        return repository.save(clicker);
    }

}
