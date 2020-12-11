package ru.mephi.elk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mephi.elk.service.CountEventService;

import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountEventServiceTest {

    private static CountEventService countEventService;

    @BeforeAll
    public static void init() {
        countEventService = new CountEventService();
    }

    @Test
    public void testTweetCount() {
        Supplier<Stream<Long>> inputStreamSupplier = () -> Stream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);

        Long expectedResult = inputStreamSupplier.get()
                .reduce(0L, Long::sum);

        inputStreamSupplier.get()
                .parallel()
                .forEach(count -> LongStream.rangeClosed(1L, count)
                            .forEach(val -> countEventService.incrementTwitCount()));

        Long result = countEventService.getAndResetTwitCount();
        assertEquals(expectedResult, result);
    }
}
