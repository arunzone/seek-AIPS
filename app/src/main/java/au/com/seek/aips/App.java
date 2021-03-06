package au.com.seek.aips;

import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.LeastVehiclesOnContiguous3RecordsReportGenerator;
import au.com.seek.aips.report.PerDayTotalReportGenerator;
import au.com.seek.aips.report.Top3VehicleReportGenerator;
import au.com.seek.aips.report.TotalReportGenerator;
import au.com.seek.aips.repository.FileRepository;
import au.com.seek.aips.ui.LeastVehiclesOn3ContiguousRecords;
import au.com.seek.aips.ui.TopMost3MaxTrafficVehicles;
import au.com.seek.aips.ui.TotalVehicles;
import au.com.seek.aips.ui.VehiclesByDays;

public class App {
  public static void main(String[] args) {
    new App().processTrafficCount();
  }

  private void processTrafficCount() {
    FileRepository fileRepository = new FileRepository();
    List<VehicleTraffic> vehicleTraffics = fileRepository.read();
    new TotalVehicles(new TotalReportGenerator()).displayTotalFor(vehicleTraffics);
    new VehiclesByDays(new PerDayTotalReportGenerator()).displayTotalPerDayFrom(vehicleTraffics);
    new TopMost3MaxTrafficVehicles(new Top3VehicleReportGenerator()).display(vehicleTraffics);
    new LeastVehiclesOn3ContiguousRecords(
        new LeastVehiclesOnContiguous3RecordsReportGenerator()).display(vehicleTraffics);
  }
}
