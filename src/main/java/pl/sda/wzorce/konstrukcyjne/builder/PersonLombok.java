package pl.sda.wzorce.konstrukcyjne.builder;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
class PersonLombok {
    String name;
    String surname;
}
