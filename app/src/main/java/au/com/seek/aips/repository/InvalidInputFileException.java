package au.com.seek.aips.repository;

import java.io.Serial;

public class InvalidInputFileException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = -2646276214059526341L;

  public InvalidInputFileException(String message) {
    super(message);
  }
}
