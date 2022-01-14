package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import java.util.UUID;
import com.senecafoundation.virtualstoreweb.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, UUID> {   
}