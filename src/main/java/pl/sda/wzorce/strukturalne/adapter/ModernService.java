package pl.sda.wzorce.strukturalne.adapter;

import java.util.List;

interface ModernService {
    int addition(List<Integer> data);

    void renderData(Person person);
}
