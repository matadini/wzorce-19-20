package pl.sda.wzorce.strukturalne.adapter;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class ModernServiceAdapter implements ModernService {

    private final OldService oldService;

    @Override
    public int addition(List<Integer> data) {
        return 0;
    }

    @Override
    public void renderData(Person person) {
        oldService.showPerson(person.getName(), person.getSurname());
    }
}
