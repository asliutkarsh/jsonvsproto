package com.asliutkarsh.jsonvsproto;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asliutkarsh.protobuf.UserProto;

@SpringBootApplication
public class JsonvsprotoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JsonvsprotoApplication.class, args);
		    UserProto.User user = UserProto.User.newBuilder()
                .setName("John Doe")
                .setEmail("john@example.com")
                .setAge(25)
                .build();

        try (FileOutputStream output = new FileOutputStream("user.bin")) {
            user.writeTo(output);
            System.out.println("Binary file created: user.bin");
        }
	}

}
