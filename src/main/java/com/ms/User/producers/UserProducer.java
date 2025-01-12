package com.ms.User.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.User.dtos.EmailDto;
import com.ms.User.models.UserModel;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("{broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto(userModel.getUserId(), userModel.getEmail(), "Cadastyro Realizado com sucesso!",
                String.format("%S, seja bem vindo(a)! \nAgradecemos o seu cadastro", userModel.getName()));

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
