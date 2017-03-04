# Query Language

NOTE: it is ported from the [Golang version](https://github.com/xephonhq/tsdb-ql/blob/master/doc/spec-draft/query_language.md)

## 0.0.1

````
// single line comment
/* multi line comment */
// TODO: how to allow expression cross multiple lines

// built in time function, they can be run in shell directly, which is handy
// the underlying storage is all nanoseconds, don't support time zone
today()
tomorrow()
today() + 1d // arith operations for date
today() + 1s // excited

// built in arith operation
// TODO: support for brackets and other predence
1 + 1
1 * 2

// variable, need to explictly say type
var x:date = today()
x + 1d

// the best way to debug
print(x)
die("give me a reason") // PHP is the best language

// SQL operations
// NOTE: there is no FROM
// TODO: handle moving average, how to group different series
select "cpu.load" where "region" == "en-us" and start = yesterday() group by "instance"
select "cpu.load" where "region" == "en-us" and "os" == "windows" and val > 20 group by "instance"
// translated to different database API calls and extra operations

// some is handled by database, some is handled by proxy
// TODO: the graph operation
````
## Change log

From newest to oldest

- The new idea is to combine R and SQL, because R can be used to generate time series data and draw graph

## Ref

- [Translating between monitoring languages](https://www.robustperception.io/translating-between-monitoring-languages/)
- Netflix Atlas https://github.com/Netflix/atlas/wiki/Stack%20Language
- KaiorsDB https://github.com/kairosdb/kairosdb/wiki/Kairos-Timeseries-Query-Language-(TQL)
- SparkQL
  - Grammar file https://github.com/apache/spark/blob/master/sql/catalyst/src/main/antlr4/org/apache/spark/sql/catalyst/parser/SqlBase.g4
  - AST Builder https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/parser/AstBuilder.scala
  - Types https://github.com/apache/spark/tree/master/sql/catalyst/src/main/scala/org/apache/spark/sql/types
  - Expressions https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/expressions/arithmetic.scala
  - Optimizer https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/optimizer/Optimizer.scala
  - Optimize rules https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/optimizer/expressions.scala
  - SparkQL https://databricks.com/blog/2015/04/13/deep-dive-into-spark-sqls-catalyst-optimizer.html
  - Data frame https://databricks.com/blog/2015/02/17/introducing-dataframes-in-spark-for-large-scale-data-science.html
- Prometheus
  - PromQL is Turing Complete https://www.robustperception.io/conways-life-in-prometheus/
  - https://prometheus.io/docs/querying/api/
    - curl 'http://localhost:9090/api/v1/query_range?query=up&start=2015-07-01T20:10:30.781Z&end=2015-07-01T20:11:00.781Z&step=15s'
    - expression
    - start
    - end
    - step (Query resolution step width)
  - expression
    - `http_requests_total{environment=~"staging|testing|development",method!="GET"}`
      - =, !=, =~, !~ (regexp)
      - `{job=~".*"} # Bad!` this matches empty string
    - Range Vector Selectors
      - [ ] TODO: difference between offset with start, end in http API
      - https://github.com/prometheus/prometheus/issues/529
  - [ ] operator https://prometheus.io/docs/querying/operators/
  - [ ] functions https://prometheus.io/docs/querying/functions/
- A modern subset of the range query language https://github.com/square/grange
- Graphite http://graphite.readthedocs.io/en/latest/functions.html#usage

### Python

- http://www.pyflux.com/ provides several models

### R

R for time series

- https://cran.r-project.org/web/views/TimeSeries.html
- http://www.statmethods.net/advstats/timeseries.html
- http://a-little-book-of-r-for-time-series.readthedocs.io/en/latest/index.html

R with Java

- https://github.com/bedatadriven/renjin
- https://github.com/s-u/rJava

R and QL

- [R as a Query Language – Database optimizations applied to R](http://www.bedatadriven.com/research/r-as-a-query-language.html)
