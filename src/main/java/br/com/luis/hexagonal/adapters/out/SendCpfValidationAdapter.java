package br.com.luis.hexagonal.adapters.out;

import br.com.luis.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutPutPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendCpfValidationAdapter.class);
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        LOGGER.error("Error sending CPF to Kafka", ex);
                        return;
                    }

                    var metadata = result.getRecordMetadata();
                    LOGGER.info(
                            "CPF sent to Kafka topic={}, partition={}, offset={}",
                            metadata.topic(),
                            metadata.partition(),
                            metadata.offset()
                    );
                });
    }
}
