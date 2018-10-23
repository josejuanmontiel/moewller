package hello.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerMoRepository extends CrudRepository<CustomerMo, Long> {

    List<CustomerMo> findByLastName(String lastName);
}