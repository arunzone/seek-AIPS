package au.com.seek.aips.report;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import au.com.seek.aips.entity.VehicleTraffic;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;


class TotalReportGeneratorTest {

  @Test
  public void shouldReturnTotalNumberOfCars() {
    TotalReportGenerator totalReportGenerator = new TotalReportGenerator();
    List<VehicleTraffic> vehicles = List.of(
        new VehicleTraffic(LocalDateTime.now(), 15L),
        new VehicleTraffic(LocalDateTime.now(), 25L));

    Long total = totalReportGenerator.totalOf(vehicles);

    assertThat(total, is(40L));
  }

}