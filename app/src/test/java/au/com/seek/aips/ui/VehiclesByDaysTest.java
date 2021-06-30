package au.com.seek.aips.ui;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.PerDayTotalReportGenerator;
import au.com.seek.aips.report.TotalVehicleByDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class VehiclesByDaysTest {
  @Mock
  private PerDayTotalReportGenerator perDayTotalReportGenerator;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void shouldDisplayVehiclesCountByDays() throws Exception {
    VehiclesByDays vehiclesByDays = new VehiclesByDays(perDayTotalReportGenerator);
    List<VehicleTraffic> vehicles = List.of();
    List<TotalVehicleByDate> values = List.of(
        new TotalVehicleByDate(LocalDate.of(2021, Month.JUNE, 28), 10L),
        new TotalVehicleByDate(LocalDate.of(2021, Month.JUNE, 29), 20L)
    );
    when(perDayTotalReportGenerator.totalByDate(vehicles)).thenReturn(values);

    String text = tapSystemOut(() -> vehiclesByDays.displayTotalPerDayFrom(vehicles));

    String expectedOutput = """
        Number of cars by date
        2021-06-28 10
        2021-06-29 20
        """;
    assertThat(text, is(expectedOutput));
  }
}