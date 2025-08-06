package br.com.desafio.codecon.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    @JsonProperty("timestamp")
    private Instant timestamp;

    @JsonProperty("execution_time_ms")
    private Long executionTimeMs;

    private T data;

    public ApiResponse(T data, Instant startTime) {
        this.timestamp = Instant.now();
        this.executionTimeMs = Duration.between(startTime, timestamp).toMillis();
        this.data = data;
    }

}
