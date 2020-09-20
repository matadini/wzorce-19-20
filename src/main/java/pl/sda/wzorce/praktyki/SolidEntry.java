package pl.sda.wzorce.praktyki;

import lombok.Data;

import java.util.List;

// solid: to jest lamanie S
@Data
public class SolidEntry {
    Integer id;
    String name;
    String surname;

    List<SolidEntry> findById() {
        return null; // udaje ze pobieram z bazy
    }
}

// to jest ok
class SolidEntry2 {
    Integer id;
    String name;
    String surname;
}
class SolidEntryRepository {
    List<SolidEntry> findById() {
        return null; // udaje ze pobieram z bazy
    }
}



