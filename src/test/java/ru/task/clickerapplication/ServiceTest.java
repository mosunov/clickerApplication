package ru.task.clickerapplication;

import org.junit.After;
import org.junit.Test;
import ru.task.clickerapplication.repository.ClickerEntity;
import ru.task.clickerapplication.repository.ClickerRepository;
import ru.task.clickerapplication.service.IncrementService;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

public class ServiceTest {
    private final IncrementService incrementService;
    private final ClickerRepository clickerRepository;

    {
        clickerRepository = mock(ClickerRepository.class);
        incrementService = new IncrementService(clickerRepository);
    }

    public void init(String counter){
        ClickerEntity clicker = new ClickerEntity();
        clicker.setCounter(counter);
        clicker.setId(1L);
        when(clickerRepository.findById(1L)).thenReturn(Optional.of(clicker));
        when(clickerRepository.save(clicker)).then(returnsFirstArg());
    }
    @After
    public void after(){
        reset(clickerRepository);
    }

    @Test
    public void getCounterTest() throws Exception {
        String expected = "123";
        init(expected);
        String actual = incrementService.getCounter();
        assertEquals(expected,actual);
    }
    @Test
    public void incrementTest(){
        BigInteger initial = BigInteger.valueOf(123L);
        String expected = initial.add(BigInteger.ONE).toString();
        init(initial.toString());
        String actual = incrementService.increment();
        assertEquals(expected,actual);
    }

    @Test
    public void incrementLongOverflowTest(){
        BigInteger initial = BigInteger.valueOf(Long.MAX_VALUE);
        String expected = initial.add(BigInteger.ONE).toString();
        init(initial.toString());
        String actual = incrementService.increment();
        assertEquals(expected,actual);
    }

    @Test
    public void incrementLongOverflowNegativeTest(){
        BigInteger initial = BigInteger.valueOf(Long.MIN_VALUE);
        String expected = initial.add(BigInteger.ONE).toString();
        init(initial.toString());
        String actual = incrementService.increment();
        assertEquals(expected,actual);
    }

    @Test
    public void getLongOverflowTest(){
        BigInteger expected = BigInteger.valueOf(Long.MAX_VALUE);
        init(expected.toString());
        String actual = incrementService.getCounter();
        assertEquals(expected.toString(),actual);
    }

    @Test
    public void getLongOverflowNegativeTest(){
        BigInteger expected = BigInteger.valueOf(Long.MIN_VALUE);
        init(expected.toString());
        String actual = incrementService.getCounter();
        assertEquals(expected.toString(),actual);
    }

}
