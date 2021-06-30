package au.com.seek.aips.repository;

import static java.lang.String.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import au.com.seek.aips.entity.VehicleTraffic;

public class FileRepository {

  public static final String INPUT_FILE = "INPUT_FILE";

  public List<VehicleTraffic> read() {
    String fileName = fileName();
    try {
      Path path = Path.of(fileName);
      return Files.readAllLines(path).stream().map(line -> {
        String[] columns = line.split(" ");
        return new VehicleTraffic(
            LocalDateTime.parse(columns[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            Long.valueOf(columns[1]));
      }).collect(Collectors.toList());
    } catch (IOException e) {
      throw new InvalidInputFileException(format("Invalid input file: %s", fileName));
    }
  }

  private String fileName() {
    if (System.getenv().containsKey(INPUT_FILE)) {
      return System.getenv().get(INPUT_FILE);
    }
    return "src/test/resources/traffic_count.txt";
  }
}
