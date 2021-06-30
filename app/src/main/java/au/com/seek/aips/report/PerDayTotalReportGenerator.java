package au.com.seek.aips.report;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import au.com.seek.aips.entity.VehicleTraffic;

public class PerDayTotalReportGenerator {

  public List<TotalVehicleByDate> totalByDate(List<VehicleTraffic> vehicles) {
    Map<LocalDate, Long> totalReportMap = vehicles.stream()
        .map(vehicle -> new TotalVehicleByDate(
            vehicle.getTimestamp().toLocalDate(),
            vehicle.getCount()))
        .collect(groupingBy(
            vehicle -> vehicle.getDate(),
            summingLong(vehicle -> vehicle.getCount())));

    return listOf(totalReportMap);
  }

  private List<TotalVehicleByDate> listOf(Map<LocalDate, Long> totalReportMap) {
    return totalReportMap.entrySet().stream()
        .map(entry -> new TotalVehicleByDate(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }
}
