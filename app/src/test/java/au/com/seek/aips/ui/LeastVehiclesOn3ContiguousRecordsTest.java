package au.com.seek.aips.ui;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.LeastVehiclesOnContiguous3RecordsReportGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LeastVehiclesOn3ContiguousRecordsTest {

  @Mock
  private LeastVehiclesOnContiguous3RecordsReportGenerator reportGenerator;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void shouldDisplayLeast3ContiguousRecords() throws Exception {
    LeastVehiclesOn3ContiguousRecords leastVehiclesOn3ContiguousRecords =
        new LeastVehiclesOn3ContiguousRecords(reportGenerator);
    List<VehicleTraffic> vehicles = List.of();
    LocalDateTime date28th = LocalDateTime.of(2021, Month.JUNE, 28, 13, 0);
    LocalDateTime date29th = LocalDateTime.of(2021, Month.JUNE, 29, 13, 0);
    LocalDateTime date30th = LocalDateTime.of(2021, Month.JUNE, 30, 13, 30);
    List<VehicleTraffic> top3vehicles = List.of(
        new VehicleTraffic(date28th, 15L),
        new VehicleTraffic(date29th, 20L),
        new VehicleTraffic(date30th, 25L));
    when(reportGenerator.findLeastTrafficOn3Contiguous(vehicles)).thenReturn(top3vehicles);

    String text = tapSystemOut(() -> leastVehiclesOn3ContiguousRecords.display(vehicles));

    assertThat(text, is("""
                
        Least traffic 3 contiguous records
        2021-06-28T13:00:00 15
        2021-06-29T13:00:00 20
        2021-06-30T13:30:00 25
        """));
  }


}