package Home;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pets")
public class HomeController {

    @Autowired
    private PersRepository repository;

    private final static Logger LOGGER = Logger.getLogger(HomeController.class.getName());


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        LOGGER.warning("New message 2");
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.set_id(ObjectId.get());
        repository.save(pets);
        return pets;
    }
}

