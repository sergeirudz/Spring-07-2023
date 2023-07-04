package ee.sergei.lemmikloomad.repositories;

import ee.sergei.lemmikloomad.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


/*
CrudRepository<Pet, String>
JpaRepository<Pet, String>
SortingAndPageableRepository<Pet, String>
*/
public interface PetRepository extends JpaRepository<Pet, String>{

}
