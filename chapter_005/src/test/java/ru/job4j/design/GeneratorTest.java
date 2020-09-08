package ru.job4j.design;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.design.tdd.Generator;
import ru.job4j.design.tdd.UseGenerator;

import java.util.Map;

public class GeneratorTest {
    @Test
    public void whenCompleteExample() {
        Generator generator = new UseGenerator();
        String example = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Andrew",
                "subject", "you"
        );
        String out = generator.produce(example, map);
        Assert.assertThat(out, Is.is("I am a Andrew, Who are you?")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidException() {
        Generator generator = new UseGenerator();
        String example = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Andrew",
                "subject", null
        );
        String out = generator.produce(example, map);

    }
}
