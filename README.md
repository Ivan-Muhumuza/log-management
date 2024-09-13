# Spring Boot + ELK Stack

[loom-video-link](https://www.loom.com/share/e7af6a0bb190480a8a36e6d92d0e81c9)

## How to Run the Project

### 1. Configure Spring Boot Logging

- The project uses **Logback** as the logging framework, and the configuration is stored in `src/main/resources/logback-spring.xml`.
- Logs are structured to include useful metadata like log levels, timestamps, and custom fields (e.g., user actions).
- Logs are sent to both the console and Logstash for centralized processing.

### 2. Set Up the ELK Stack

1. **Elasticsearch**: Stores and indexes the log data.
2. **Logstash**: Processes and sends the logs to Elasticsearch.
3. **Kibana**: Visualizes the logs.

### 3. Configure Logstash Pipeline

The `logstash.conf` file defines the pipeline for receiving and processing Spring Boot logs.


### 4. Integrate Logs with ELK Stack

Once the ELK stack is running, your Spring Boot application will automatically send logs to Logstash, which forwards them to Elasticsearch for indexing.

---

## How to Run
`After installing Elasticsearch, logstash & Kibana`

### 1. Start ELK Stack
Run the following command to start the ELK stack:


- **Elasticsearch**: The search engine that indexes log data.
   - Start Elasticsearch using the command:
     ```bash
     ./bin/elasticsearch
     ```

- **Logstash**: Used to collect, parse, and transform log data before indexing it in Elasticsearch.
   - Start Logstash using the command:
     ```bash
     ./bin/logstash -f logstash.conf
     ```

- **Kibana**: The visualization tool for querying and displaying logs.
   - Start Kibana using the command:
     ```bash
     ./bin/kibana
     ```
`NB: the file paths above should match the directories where they have been installed on your local PC`

### 2. Run Spring Boot Application
You can start the Spring Boot application with Maven:

```bash
mvn spring-boot:run
```

### 3. Trigger Logs
Call the `/log` endpoint to generate logs:

```bash
http://localhost:8080/log
```

This will generate logs that are sent to Logstash, then to Elasticsearch.

---

## Visualizing Logs in Kibana

1. Open Kibana in your browser at `http://localhost:5601`.
2. Go to **Management > Index Patterns** and create a new pattern matching `myapp-logs-*`.
3. Navigate to the **Discover** tab to see the logs.
4. You can also create **Visualizations** and **Dashboards** to analyze the logs.

