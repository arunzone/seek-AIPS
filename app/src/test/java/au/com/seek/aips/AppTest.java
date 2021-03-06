package au.com.seek.aips;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void shouldProcessTrafficReport() throws Exception {
    App app = new App();
    String text = tapSystemOut(() -> app.main(new String[]{}));

    assertThat(text, is("""
        Total number of cars: 398
                
        Number of cars by date
        2016-12-09 4
        2016-12-08 134
        2016-12-05 81
        2016-12-01 179
                
        Top 3 high traffic records
        2016-12-01T07:30:00 46
        2016-12-01T08:00:00 42
        2016-12-08T18:00:00 33
                
        Least traffic 3 contiguous records
        2016-12-01T15:00:00 9
        2016-12-01T15:30:00 11
        2016-12-01T23:30:00 0
        """));
  }
}
