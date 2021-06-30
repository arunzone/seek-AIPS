package au.com.seek.aips.report;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

class TopMost3VehicleReportGeneratorTest {

  @Test
  public void shouldReturnTopMost3VehicleTraffic() {
    LocalDateTime timestamp = LocalDateTime.now();
    List<VehicleTraffic> vehicles = List.of(
        new VehicleTraffic(timestamp, 10L),
        new VehicleTraffic(timestamp, 15L),
        new VehicleTraffic(timestamp, 5L),
        new VehicleTraffic(timestamp, 25L));

    Top3VehicleReportGenerator top3VehicleReportGenerator = new Top3VehicleReportGenerator();
    List<VehicleTraffic> topMost3VehicleTraffics = top3VehicleReportGenerator.findTopMost3TrafficsFrom(vehicles);

    assertThat(topMost3VehicleTraffics, IsIterableContainingInOrder.contains(
        new VehicleTraffic(timestamp, 25L),
        new VehicleTraffic(timestamp, 15L),
        new VehicleTraffic(timestamp, 10L)
    ));

  }

}