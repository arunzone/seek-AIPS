package au.com.seek.aips.report;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

class PerDayTotalReportGeneratorTest {

  @Test
  public void shouldReturnTotalCarsForOneDay() {
    PerDayTotalReportGenerator perDayTotalReportGenerator = new PerDayTotalReportGenerator();
    List<VehicleTraffic> vehicles = List.of(
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 0), 15L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 0), 25L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 14, 0), 13L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 14, 0), 12L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 15, 30), 10L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 15, 30), 20L));

    List<TotalVehicleByDate> report = perDayTotalReportGenerator.totalByDate(vehicles);

    assertThat(report, IsIterableContainingInOrder.contains(
        new TotalVehicleByDate(LocalDate.of(2021, Month.JUNE, 29), 95L))
    );
  }

  @Test
  public void shouldReturnTotalCarsForEachDay() {
    PerDayTotalReportGenerator perDayTotalReportGenerator = new PerDayTotalReportGenerator();
    List<VehicleTraffic> vehicles = List.of(
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 0), 15L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 13, 0), 25L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 29, 14, 0), 13L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 14, 0), 12L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 15, 30), 10L),
        new VehicleTraffic(LocalDateTime.of(2021, Month.JUNE, 30, 16, 30), 20L));

    List<TotalVehicleByDate> report = perDayTotalReportGenerator.totalByDate(vehicles);

    assertThat(report, IsIterableContainingInAnyOrder.containsInAnyOrder(
        new TotalVehicleByDate(LocalDate.of(2021, Month.JUNE, 29), 53L),
        new TotalVehicleByDate(LocalDate.of(2021, Month.JUNE, 30), 42L))
    );
  }
}