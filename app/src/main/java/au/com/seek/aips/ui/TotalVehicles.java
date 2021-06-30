package au.com.seek.aips.ui;

import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.TotalReportGenerator;

class TotalVehicles {
  private final TotalReportGenerator totalReportGenerator;

  TotalVehicles(TotalReportGenerator totalReportGenerator) {
    this.totalReportGenerator = totalReportGenerator;
  }

  void displayTotalFor(List<VehicleTraffic> vehicles) {
    Long total = totalReportGenerator.totalOf(vehicles);
    System.out.printf("Total number of cars: %d%n", total);
  }
}
