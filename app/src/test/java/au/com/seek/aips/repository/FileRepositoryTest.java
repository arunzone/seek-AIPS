package au.com.seek.aips.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.hamcrest.core.IsIterableContaining;
import org.junit.jupiter.api.Test;

class FileRepositoryTest {
  @Test
  void shouldReturnDefaultFileContent() {
    FileRepository fileRepository = new FileRepository();
    List<VehicleTraffic> commands = fileRepository.read();

    assertThat(commands, IsIterableContaining.hasItem(
        new VehicleTraffic(LocalDateTime.of(2016, Month.DECEMBER, 1, 5, 0), 5L)));
  }

  @Test
  void shouldThrowExceptionWhenFileNotFound() {
    FileRepository fileRepository = new FileRepository();

    InvalidInputFileException invalidInputFileException = assertThrows(InvalidInputFileException.class, () -> {
      SystemLambda.withEnvironmentVariable(FileRepository.INPUT_FILE, "unavailable")
          .execute(() -> fileRepository.read());
    });

    assertThat(invalidInputFileException.getMessage(), is("Invalid input file: unavailable"));
  }

}
