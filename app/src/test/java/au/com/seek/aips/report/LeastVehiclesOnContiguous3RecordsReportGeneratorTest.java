package au.com.seek.aips.report;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

class LeastVehiclesOnContiguous3RecordsReportGeneratorTest {

  @Test
  public void shouldReturnLeastTrafficFor3ContiguousRecords() {
    List<VehicleTraffic> vehicles = List.of(
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 0), 15L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 30), 25L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 14, 0), 13L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 14, 30), 12L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 15, 0), 10L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 15, 30), 20L));

    LeastVehiclesOnContiguous3RecordsReportGenerator reportGenerator = new LeastVehiclesOnContiguous3RecordsReportGenerator();
    List<VehicleTraffic> matchingVehicles = reportGenerator.findLeastTrafficOn3Contiguous(vehicles);

    MatcherAssert.assertThat(matchingVehicles, IsIterableContainingInOrder.contains(
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 14, 0), 13L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 14, 30), 12L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 15, 0), 10L)
    ));
  }
}