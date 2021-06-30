package au.com.seek.aips.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.Top3VehicleReportGenerator;

class TopMost3MaxTrafficVehicles {

  private final Top3VehicleReportGenerator top3VehicleReportGenerator;

  TopMost3MaxTrafficVehicles(Top3VehicleReportGenerator top3VehicleReportGenerator) {
    this.top3VehicleReportGenerator = top3VehicleReportGenerator;
  }

  void display(List<VehicleTraffic> vehicles) {
    System.out.println("Top 3 high traffic records");
    List<VehicleTraffic> topMost3Traffics = top3VehicleReportGenerator.findTopMost3TrafficsFrom(vehicles);
    topMost3Traffics.forEach(vehicle -> {
      String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(vehicle.getTimestamp());
      System.out.printf("%s %d%n", date, vehicle.getCount());
    });
  }
}
