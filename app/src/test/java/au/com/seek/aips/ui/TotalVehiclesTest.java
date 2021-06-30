package au.com.seek.aips.ui;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.TotalReportGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TotalVehiclesTest {
  @Mock
  private TotalReportGenerator totalReportGenerator;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void shouldReturnTotalNumberOfVehicles() throws Exception {
    TotalVehicles totalVehicles = new TotalVehicles(totalReportGenerator);
    List<VehicleTraffic> vehicles = List.of();
    when(totalReportGenerator.totalOf(vehicles)).thenReturn(10L);

    String text = tapSystemOut(() -> totalVehicles.displayTotalFor(vehicles));

    assertThat(text, is("Total number of cars: 10\n"));
  }
}