package au.com.seek.aips.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.PerDayTotalReportGenerator;
import au.com.seek.aips.report.TotalVehicleByDate;

public class VehiclesByDays {

  private final PerDayTotalReportGenerator perDayTotalReportGenerator;

  public VehiclesByDays(PerDayTotalReportGenerator perDayTotalReportGenerator) {
    this.perDayTotalReportGenerator = perDayTotalReportGenerator;
  }

  public void displayTotalPerDayFrom(List<VehicleTraffic> vehicles) {
    System.out.println("\nNumber of cars by date");
    List<TotalVehicleByDate> totalVehicleByDates = perDayTotalReportGenerator.totalByDate(vehicles);
    totalVehicleByDates.forEach(vehicle -> {
      String date = DateTimeFormatter.ISO_LOCAL_DATE.format(vehicle.getDate());
      System.out.printf("%s %d%n", date, vehicle.getCount());
    });
  }
}
