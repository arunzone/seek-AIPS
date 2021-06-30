package au.com.seek.aips.ui;

import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.TotalReportGenerator;

public class TotalVehicles {
  private final TotalReportGenerator totalReportGenerator;

  public TotalVehicles(TotalReportGenerator totalReportGenerator) {
    this.totalReportGenerator = totalReportGenerator;
  }

  public void displayTotalFor(List<VehicleTraffic> vehicles) {
    Long total = totalReportGenerator.totalOf(vehicles);
    System.out.printf("Total number of cars: %d%n", total);
  }
}
