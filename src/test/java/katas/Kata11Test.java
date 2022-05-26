package katas;

import katas.sofka.JulianCamilo.Kata11;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata11Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata11.execute(), equalTo(4));
    }
}
