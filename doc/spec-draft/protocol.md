# Protocol Draft


Prometheus

- https://github.com/prometheus/prometheus/blob/master/storage/remote/remote.proto

````
syntax = "proto3";

package remote;

message Sample {
  double value       = 1;
  int64 timestamp_ms = 2;
}

message LabelPair {
  string name  = 1;
  string value = 2;
}

message TimeSeries {
  repeated LabelPair labels = 1;
  // Sorted by time, oldest sample first.
  repeated Sample samples   = 2;
}

message WriteRequest {
  repeated TimeSeries timeseries = 1;
}
````
