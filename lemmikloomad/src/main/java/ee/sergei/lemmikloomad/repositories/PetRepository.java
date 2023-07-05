package ee.sergei.lemmikloomad.repositories;
import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/*
CrudRepository<Pet, String>
JpaRepository<Pet, String>
SortingAndPageableRepository<Pet, String>
*/
public interface PetRepository extends JpaRepository<Pet, String>{
    Pet findByPetName(String petName);
    Pet findByOwner(Owner owner);
    List<Pet> findAllByOwner(Owner owner);
}
