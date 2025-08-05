package com.main.project_socket;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.service.ProfileServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.main.project_socket.repository.ProfileRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProjectSocketApplicationTests {

	@Mock
	private ProfileRepository repository;

	@InjectMocks
	private ProfileServices profileServices;

	@Test
	void testGetUser() {
		Profile profile = new Profile(8L, "kiko", "kiko@gmail.com", "12345678", "1234567890");
		when(repository.findById(8L)).thenReturn(Optional.of(profile));

		// Act
		Profile result = profileServices.getProfileById(8L);

		// Assert
		assertEquals(profile.getName(), result.getName());
	}

}
